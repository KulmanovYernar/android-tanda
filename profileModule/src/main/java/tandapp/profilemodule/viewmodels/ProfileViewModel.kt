package tandapp.profilemodule.viewmodels

import android.content.Context
import android.net.Uri
import android.os.Build
import android.util.Log
import android.webkit.MimeTypeMap
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.profile.ProfileRepository
import domain.profile.models.FileModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ProfileViewModel(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    val profileInfo: MutableState<ProfileModel?> = mutableStateOf(null)
    val firstName:MutableState<String> = mutableStateOf("")
    val lastName:MutableState<String> = mutableStateOf("")

    init {
        getProfileInfo()
    }


    fun onFirstNameChange(value: String){
        firstName.value = value
    }
    fun onLastNameChange(value: String){
        lastName.value = value
    }

    fun uploadProfileImage(file: FileModel) {
        viewModelScope.launch {
            profileRepository.uploadProfileImage(file)
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        Log.d("ProfileViewModel", "uploadProfileImage: success")
                    }
                }
        }
    }

    fun getProfileInfo() {
        viewModelScope.launch {
            profileRepository.getProfileInfo()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        profileInfo.value = result
                    }
                }
        }
    }


    fun updateProfileInfo() {
        viewModelScope.launch {
            profileRepository.updateProfileInfo(firstName = firstName.value, lastName = lastName.value)
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        getProfileInfo()
                    }
                }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun fileFromContentUri(context: Context, contentUri: Uri): File {

        val fileExtension = getFileExtension(context, contentUri)
        val fileName = "temporary_file" + if (fileExtension != null) ".$fileExtension" else ""

        val tempFile = File(context.cacheDir, fileName)
        tempFile.createNewFile()

        try {
            val oStream = FileOutputStream(tempFile)
            val inputStream = context.contentResolver.openInputStream(contentUri)

            inputStream?.let {
                copy(inputStream, oStream)
            }

            oStream.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return tempFile
    }

    private fun getFileExtension(context: Context, uri: Uri): String? {
        val fileType: String? = context.contentResolver.getType(uri)
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(fileType)
    }

    @Throws(IOException::class)
    private fun copy(source: InputStream, target: OutputStream) {
        val buf = ByteArray(8192)
        var length: Int
        while (source.read(buf).also { length = it } > 0) {
            target.write(buf, 0, length)
        }
    }
}
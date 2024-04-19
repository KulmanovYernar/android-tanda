package tandapp.homemodule.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.profile.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val profileRepository: ProfileRepository
) : ViewModel() {
    val imageId: MutableState<Int?> = mutableStateOf(null)
    init {
        refreshAll()
    }

    fun getProfileInfo() {
        viewModelScope.launch {
            profileRepository.getProfileInfo()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        imageId.value = result?.blobId ?: 2
                        Log.d("Profile", "getProfileInfo: asd")
                    }
                }
        }
    }

    fun getProfileImage() {
        viewModelScope.launch {
            profileRepository.getProfileImage(imageId.value ?: 2)
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        Log.d("Profile", "getProfileInfo: asd")
                    }
                }
        }
    }

    fun refreshAll(){
        getProfileInfo()
        getProfileImage()
    }
}
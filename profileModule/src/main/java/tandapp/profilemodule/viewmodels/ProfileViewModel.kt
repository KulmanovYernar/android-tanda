package tandapp.profilemodule.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.profile.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileRepository: ProfileRepository
):ViewModel() {

    fun uploadProfileImage(file:String){
        viewModelScope.launch {
            profileRepository.uploadProfileImage(file)
                .flowOn(Dispatchers.IO)
                .collect{
                    it.onSuccess {
                        Log.d("ProfileViewModel", "uploadProfileImage: success")
                    }
                }
        }
    }
}
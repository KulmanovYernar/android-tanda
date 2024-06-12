package tandapp.profilemodule.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.backet.BacketRepository
import domain.backet.models.BacketItemModel
import domain.catalog.ProductRepository
import domain.profile.ProfileRepository
import domain.profile.models.FileModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import tandapp.utillibrary.ProductModel

class ProfileViewModel(
    private val profileRepository: ProfileRepository,
    private val productRepository: ProductRepository,
    private val backetRepository: BacketRepository,
) : ViewModel() {

    val profileInfo: MutableState<ProfileModel?> = mutableStateOf(null)
    val firstName: MutableState<String> = mutableStateOf("")
    val lastName: MutableState<String> = mutableStateOf("")

    val wishList: MutableState<List<ProductModel>> = mutableStateOf(emptyList())
    val isLoading = mutableStateOf(false)

    init {
        getProfileInfo()
        getWishList()
    }


    fun onFirstNameChange(value: String) {
        firstName.value = value
    }

    fun onLastNameChange(value: String) {
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

    fun getWishList() {
        viewModelScope.launch {
            profileRepository.getWishList()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        wishList.value = result ?: emptyList()
                    }
                }
        }
    }


    fun updateProfileInfo() {
        viewModelScope.launch {
            profileRepository.updateProfileInfo(
                firstName = firstName.value,
                lastName = lastName.value
            )
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        getProfileInfo()
                    }
                }
        }
    }

    fun addOrDeleteItemWishList(id: Int) {
        viewModelScope.launch {
            productRepository.addProductToWishList(id)
                .flowOn(Dispatchers.IO)
                .collect {
                    isLoading.value = it.isLoading()
                    it.onSuccess {
                        getWishList()
                    }
                }
        }
    }

    fun addProductToBacket(id: Int) {
        viewModelScope.launch {
            backetRepository.addProductToBasket(BacketItemModel(id))
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        getWishList()
                    }
                }
        }
    }


}
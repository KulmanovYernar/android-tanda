package tandapp.homemodule.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.backet.BacketRepository
import domain.backet.models.BacketItemModel
import domain.catalog.ProductRepository
import domain.profile.ProfileRepository
import domain.profile.models.ProfileModel
import tandapp.utillibrary.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val profileRepository: ProfileRepository,
    private val productRepository: ProductRepository,
    private val backetRepository: BacketRepository,

    ) : ViewModel() {
    val imageId: MutableState<Int?> = mutableStateOf(null)


    val products: MutableState<List<ProductModel>?> = mutableStateOf(null)

    val profileInfo: MutableState<ProfileModel?> = mutableStateOf(null)

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
                        profileInfo.value = result
//                        imageId.value = result?.blobId ?: 2
//                        Log.d("Profile", "getProfileInfo: asd")
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


    fun getProductsPreview() {
        viewModelScope.launch {
            productRepository.getProductsPreview()
                .flowOn(Dispatchers.IO)
                .collect {
                    it.onSuccess {
                        val result = it
                        products.value = result
                    }
                }
        }
    }


    fun refreshAll() {
        getProfileInfo()
//        getProfileImage()
        getProductsPreview()
    }
}
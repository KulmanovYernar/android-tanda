package domain.profile

import domain.profile.models.FileModel
import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event
import tandapp.utillibrary.ProductModel

class ProfileRepositoryImpl(private val dataSource: ProfileService): ProfileRepository {

    override suspend fun changeProfileImage(id: Int, file: FileModel): Flow<Event<Unit>> = flow {
        emit(Event.loading())

        val response = dataSource.changeProfileImage(id, file)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun uploadProfileImage(file: FileModel): Flow<Event<Unit>> = flow {
        emit(Event.loading())
//        val requestFile =
//            file.asRequestBody(contentType = "multipart/form-data".toMediaTypeOrNull())
//
//        val fileRequestBody: MultipartBody.Part =
//            MultipartBody.Part.createFormData("file", file.name, requestFile)

        val response = dataSource.uploadProfileImage(file)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }
    override suspend fun updateProfileInfo(firstName: String, lastName: String): Flow<Event<Unit>> = flow {
        emit(Event.loading())

        val response = dataSource.updateProfileInfo(firstName, lastName)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }
    override suspend fun getProfileInfo(): Flow<Event<ProfileModel>> = flow {
        emit(Event.loading())

        val response = dataSource.getProfileInfo()

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun getProfileImage(id: Int): Flow<Event<ProfileImageModel>> = flow {
        emit(Event.loading())

        val response = dataSource.getProfileImage(id)

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }

    override suspend fun getWishList(): Flow<Event<List<ProductModel>>> = flow {
        emit(Event.loading())

        val response = dataSource.getWishList()

        if (response.isSuccessful) emit(Event.success(response.body()))
        else emit(Event.error(response.message()))
    }
}
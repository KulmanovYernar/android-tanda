package domain.profile

import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tandapp.domain.event.Event

class ProfileRepositoryImpl(val dataSource: ProfileService): ProfileRepository {
    override suspend fun changeProfileImage(id: Int, file: String): Flow<Event<Unit>> = flow {

    }

    override suspend fun uploadProfileImage(file: String): Flow<Event<Unit>> = flow {

    }
    override suspend fun updateProfileInfo(firstName: String, lastName: String): Flow<Event<Unit>> = flow {

    }
    override suspend fun getProfileInfo(): Flow<Event<ProfileModel>> = flow {

    }

    override suspend fun getProfileImage(id: String): Flow<Event<ProfileImageModel>> = flow {

    }

}
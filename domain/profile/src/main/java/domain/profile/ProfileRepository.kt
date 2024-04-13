package domain.profile

import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event

interface ProfileRepository {
    suspend fun changeProfileImage(id:Int, file:String): Flow<Event<Unit>>

    suspend fun uploadProfileImage(file:String): Flow<Event<Unit>>

    suspend fun updateProfileInfo(firstName:String, lastName:String): Flow<Event<Unit>>

    suspend fun getProfileInfo(): Flow<Event<ProfileModel>>

    suspend fun getProfileImage(id:String): Flow<Event<ProfileImageModel>>

}
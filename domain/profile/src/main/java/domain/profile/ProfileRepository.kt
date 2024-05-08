package domain.profile

import domain.profile.models.FileModel
import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import kotlinx.coroutines.flow.Flow
import tandapp.domain.event.Event
import java.io.File

interface ProfileRepository {
    suspend fun changeProfileImage(id:Int, file: FileModel): Flow<Event<Unit>>

    suspend fun uploadProfileImage(file: FileModel): Flow<Event<Unit>>

    suspend fun updateProfileInfo(firstName:String, lastName:String): Flow<Event<Unit>>

    suspend fun getProfileInfo(): Flow<Event<ProfileModel>>

    suspend fun getProfileImage(id:Int): Flow<Event<ProfileImageModel>>

}
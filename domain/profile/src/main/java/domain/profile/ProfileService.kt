package domain.profile

import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {
    @PUT("customer")
    suspend fun changeProfileImage(@Query("id") id:Int, @Query("file") file:String): Response<Unit>

    @POST("customer/blobs/upload")
    suspend fun uploadProfileImage(@Query("file") file: MultipartBody.Part): Response<Unit>

    @GET("customer/update_info/{firstName}/{lastName}")
    suspend fun updateProfileInfo(@Path("firstName") firstName:String, @Path("lastName") lastName:String): Response<Unit>

    @GET("customer/get_user_info")
    suspend fun getProfileInfo(): Response<ProfileModel>

    @GET("customer/blobs/get_by_id/{id}")
    suspend fun getProfileImage(@Path("id") id:Int): Response<ProfileImageModel>
}
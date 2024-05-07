package domain.profile

import domain.profile.models.FileModel
import domain.profile.models.ProfileImageModel
import domain.profile.models.ProfileModel
import domain.profile.models.WishListModel
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {
    @PUT("customer/blobs/update/{id}")
    suspend fun changeProfileImage(@Path("id") id:Int, @Body file: FileModel): Response<Unit>

    @POST("customer/blobs/upload")
    suspend fun uploadProfileImage(@Body file: FileModel): Response<Unit>

    @GET("customer/update_info")
    suspend fun updateProfileInfo(@Query("firstName") firstName:String, @Query("lastName") lastName:String): Response<Unit>

    @GET("customer/get_user_info")
    suspend fun getProfileInfo(): Response<ProfileModel>

    @GET("customer/blobs/get_by_id/{id}")
    suspend fun getProfileImage(@Path("id") id:Int): Response<ProfileImageModel>

    @GET("customer/wish_list")
    suspend fun getWishList(): Response<WishListModel>
}
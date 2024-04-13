package domain.profile.models

import androidx.annotation.Keep

@Keep
data class ProfileModel(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val blobId: Int?,
)

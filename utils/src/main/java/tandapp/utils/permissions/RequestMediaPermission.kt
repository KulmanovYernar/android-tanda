package tandapp.utils.permissions

import android.os.Build
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestMediaPermission(onPermissionGranted: () -> Unit, onPermissionDenied: () -> Unit) {

    val scope = rememberCoroutineScope()

    // Camera permission state
    val permissionState = rememberPermissionState(
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.S_V2) android.Manifest.permission.READ_MEDIA_IMAGES else android.Manifest.permission.READ_EXTERNAL_STORAGE, onPermissionResult = {
            if (it) onPermissionGranted() else onPermissionDenied()
        }
    )

    LaunchedEffect(key1 = permissionState.status) {
        when (permissionState.status) {
            // If the camera permission is granted, then show screen with the feature enabled
            PermissionStatus.Granted -> {
                onPermissionGranted()
            }

            is PermissionStatus.Denied -> {
                Log.e("TAG", "RequestStoragePermission: launching permission", )
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.S_V2) {
                    onPermissionGranted()
                } else {
                    permissionState.launchPermissionRequest()
                }
            }
        }
    }
}

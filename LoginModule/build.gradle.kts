plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "tandapp.loginmodule"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
//    implementation(projects.domain)
//    implementation(projects.tandaApp)
    implementation(projects.navigationModule)
    implementation(projects.utillibrary)
    implementation(projects.icons)
    implementation(projects.utils)
    implementation(projects.domain.auth)
    implementation(projects.domain.event)

    implementation(libs.androidx.ktx)
    implementation(libs.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material)
    implementation(libs.compose.ui)
    implementation(libs.koin.compose)
//    implementation(libs.koin.android)
//    implementation(libs.koin.core)
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //koin
//    implementation ("io.insert-koin:koin-androidx-compose:3.2.1")


//    //Compose
//    implementation ("androidx.compose.ui:ui:$compose_ui_version")
//    implementation ("androidx.compose.material:material:$compose_material_version")
//    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_ui_version")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
//    implementation ("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleViewModelVersion")
//    implementation ("androidx.activity:activity-compose:$composeActivityVersion")
//    implementation ("androidx.compose.runtime:runtime-livedata:$composeLiveDataVersion")
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleViewModelVersion")
//    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_version")
//    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")
//
//    //Navigation
//    implementation("androidx.navigation:navigation-compose:$navigationVersion")
//
//    //Viewpager
//    implementation ("com.google.accompanist:accompanist-pager:$accompanistPagerVersion")
//    //Permission
//    implementation ("com.google.accompanist:accompanist-permissions:$accompanistPermissionsVersion")
//    //OzForensics
//    implementation ("com.ozforensics.liveness:full:$livenessVersion")
//    //Lottie
//    implementation ("com.airbnb.android:lottie-compose:$lottieVersion")
//
//    //Coil for load image
//    implementation("io.coil-kt:coil-compose:$coilVersion")
//
//
//    //Biometric
//    implementation ("androidx.biometric:biometric:1.2.0-alpha04")
//
//    // Koin for injection to composable
//    implementation ("io.insert-koin:koin-androidx-compose:$koin_version")
}
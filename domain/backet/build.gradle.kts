plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "domain.backet"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(projects.domain.event)
    implementation(projects.domain.retrofit)

    implementation(libs.androidx.ktx)
    implementation(libs.appcompat)
    implementation(libs.com.google.android.material.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)


    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //converter-gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //okhttp3
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Koin core features
    implementation ("io.insert-koin:koin-core:3.2.1")
    // Koin features for Android
    implementation ("io.insert-koin:koin-android:3.2.1")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
}
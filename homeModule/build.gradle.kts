plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "tandapp.homemodule"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation(projects.utillibrary)
    implementation(projects.navigationModule)
    implementation(projects.icons)
    implementation(projects.backetModule)
    implementation(projects.profileModule)
    implementation(projects.catalogModule)
    implementation(projects.chatModule)
    implementation(projects.loginModule)
    implementation(projects.utils)

    implementation(libs.androidx.ktx)
    implementation(libs.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material)
    implementation(libs.compose.ui)
    implementation(libs.koin.compose)
//    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.google.accompanist:accompanist-flowlayout:0.32.0")
    testImplementation("org.testng:testng:6.9.6")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
}
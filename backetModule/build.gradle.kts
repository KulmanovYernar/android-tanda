plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "tandapp.backetmodule"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
    implementation(projects.domain.event)

    implementation(libs.androidx.ktx)
    implementation(libs.appcompat)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.material)
    implementation(libs.compose.ui)
    implementation(libs.koin.compose)
    implementation(project(":domain:catalog"))
    implementation(project(":domain:backet"))
    implementation(libs.androidx.ui.tooling.preview.android)
    androidTestImplementation(libs.espresso.core)
    //Coil for load image
    implementation("io.coil-kt:coil-compose:2.6.0")

    implementation ("androidx.compose.ui:ui-util:1.6.1")
    debugImplementation(libs.androidx.ui.tooling)
}
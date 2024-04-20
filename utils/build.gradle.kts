plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}
android {
    namespace = "tandapp.utils"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "SERVER_URL", "\"http://91.147.105.187:9000/\"")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "SERVER_URL", "\"http://91.147.105.187:9000/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.ktx)
    implementation(libs.appcompat)
    implementation(libs.koin.compose)
    implementation(libs.compose.ui)
    implementation(libs.material)
    testImplementation("org.testng:testng:6.9.6")
    implementation ("androidx.startup:startup-runtime:1.0.0")

    //Permission
    implementation ("com.google.accompanist:accompanist-permissions:0.32.0")

    //System UI
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    //Coil for load image
    implementation("io.coil-kt:coil-compose:2.6.0")


    implementation ("com.google.code.gson:gson:2.9.0")
}
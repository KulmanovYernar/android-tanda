plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.tandaapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tandaapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

    dependencies {
        implementation(projects.icons)
        implementation(projects.utils)
        implementation(projects.catalogModule)
        implementation(projects.navigationModule)
        implementation(projects.loginModule)
        implementation(projects.utillibrary)
        implementation(projects.homeModule)
        implementation(projects.backetModule)
        implementation(projects.profileModule)
        implementation(projects.domain.retrofit)
        implementation(projects.domain.auth)
        implementation(projects.domain.profile)
        implementation(projects.domain.catalog)
//    implementation(projects.domain)
//    implementation(projects.tandaApp)
//    implementation(projects.app)

        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.ktx)
        implementation(libs.appcompat)
        implementation(libs.koin.compose)
        implementation(libs.compose.ui)
        implementation(libs.material)
        testImplementation("org.testng:testng:6.9.6")
        implementation ("androidx.startup:startup-runtime:1.0.0")

//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//    implementation("androidx.activity:activity-compose:1.5.1")
//    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    testImplementation("junit:junit:4.14-SNAPSHOT")
//    testImplementation("org.testng:testng:6.9.6")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")

    }
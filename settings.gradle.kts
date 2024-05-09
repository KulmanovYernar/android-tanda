pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs{
        create("libs"){
            from(files("gradle/wrapper/libs.versions.toml"))
        }
    }
}

rootProject.name = "TandaApp"
include(":app")
include(":backetModule")
include(":domain")
include(":catalogModule")
include(":chatModule")
include(":homeModule")
include(":icons")
include(":LoginModule")
include(":navigationModule")
include(":profileModule")
include(":utillibrary")
include(":utils")


enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":domain:auth")
include(":domain:retrofit")
include(":domain:event")
include(":domain:profile")
include(":domain:catalog")
include(":domain:backet")
include(":domain:chat")

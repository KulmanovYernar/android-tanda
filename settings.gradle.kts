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
include(":domain")
include(":homeModule")
include(":icons")
include(":navigationModule")
include(":LoginModule")
include(":utillibrary")


enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":domain:auth")

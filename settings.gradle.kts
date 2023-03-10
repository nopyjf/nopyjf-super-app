pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NopyJF My Android App"

// Core
include(":app")
include(":core")
include(":model")

// Service
include(":service-nutrients")

//Feature
include(":feature-nutrients")

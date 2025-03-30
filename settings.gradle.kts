pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        maven { url = uri("https://jitpack.io") }
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
}

rootProject.name = "Courses"
include(":app")
include(":feature:onboarding")
include(":feature:login")
include(":feature:home")
include(":feature:favorites")
include(":feature:account")
include(":core:presentation")
include(":core:common")
include(":core:ui")
include(":core:network")
include(":core:database")
include(":core:data")
include(":core:domain")
include(":core:navigation")
include(":feature:main")
include(":core:preferences")

plugins {
    alias(libs.plugins.courses.android.application)
    alias(libs.plugins.courses.hilt)
    alias(libs.plugins.courses.android.retrofit)
}

android {
    namespace = "com.shechkov.courses"

    defaultConfig {
        applicationId = "com.shechkov.courses"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.androidx.activity.ktx)

    implementation(project(":core:network"))
    implementation(project(":core:presentation"))
    implementation(project(":core:ui"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:navigation"))
    implementation(project(":core:preferences"))

    implementation(project(":feature:main"))
    implementation(project(":feature:home"))
    implementation(project(":feature:account"))
    implementation(project(":feature:favorites"))
    implementation(project(":feature:login"))
    implementation(project(":feature:onboarding"))

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.cicerone)

}
plugins {
    alias(libs.plugins.courses.android.application)
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

    implementation(project(":core:ui"))
    implementation(project(":feature:home"))
    implementation(project(":feature:account"))
    implementation(project(":feature:favorites"))
    implementation(project(":feature:login"))
    implementation(project(":feature:onboarding"))

    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

}
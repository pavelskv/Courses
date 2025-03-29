plugins {
    alias(libs.plugins.courses.android.feature)
}

android {
    namespace = "com.shechkov.feature.home"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(project(":core:presentation"))
    implementation(project(":core:domain"))

    implementation(libs.adapterdelegates)
    implementation(libs.adapterdelegates.viewbinding)
}
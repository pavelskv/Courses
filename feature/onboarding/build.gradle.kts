plugins {
    alias(libs.plugins.courses.android.feature)
}

android {
    namespace = "com.shechkov.feature.onboarding"

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.cicerone)

    implementation(libs.adapterdelegates)
    implementation(libs.adapterdelegates.viewbinding)

    implementation(project(":core:presentation"))
    implementation(project(":core:navigation"))
}
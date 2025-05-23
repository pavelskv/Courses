import com.android.build.api.dsl.LibraryExtension
import com.shechkov.courses.plugins.configureJUnit
import com.shechkov.courses.plugins.configureKotlin
import com.shechkov.courses.plugins.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlin()
                configureKotlinAndroid(this)
            }
            configureJUnit()
        }
    }
}
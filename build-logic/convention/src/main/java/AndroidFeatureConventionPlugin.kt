import com.shechkov.courses.plugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("courses.android.library")
                apply("courses.hilt")
                apply("courses.android.retrofit")
            }

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", libs.findLibrary("androidx.fragment.ktx").get())
            }
        }
    }
}
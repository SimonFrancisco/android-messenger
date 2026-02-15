import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

fun Project.setCompose() {

    val extension = extensions.findByType(LibraryExtension::class.java)
        ?: extensions.findByType(BaseAppModuleExtension::class.java)
    extension?.buildFeatures {
        compose = true
    }

    extensions.configure<ComposeCompilerGradlePluginExtension> {
        reportsDestination = layout.buildDirectory.dir("reports")
        stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability.txt")
    }

}
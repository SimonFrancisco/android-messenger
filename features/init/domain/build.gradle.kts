plugins {
    alias(libs.plugins.custom.kotlin.library)
}

dependencies {
    implementation(libs.javax.inject)
    implementation(projects.core.essentials)
    testImplementation(libs.junit)
}
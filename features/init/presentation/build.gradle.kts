plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}
android {
    namespace = "francisco.simon.init.presentation"
}

dependencies {
    api(projects.features.init.domain)
    implementation(projects.core.essentials)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
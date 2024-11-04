plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.com.google.protobuf)
    alias(libs.plugins.com.dagger.hilt)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.saico.cvportfolio"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Modules
//    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    //Core
    implementation(libs.androidx.core.ktx)
    coreLibraryDesugaring(libs.com.android.tools.desugar)

    //Datastore
    implementation(libs.bundles.androidx.datastore)

    //Hilt
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.compiler)


}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.ariawaludin.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ariawaludin.myapplication"
        minSdk = 29
        targetSdk = 35
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}



dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /// Core dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    // Jetpack Compose dependencies
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.compiler:compiler:1.5.1")
    // ✅ Tambahkan ini untuk Jetpack Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")
    // Debugging tools
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.1")
    implementation("androidx.activity:activity-compose:1.7.2")
// LazyColumn udah termasuk di `foundation`
    implementation("androidx.compose.foundation:foundation:1.5.0")

// HorizontalPager untuk swipe antar tab
    implementation("androidx.compose.foundation:foundation:1.5.0")
    implementation("com.google.accompanist:accompanist-pager:0.30.1")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.30.1")
    implementation ("androidx.compose.material:material-icons-extended:1.5.0")


// ✅ Fix unresolved reference: tooling
}

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "ir.alirezaivaz.numberstoletters"
    compileSdk = 33
    defaultConfig {
        applicationId = "ir.alirezaivaz.numberstoletters"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
        resourceConfigurations += "fa"
    }
    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation(project(":library"))
}
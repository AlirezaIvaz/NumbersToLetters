plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
}

android {
    namespace = "ir.alirezaivaz.numberstoletters.demo"
    compileSdk = 33
    defaultConfig {
        applicationId = "ir.alirezaivaz.numberstoletters.demo"
        minSdk = 21
        targetSdk = 33
        versionCode = 2
        versionName = "2.0.0"
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
    implementation(project(":library"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.material)
    implementation(libs.tablericons)
}
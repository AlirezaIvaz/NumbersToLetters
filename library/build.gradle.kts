plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
}
android {
    namespace = "ir.alirezaivaz.numberstoletters"
    compileSdk = 33
    defaultConfig {
        minSdk = 14
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
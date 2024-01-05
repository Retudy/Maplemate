import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").inputStream())



android {
    namespace = "com.android.maplemate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.maplemate"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(

            "String",
            "nexon_api_key",
            properties.getProperty("api.key")
        )
    }
    buildFeatures {
        buildConfig = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding { enable = true }
    dataBinding { enable = true }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //  코일라이브러리 ( 이미지 업로드 라이브러리 )
    implementation("io.coil-kt:coil:2.5.0")


    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    //retrofit2(api호출라이브러리) = gson(json데이터를 코틀린 데이터클래스와 파싱해줌) + okhttp3 (통신용)
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")
    //Data Store 라이브러리 추가
    // Preferences DataStore (SharedPreferences like APIs)
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    // optional - RxJava2 support
    implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")
    // optional - RxJava3 support
    implementation("androidx.datastore:datastore-preferences-rxjava3:1.0.0")
    // Alternatively - use the following artifact without an Android dependency.
    implementation("androidx.datastore:datastore-preferences-core:1.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
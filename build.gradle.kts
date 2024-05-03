import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "cn.mucute.simple.admin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)

    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")

    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0-alpha01")

//    implementation("androidx.compose.runtime:runtime-livedata:1.6.6")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // https://mvnrepository.com/artifact/androidx.navigation/navigation-compose
    implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha03")

    // https://mvnrepository.com/artifact/org.jetbrains.compose.material/material-icons-core-desktop
    implementation("org.jetbrains.compose.material:material-icons-core-desktop:1.6.10-beta03")


    // https://mvnrepository.com/artifact/org.jetbrains.compose.material/material-icons-extended-desktop
    implementation("org.jetbrains.compose.material:material-icons-extended-desktop:1.6.10-beta03")


}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "simple-admin"
            packageVersion = "1.0.0"
        }
    }
}

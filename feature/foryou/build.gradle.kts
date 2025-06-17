/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.roborazzi)
    id("tech.apter.junit5.jupiter.robolectric-extension-gradle-plugin") version ("0.9.0")
}

android {
    namespace = "com.google.samples.apps.nowinandroid.feature.foryou"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.notifications)

    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.robolectric)
    testImplementation(projects.core.testing)
    testDemoImplementation(projects.core.screenshotTesting)
    testImplementation("org.junit.vintage:junit-vintage-engine:5.12.2")
    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}
tasks.withType<Test>().configureEach {
    inputs.files(project.layout.projectDirectory.files("src/test/screenshots"))
}



// inputs.files("/Users/inakivillar/experiments/androidify/androidify/feature/creation/build/intermediates/apk_for_local_test/debugUnitTest/packageDebugUnitTestForUnitTest/apk-for-local-test.ap_")

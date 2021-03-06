
# PermissionHub 

[comment]: <> (<a class="badge-align" href="https://www.codacy.com/app/bhoomit11/PermissionHub?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bhoomit11/PermissionHub&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/dd28ce7f922d4ad290c804283917f89d"/></a>)
<a href="https://jitpack.io/#bhoomit11/PermissionHub"><img src="https://jitpack.io/v/bhoomit11/PermissionHub/month.svg"/></a>
<a href="https://jitpack.io/#bhoomit11/PermissionHub"> <img src="https://jitpack.io/v/bhoomit11/PermissionHub.svg" /></a>
<a href="https://github.com/bhoomit11/PermissionHub/actions"></a>
<a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>

Provides ready-to-use interface for all permission to be used on your app with customized title and description defines brief/shot use of given permission.<br>

Provides listing interface above your application handled with all cases in-build (Allowed,Denied,Always Denied)<br>

<img src="https://raw.githubusercontent.com/bhoomit11/PermissionHub/main/screenshot/Screenshot_20220415_142207.png" />

## How to integrate into your app?
Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to user Runtime permissions library. Make the following changes to build.gradle inside you app.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```
Step 2. Add the dependency
```java
dependencies {
    implementation 'com.github.bhoomit11:PermissionHub:1.0.0'
}
```
## How to use the library?
Great! seems like you integrated the library in your project but now **how do you use it**?<br>
Well its really easy just follow the steps below.<br>

Just call this from your Activity/Fragment where you want to overlay the PermissionHub UI

```kotlin
PermissionHub.start(
    activity = this@MainActivity,
    permissionConfig = getPermissionConfig()
)
```

Here _*getPermissionConfig*_ will return the list of Permission Config as below

```kotlin
private fun getPermissionConfig(): ArrayList<PermissionConfig> {
    return arrayListOf(
        PermissionConfig.get().permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
            .title(getString(R.string.permission_camera_title)) // Add permission title to be showed up on permission screen
            .description(getString(R.string.permission_camera_desc)) // Add permission desc to be showed up on permission screen
            .afterDeniedDescription(getString(R.string.permission_camera_after_deny_desc)), // Add permission desc to be showed up after permission is denied permanently from user

        PermissionConfig.get().permission(PermissionName.ACCESS_FINE_LOCATION)// add setRequired if permission is must required for your App
            .title(getString(R.string.permission_location_title))// Add permission title to be showed up on permission screen
            .description(getString(R.string.permission_location_desc))// Add permission desc to be showed up on permission screen
            .afterDeniedDescription(getString(R.string.permission_location_after_deny_desc))// Add permission desc to be showed up after permission is denied permanently from user
    )
}
```
Add setRequired after the PermissionName to make this Permission necessary to allow to access you app further<br>

You can add as many as Runtime Permission in Arraylist<PermissionConfig> 

**Important: Don't forget to add those permission in Manifest file of your project**<br>

Here in my case I have added this 2 in my manifest, 

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
```

Wanna know a cool thing about the PermissionHub?<br>
It will automatically fetch your project's theme accent color to make this page looks like more a part of your project<br>
However you can give a custom color as will for all/each icons.<br>

Permission hub provides runtime permission icons by default but you can add your own icons as well.<br>
```kotlin
PermissionConfig.get().permission(PermissionName.CAMERA.setRequired()) // add setRequired if permission is must required for your App
    .title(getString(R.string.permission_camera_title)) // Add permission title to be showed up on permission screen
    .description(getString(R.string.permission_camera_desc)) // Add permission desc to be showed up on permission screen
    .afterDeniedDescription(getString(R.string.permission_camera_after_deny_desc)) // Add permission desc to be showed up after permission is denied permanently from user
    .iconResource(R.drawable.ic_outline_camera_new) // Optional: Add permission icon resource to add your own icon on permission screen, default material icon is already there in library
    .iconColorResource(R.color.purple_700) // Optional: Add theme color to be appliend on list screen, by default library will take default accent color of root project
```
Happy Coding :)<br>
Any feedback would be appreciated, if I am missing any Runtime permission please post the issue!

### License
```
Copyright 2021 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.```

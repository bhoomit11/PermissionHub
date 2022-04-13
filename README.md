
# PermissionHub 

Provides ready-to-use interface for all permission to be used on your app with customized title and description defines brief/shot use of given permission.<br>

Provides listing interface above your application handled with all cases in-build (Allowed,Denied,Always Denied)<br>

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
        implementation 'com.github.bhoomit11:PermissionHub:0.0.1'
}
```

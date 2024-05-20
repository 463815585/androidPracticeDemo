pluginManagement {
    repositories {
        maven(url="https://maven.aliyun.com/repository/public")
        maven(url="https://maven.aliyun.com/repository/central")
        maven(url="https://maven.aliyun.com/repository/jcenter")
        maven(url="https://maven.aliyun.com/repository/releases")
        maven(url="https://maven.aliyun.com/repository/gradle-plugin")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url="https://maven.aliyun.com/repository/public")
        maven(url="https://maven.aliyun.com/repository/central")
        maven(url="https://maven.aliyun.com/repository/jcenter")
        maven(url="https://maven.aliyun.com/repository/releases")
        maven(url="https://maven.aliyun.com/repository/gradle-plugin")
        google()
        mavenCentral()
    }
}
//buildscript {
//    repositories {
//        maven(url="https://maven.aliyun.com/repository/public")
//        maven(url="https://maven.aliyun.com/repository/central")
//        maven(url="https://maven.aliyun.com/repository/jcenter")
//        maven(url="https://maven.aliyun.com/repository/releases")
//        maven(url="https://maven.aliyun.com/repository/gradle-plugin")
//        google()
//        mavenCentral()
//    }
//    dependencies{
//        classpath("com.android.tools.build:gradle:7.2.2") // 适用于Kotlin 1.6.21的版本
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
//    }
//}
//enableFeaturePreview("VERSION_CATALOGS")


rootProject.name = "Demo"
include(":app")
include(":homeFramework")
include(":composedemo")

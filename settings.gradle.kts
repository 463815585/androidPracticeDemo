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

rootProject.name = "Demo"
include(":app")
include(":homeFramework")
include(":composedemo")

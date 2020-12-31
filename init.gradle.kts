val `aliyun google` = "https://maven.aliyun.com/repository/google"
val `aliyun public` = "https://maven.aliyun.com/repository/public"
val `aliyun gradle-plugin` = "https://maven.aliyun.com/repository/gradle-plugin"

fun ArtifactRepository.aliyunProxy() {
    if (this is MavenArtifactRepository) {
        when (name) {
            "Google" -> url = uri(`aliyun google`)
            "BintrayJCenter" -> url = uri(`aliyun public`)
            "Gradle Central Plugin Repository" -> url = uri(`aliyun gradle-plugin`)
        }
    }
}

allprojects {
    repositories { all { aliyunProxy() } }

    buildscript { repositories { all { aliyunProxy() } } }
}
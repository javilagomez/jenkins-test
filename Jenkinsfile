node("master") {
    stage("Stage 1") {
        parallel(
            sh "echo linter",
            sh "echo test"
        )
    }

    stage("Stage 2") {
        sh "echo stage 2"
    }
}
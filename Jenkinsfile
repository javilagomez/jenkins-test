node("master") {
    stage("Stage 1") {
        parallel(
            sh "linter",
            sh "test"
        )
    }

    stage("Stage 2") {
        sh "echo stage 2"
    }
}
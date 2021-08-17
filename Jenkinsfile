node("node 2") {
    stage("Stage 1") {
        parallel(
            "linter": {sh "echo linter"},
            "test": {sh "echo test"}
        )
    }

    stage("Stage 2") {
        sh "echo stage 2"
    }
}
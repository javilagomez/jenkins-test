Map tasks = [failFast: false]

tasks["x86"] = { ->
    node("x86") {
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
}
tasks["ARM"] = { ->
    node("ARM") {
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
}

parallel(tasks)
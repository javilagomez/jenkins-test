Map tasks = [failFast: false]

tasks["master"] = { ->
    node("master")
}
tasks["main"] = { ->
    node("master")
}

//Run both tasks in paralell
parallel(tasks)

node("master") {
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
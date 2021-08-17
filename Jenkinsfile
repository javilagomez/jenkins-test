Map tasks = [failFast: false]

tasks["master"] = { ->
    node("master") {
        archFlow("master")
    }
}
tasks["main"] = { ->
    node("master") {
        archFlow("main")
    }
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

archFlow(String arch) {
    stage("Stage 3") {
        sh "echo stage 3"
    }
}
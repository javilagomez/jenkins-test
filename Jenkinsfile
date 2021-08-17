// parallel task map
Map tasks = [failFast: false]

tasks['x86'] = { ->
    node('master') {
        archFlow('x86')
    }
}
tasks['arm'] = { ->
    node('master') {
        testFlow('arm')
    }
}

//Run both tasks in paralell
parallel(tasks)

node('master') {  
    stage('Publish') { 
        sh "echo publish"
    }
}

def archFlow(String arch) {
    stage('Build') { 
        sh "echo build"
    }
    stage('Quality') {
        parallel(
            "Test": { sh "echo test" },
            "Linter": { sh "echo lint" }
        )
    }
    stage('Deploy') { 
        sh "echo deploy"
    }
}

def testFlow(String arch) {
    stage('Quality') {
        parallel(
            "Test": { sh "echo test" },
            "Linter": { sh "echo lint" }
        )
    }
}
// parallel task map
Map tasks = [failFast: false]

tasks['x86'] = { ->
    node('master') {
        archFlow('x86')
    }
}
tasks['arm'] = { ->
    node('master') {
        archFlow('arm')
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
        /*parallel(
            "Test": { sh "echo test" },
            "Linter": { sh "echo lint" }
        )*/
        sh "echo deploy" 
    }
    stage('Deploy') { 
        sh "echo deploy"
    }
}
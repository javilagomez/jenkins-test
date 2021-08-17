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
    /*stage('Build') { 
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
    }*/

    // Build Jenkinsfile Go web

    // Build context
    stage('Download tooling') {
        sh "echo amazon url"
    }

    // Clone repository
    stage('Checkout') {
        sh "echo checkout"
    }

    if(isMini()) {
        miniFlow()
    } else {
        sh "echo Enter to else"
    }
}

def isMini() {
    return false
}

def miniFlow() {
    stage('test') {
        sh "echo test function into function"
    }
}
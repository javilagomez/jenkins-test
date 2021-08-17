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

    test = true

    if (test) {
        stage('Melicov') {
            sh "echo melicov"
        }
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
    return true
}

def miniFlow() {
    boolDescription = true
    
    if(boolDescription) {
        currentBuild.description = "Version: 1.0 - Branch: feature/test - Commit: 28"
    } else {
        currentBuild.description = "PR #8"
    }

    stage('Build Environment') {
        sh "echo build environment"
    }

    // Build docker image
    stage('Build Docker Image') {
        sh "echo build docker image"
    }

    // If we have migration content and it is not a build, migration node should be visible
    shouldRunMigrationNode = false

    // Run migration validation and upload if corresponds
    if (shouldRunMigrationNode) {
        sh "echo run migration"
    }

    // When in a build or a pull request with test, the test combo (install dep, test and melicov) should run
    shouldRunTestNodes = true

    if (shouldRunMigrationNode) {
        stage('Install Dependencies') {
            sh "echo install dependencies"
        }

        stage('Quality') {
            sh "echo pending parallel"
        }
    }
}
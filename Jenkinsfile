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
    ctx_build = true
    ctx_migration = true
    ctx_test = true

    if (!ctx_build && ctx_test) {
        stage('Melicov') {
            sh 'echo melicov'
        }
    }
    
    stage('Publish') { 
        sh 'echo publish'
    }
}

def archFlow(String arch) {
    // Build Jenkinsfile Go web
    sh 'echo entré a archflow'

    // Build context
    stage('Download tooling') {
        sh 'echo amazon url'
    }

    // Clone repository
    stage('Checkout') {
        sh 'echo checkout'
    }

    if(isMini()) {
        miniFlow()
    } else {
        sh 'echo Enter to else'
    }
}

def isMini() {
    return true
}

def notParallel() {
    // Clone repository
    stage('Checkout') {
        sh 'echo checkout'
    }
}

def miniFlow() {  
    ctx_build = true
    ctx_migration = true
    ctx_test = true

    if(ctx_build) {
        currentBuild.description = 'Version: 1.0 - Branch: feature/test - Commit: 28'
    } else {
        currentBuild.description = 'PR #8 - url'
    }

    stage('Build Environment') {
        sh 'echo build environment'
    }

    // Build docker image
    stage('Build Docker Image') {
        sh 'echo build docker image'
    }

    // If we have migration content and it is not a build, migration node should be visible
    shouldRunMigrationNode = ctx_migration && ctx_build

    // Run migration validation and upload if corresponds
    if (shouldRunMigrationNode) {
        sh 'echo run migration'
    }

    optional { notParallel() }

    // When in a build or a pull request with test, the test combo (install dep, test and melicov) should run
    shouldRunTestNodes = ctx_test

    if (shouldRunTestNodes) {
        stage('Install Dependencies') {
            sh 'echo install dependencies'
        }

        stage('Lint') {
            sh 'echo pending lint'
        }

        stage('Test') {
            sh 'echo pending test'
        }
    }

    if (shouldRunMigrationNode) {
        if (!shouldRunTestNodes) {
            stage('Install Dependencies') {
                sh 'echo install dependencies 2'
            }
        }

        stage('Build') {
            sh 'echo build 2'
        }

        stage('OSS') {
            sh 'echo oss'
        }

        stage('Meli System') {
            sh 'echo meli system'
        }

        stage('Publish to registries') {
            sh 'echo pending to parallel publish 2'
        }

        stage('Publish Documentation') {
            sh 'echo Documentation'
        }
    }
}
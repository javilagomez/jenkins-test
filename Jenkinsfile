 stage('Realms') {
    parallel 'aws': {
        stage('Regions (aws)') {
            parallel 'us-east-1 (aws)': {
                stage('Dev (aws us-east-1)') {
                    echo 'aws us-east-1 dev'
                }
                stage('QA (aws us-east-1)') {
                    input message: 'Approve aws us-east-1 qa?', ok: 'Approve aws us-east-1 qa!'
                    echo 'aws us-east-1 qa'
                }
            }, 'us-west-2 (aws)': {
                stage('Dev (aws us-west-2)') {
                    echo 'aws us-west-2 dev'
                }
                stage('QA (aws us-west-2)') {
                    input message: 'Approve aws us-west-2 qa?', ok: 'Approve aws us-west-2 qa!'
                    echo 'aws us-west-2 qa'
                }
            }, failFast: false
        }
    }, 'gcp': {
        stage('Regions (gcp)') {
            parallel 'us-east-1 (gcp)': {
                stage('Dev (gcp us-east4)') {
                    echo 'gcp us-east4 dev'
                }
                stage('QA (gcp us-east4)') {
                    input message: 'Approve gcp us-east4 qa?', ok: 'Approve gcp us-east4 qa!'
                    echo 'gcp us-east4 qa'
                }
            }, 'us-west-2 (gcp)': {
                stage('Dev (gcp us-west4)') {
                    echo 'gcp us-west4 dev'
                }
                stage('QA (gcp us-west4)') {
                    input message: 'Approve gcp us-west4 qa?', ok: 'Approve gcp us-west4 qa!'
                    echo 'gcp us-west4 qa'
                }
            }, failFast: false
        }
    }, failFast: false
}

// parallel task map
/*Map tasks = [failFast: false]

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
    test = true

    if (test) {
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

def miniFlow() {
    boolDescription = false
    
    if(boolDescription) {
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
    shouldRunMigrationNode = false

    // Run migration validation and upload if corresponds
    if (shouldRunMigrationNode) {
        sh 'echo run migration'
    }

    // When in a build or a pull request with test, the test combo (install dep, test and melicov) should run
    shouldRunTestNodes = true

    if (shouldRunTestNodes) {
        stage('Install Dependencies') {
            sh 'echo install dependencies'
        }

        stage('Quality') {
            sh 'echo pending parallel'
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
}*/
stage('Clone') {
    checkout scm
}

testSuites = [ 'suite1', 'suite2', 'suite3' ]

parallel([
    buildAndTest: {
        stage('Build') {
            node('linux') {
                sh 'make'
                stash includes: 'pkg/**/*', name: 'build-artifacts'
            }
        }
        stage('Test') {
            testSteps = [:]
            for (suite in testSuites) {
                testSteps[suite] = {
                    node('linux') {
                        unstash 'build-artifacts'
                        sh "run_tests $suite"
                        stash includes: 'test_results/**/*.xml', name: "test-$suite"
                    }
                }
            }
            parallel(testSteps)
        }
    },
    docs: {
        stage('Documentation') {
            node('windows') {
                bat 'build_docs.exe'
            }
        }
    },
    staticAnalysis: {
        stage('Static Analysis') {
            node('linux') {
                sh 'run_static_analysis'
            }
        }
    }
])

stage('Archive') {
    unstash 'build-artifacts'
    for (suite in testSuites) {
        unstash "test-$suite"
    }
    archive 'pkg/**/*'
    junit 'test_results/**/*.xml'
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
            sh "echo melicov"
        }
    }
    
    stage('Publish') { 
        sh "echo publish"
    }
}

config = [
    skipStage2 = false
]

def archFlow(String arch) {
    stage('Build') { 
        sh "echo build"
    }
    stage('Quality') {
        stage('Build') { 
            sh "echo build"
        }
        stage('Build') { 
            sh "echo build"
        }
    }
    stage('Deploy') { 
        sh "echo deploy"
    }

    // Build Jenkinsfile Go web

    // Build context*/
    /*stage('Download tooling') {
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
    boolDescription = false
    
    if(boolDescription) {
        currentBuild.description = "Version: 1.0 - Branch: feature/test - Commit: 28"
    } else {
        currentBuild.description = "PR #8 - url"
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

    if (shouldRunTestNodes) {
        stage('Install Dependencies') {
            sh "echo install dependencies"
        }

        stage('Quality') {
            sh "echo pending parallel"
        }
    }

    if (shouldRunMigrationNode) {
        if (!shouldRunTestNodes) {
            stage('Install Dependencies') {
                sh "echo install dependencies 2"
            }
        }

        stage('Build') {
            sh "echo build 2"
        }

        stage('OSS') {
            sh "echo oss"
        }

        stage('Meli System') {
            sh "echo meli system"
        }

        stage('Publish to registries') {
            sh "echo pending to parallel publish 2"
        }

        stage('Publish Documentation') {
            sh "echo Documentation"
        }
    }*/
}
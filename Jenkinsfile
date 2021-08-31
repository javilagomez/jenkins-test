Map tasks = [failFast: false]

tasks['x86'] = { ->
    node('master') {
        archFlow('x86')
    }
}
tasks['arm'] = { ->
    node('master') {
        try {
            archFlow('arm')
        } catch(error) {
            echo error.toString()
        }
    }
}

build_ok = true

//Run both tasks in paralell
parallel(tasks)
singleFlow()


def singleFlow(){
    node('master') {
        stage('Melicov') {
            sh "echo melicov"
        }
        
        stage('Publish') {
            sh "echo publish"
        }
    }
}

def archFlow(String arch) {
    // Build context
    stage('Download tooling') {
        sh "echo download tooling"
    }

    // Clone repository
    stage('Checkout') {
        sh 'echo checkout'
    }

    if(isMini()) {
        miniFlow(arch)
    } else {
        sh 'echo Enter to else'
    }
}

def isMini() {
    return true
}

def miniFlow(arch) {  
    ctx_build = true

    if(ctx_build) {
        currentBuild.description = 'Version: 1.0 - Branch: feature/test - Commit: 28'
    } else {
        currentBuild.description = 'PR #8 - url'
    }

    stage('Build Environment') {
        sh "echo error"
    }

    // Build docker image
    stage('Build Docker Image') {
        sh 'echo build docker image'
    }

    if(build_ok) {
        if(build_ok) {
            currentBuild.result = "SUCCESS"
        } else {
            currentBuild.result = "FAILURE"
        }
    }

    stage('publish result') {
        sh "echo pipeline: ${build_ok}"
    }
}

/*/ parallel task map
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

holas = [:]

//Run both tasks in paralell
parallel(tasks)
singleFlow()

def singleFlow(){
    node('master') {
        ctx_build = true
        ctx_migration = true
        ctx_test = true

        if (!ctx_build && ctx_test) {
            stage('Melicov') {
                sh "echo hola"
            }
        }
        
        stage('Publish') {
            sh "echo ${holas.get("x86")}"
            sh "echo ${holas.get("arm")} hola"
        }


    }
}

def archFlow(String arch) {
    // Build context
    sh "echo ${image[arch]}"
    stage('Download tooling') {
        holas[arch] = arch
        sh "echo ${holas[arch]} hola"
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
}*/
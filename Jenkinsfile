/*node('master') {
    stage('env variables') {
        // GET
        final String url = "--location --request GET 'https://production_rp-ci-proxy.furyapps.io/pipeline/3221366' --header 'x-auth-token: d928d89f40e23e4f508fe60fe3f7419090321841a39de902ee09b9cba47fc7ed'"
        final String response = sh(script: "curl -s $url", returnStdout: true).trim()
        echo response

        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            error '  ************************************************** \n ** IMPORTANT: THIS FAILURE DOES NOT BLOCK THE NORMAL \n ** FLOW OF THE PIPELINE AND CAN BE SAFELY INGNORED BY NOW. \n ** link al anuncio \n **************************************************'
        }
    }
}*/

Map tasks = [failFast: false]
currentStage = null

tasks['x86'] = { ->
    node('master') {
        archFlow('x86')
    }
}
tasks['arm'] = { ->
    node('master') {
        try {
            archFlow('arm')
        } catch(e) {
            sh "echo ${currentStage}, ${BUILD_URL}"

            final String url = "curl -s --location --request GET 'http://test.rp-ci-proxy.melifrontends.com/pipeline/3000' --header 'x-auth-token: --header 'x-auth-token: ac3220d5f080ece307978add4d1617156f95aaf37de68546dc6e2589a26e31a6''"
            final String response = sh(script: url, returnStdout: true).trim()
            echo response

            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                error '************************************************** \n ** IMPORTANT: THIS FAILURE DOES NOT BLOCK THE NORMAL \n ** FLOW OF THE PIPELINE AND CAN BE SAFELY INGNORED BY NOW. \n ** link al anuncio \n **************************************************'
            }
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
            currentStage = STAGE_NAME
            sh "echo melicov"
            def response = httpRequest 'https://jsonplaceholder.typicode.com/posts/1/comments'
        }
        
        stage('Publish') {
            currentStage = STAGE_NAME
            sh "echo publish"
        }
    }
}

def archFlow(String arch) {
    // Build context
    stage('Download tooling') {
        currentStage = STAGE_NAME
        sh "echo download tooling"
    }


    // Clone repository
    stage('Checkout') {
        currentStage = STAGE_NAME
        sh  "echo todo tranqui"
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

    if(arch == "arm") {
        stage('Build Environment') {
            currentStage = STAGE_NAME
            sh "echo Build environment"
            error "echo error"
        }
    }

    // Build docker image
    stage('Build Docker Image') {
        currentStage = STAGE_NAME
        sh "echo build docker image"
        sh "echo build ${arch.equals("arm")}"
    }

    stage('publish result') {
        sh "echo pipeline: ${build_ok}"
        currentStage = STAGE_NAME
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
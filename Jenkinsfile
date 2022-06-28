@Library('pipeline-library')

hello = "hello world!"

def checkout(hello) {
    sh "echo ${hello}"
}

node {
    stage('Checkout') {
        checkout(hello)
        checkout-stage()
    }
}
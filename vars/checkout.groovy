#!/usr/bin/env groovy

def call(tech) {
    stage('Checkout') {
        sh "echo hello checkout ${tech}"
    }
}
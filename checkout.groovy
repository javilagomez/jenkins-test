#!/usr/bin/env groovy

def call() {
    stage('Checkout') {
        sh "echo Hello world!"
    }
}
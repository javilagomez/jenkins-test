#!/usr/bin/env groovy

def call() {
    stage('Download tooling') {
        sh "echo hello download tooling"
    }
}
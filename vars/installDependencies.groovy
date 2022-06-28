#!/usr/bin/env groovy

def call(tech) {
    stage('Install dependencies') {
        sh "echo hello install ${tech}"
    }
}
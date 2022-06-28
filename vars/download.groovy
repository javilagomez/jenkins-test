#!/usr/bin/env groovy

def call(tech) {
    stage('Download tooling') {
        sh "echo hello download ${tech}"
    }
}
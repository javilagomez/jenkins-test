#!/usr/bin/env groovy

def call(tech) {

    if (tech == "java") {
        stage('Build') {
            sh "echo build java"
        }
    }
}
#!/usr/bin/env groovy

def call() {

    if (tech == "java") {
        stage('Build') {
            sh "echo build java"
        }
    }
}
#!/usr/bin/env groovy

def call(tech) {

    if (tech == "java") {
        stage('Build') {
            sh "echo build java"
        }
    }

    if (tech == "go") {
        stage('Build') {
            sh "echo build go"
        }
    }

    if (tech == "nodejs") {
        stage('Build') {
            sh "echo build node"
        }
    }
}
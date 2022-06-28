#!/usr/bin/env groovy

package web

static buildWeb() {
    stage('Build') {
        sh "echo build"
    }
}
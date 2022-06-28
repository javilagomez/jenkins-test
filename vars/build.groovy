#!/usr/bin/env groovy

def call() {
    evaluate(new File("vars/web/buildWeb.groovy"))
}
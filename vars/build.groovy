#!/usr/bin/env groovy

def call() {
    groovy -cp . web/buildWeb.groovy
}
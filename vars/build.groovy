#!/usr/bin/env groovy

def call() {
    GroovyShell shell = new GroovyShell()
    def Util = shell.parse(new File('web/buildWeb.groovy'))
    Util
}
#!/usr/bin/env groovy

def call() {
    GroovyShell shell = new GroovyShell()
    def Util = shell.parse(new File('vars/web/buildWeb.groovy'))
    Util
}
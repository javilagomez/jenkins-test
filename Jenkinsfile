node {  
    stage('Build') { 
        sh "echo build"
    }
    stage('Quality') {
        paralell(
            "Test": { sh "echo test" },
            "Linter": { sh "echo lint" }
        )  
    }
    stage('Deploy') { 
        sh "echo deploy"
    }
}
node {  
    stage('Build') { 
        sh "echo build"
    }
    stage('Quality') {
        parallel(
            "Test": { sh "echo test" },
            "Linter": { sh "echo lint" }
        )  
    }
    stage('Deploy') { 
        sh "echo deploy"
    }
}
pipeline {
    agent any
    stages{
        stage("Install dependencies"){
            steps{
                dir('FrontEndAAs'){
                bat 'npm install'
                bat 'npm pack'}
                dir('BigCartSaver_BE'){
                    bat 'mvn package -Dmaven.test.skip'
                }
            }
        }
    }
}
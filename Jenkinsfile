pipeline {
    agent any
    stages{
        stage("Install dependencies"){
            steps{
                dir('Frontend'){
                bat 'npm install'
                bat 'npm pack'}
                dir('Backend'){
                    bat 'mvn package -Dmaven.test.skip'
                }
            }
        }
    }
}
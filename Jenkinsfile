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
        stage("Testing"){
            steps{
                dir('Backend'){
                    bat 'mvn clean verify -DskipITs=true';junit '**/target/surefire-reports/TEST-*.xml'archive 'target/*.jar'
                }
            }
        }
    }
}
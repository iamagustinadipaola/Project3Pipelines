pipeline {
    agent any
    tools { nodejs "node"}
    stages{
        stage("Install dependencies"){
            steps{
                dir('Frontend'){
                sh 'npm install'
                sh 'npm pack'}
                dir('Backend'){
                    sh 'mvn package -Dmaven.test.skip'
                }
            }
        }
        stage("Testing"){
            steps{
                dir('Backend'){
                    sh 'mvn clean verify -DskipITs=true'
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archive 'target/*.jar'
                }
            }
        }
    }
}
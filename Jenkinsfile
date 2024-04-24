
pipeline {
    agent any
    tools { nodejs "node" 
            maven "maven"
            jdk "jdk"
            }
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
                    bat 'mvn clean verify -DskipITs=true'
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archive 'target/*.jar'
                }
            }
        }
        stage("Building image"){
            steps{
                dir("Frontend"){
                script {
                    dockerImage = docker.build imageName
                }
            }
            }
        }
        stage("Deploy Image"){
            steps{
                dir("Frontend"){
                script{
                    docker.withRegistry("https://registry.hub.docker.com", "dockerhub-creds"){
                        // Gets number of build which is always unique and pushes it to docker and makes sure each push is unique
                        dockerImage.push("${env.BUILD_NUMBER}")
                    }
                }
            }
            }
        }
    }
}
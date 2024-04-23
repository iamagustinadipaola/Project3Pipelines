pipeline {
    agent any
    tools { nodejs "node" 
            maven "maven"
            jdk "jdk"
            }
    environment {
        imageName = "papryk04/frontendimage"
        registryCredential = "papryk04"
        dockerImage = ""
    }
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
        stage("Build Docker Image") {
            agent any
            environment {
        HOME = "${env.WORKSPACE}"
        }
            steps {
               script {
                dockerImage = docker.build
               }
            }
        }
        stage("Deploy Image"){
            steps{
                dir("Frontend"){
                script{
                    docker.withRegistry("https://registry.hub.docker.com", "dockerhub-credentials"){
                        // Gets number of build which is always unique and pushes it to docker and makes sure each push is unique
                        dockerImage.push("${env.BUILD_NUMBER}")
                    }
                }
            }
            }
        }
    }
}
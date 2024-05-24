pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build'){
            steps{
                sh '''
                mvn package -DskipTests
                '''
                echo 'scutulatus'
            }
        }
        stage('Test'){
            steps{
                sh '''
                mvn tests
                '''
                echo 'Test'
            }
        }
    }
}
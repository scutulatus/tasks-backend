pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build'){
            steps{
                sh '''
                mvn clean package -DskipTests
                '''
                echo 'scutulatus'
            }
        }
        stage('Test'){
            steps{
                sh '''
                mvn test
                '''
                echo 'Test'
            }
        }
    }
}
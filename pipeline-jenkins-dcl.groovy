pipeline{
    agent any
    tools{
        maven 'Maven 3.3.9'
        jdk 'jdk 8' }
        stages{
            stage('Checkout stage'){
                steps{
                    git 'https://github.com/Swastik1993bond/docker.git'
                }
            stage('Build stage'){
                steps{
                    sh 'mvn -Dmaven.test.failure.ignore=true install'
                }
            stage('Test Stage'){
                steps{
                   junit 'myproject/target/test-reports/*.xml' 
                }
            stage('Deploy stage'){
                steps{
                   sh '''cp *.jar /var/www/html/'''
                }
            }
            }
            }
            }
            }
        }
    }
}
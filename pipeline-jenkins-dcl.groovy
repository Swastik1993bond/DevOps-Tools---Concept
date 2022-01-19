pipeline{
    agent any{
        stages{
            stage('Checkout stage'){
                steps{
                    git 'https://github.com/Swastik1993bond/docker.git'
                }
            stage('Build stage'){
                steps{
                    mvn clean package 
                }
            stage('test Stage'){
                steps{
                   junit 'myproject/target/test-reports/Reports.xml' 
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
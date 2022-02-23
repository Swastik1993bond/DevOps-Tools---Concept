pipeline{
    agent any
    tools{
        maven 'Maven 3.3.9'
        jdk 'jdk 11'
        sonarqube 'My SonarQube Server' }
        stages{
            stage('Checkout stage'){
                steps{
                    git 'https://github.com/Swastik1993bond/docker.git'
                }
            stage('Build & Sonarqube Analysis stage'){
                steps{
                    withSonarQubeEnv('My SonarQube Server')
                    sh 'mvn -Dmaven.test.failure.ignore=true install'
                }
            stage("Quality Gate") {
                steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            stage('Test Stage'){
                steps{
                   junit 'myproject/target/test-reports/*.xml' 
                }
            stage('Deploy stage'){
                steps{
                   sh '''cp *.jar /var/www/html/'''
                }
            failure {
               emailext body: 'Pipleline Failed', subject: 'failure-Pipeline', to: 'swastik.mukherzee@outlook.com'
        }
            }

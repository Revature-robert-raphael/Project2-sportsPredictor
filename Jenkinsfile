pipeline {
  agent any
  stages {
    stage('Creating pipeline') {
      steps {
        git(url: 'https://github.com/Revature-robert-raphael/Project2-sportsPredictor.git', credentialsId: 'Waterbug23')
      }
    }
    stage('Maven Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Maven Deploy') {
      steps {
        sh 'mvn tomcat7:deploy'
      }
    }
  }
}
pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Le build a commencé'
        sh 'mvn clean install -Dlicense.skip=true'
        echo 'Le build est terminé'
      }
    }

    stage('Print build number') {
      steps {
        echo 'This is build number ${BUILD_ID}'
        sleep 20
      }
    }

  }
  tools {
    maven 'Maven'
  }
}
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

  }
}
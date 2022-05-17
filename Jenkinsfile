pipeline{
agent any
tools{
    maven 'Maven 3.8.5'
    jdk 'jdk8'
}
stages{
    stage('Test Maven and java'){
        steps{
        sh 'mvn --version'
        sh 'java --version'
        }
    }
    stage('Initialize Maven and Java'){
        steps {
          sh '''
             echo "PATH = ${PATH}"
             echo "M2_HOME = ${M2_HOME}"
                            '''
        }
    }
    stage('Build Project and Run tests') {
                steps {
                    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
                    sh "mvn clean test"
                    }
                }
    }
     stage('Generate Allure Reports') {
          steps {
              script {
                  allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                        ])
          }
       }
    }

}
}
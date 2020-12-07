pipeline {
    agent any

    tools {
        jdk 'java11'
    }

    stages {
        stage('Build') {
            steps {
                sh "./mvnw clean package"
            }
            always {
                cucumber buildStatus: 'UNSTABLE',
                                reportTitle: 'Cucumber report',
                                fileIncludePattern: '**/cucumber.json'
                    }
            }

        }
    }
}

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
            post {
                always {
                    cucumber(buildStatus: 'UNSTABLE',
                            reportTitle: 'Cucumber report',
                            fileIncludePattern: '**/cucumber.json')
                    livingDocs(featuresDir: 'cucumber/target')
                     publishHTML([allowMissing: false,
                                                alwaysLinkToLastBuild: false,
                                                keepAll: true,
                                                reportDir: 'cucumber/target/cucumber',
                                                reportFiles: 'index.html',
                                                reportName: 'Cucumber Report',
                                                reportTitles: ''])
                }
            }
        }
    }
}
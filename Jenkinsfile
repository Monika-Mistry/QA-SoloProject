pipeline{
        agent any
        stages{
                stage('---clean---'){
                        steps{
                                sh "mvn clean"
                        }
                }
                stage('--test--'){
                        steps{
                                sh "mvn test"
                        }
                }
                stage('--package--'){
                        steps{
                                sh "mvn package"
                        }
                }
                stage('--sonar--'){
                        steps{
                                sh "mvn sonar:sonar"
                        }
                }
                stage('--verify--'){
                        steps{
                                sh "mvn verify"
                        }
                }
                stage('--surefire--'){
                        steps{
                                sh "mvn surefire-report:report"
                                sh "mvn site"
                        }
                }
                stage('--deploy--'){
                        steps{
                                sh "cd /"
                                sh "pwd"
                                sh "sudo cp target/netflixWatchlistApp.war /home/monika_mistry1/wildfly-10.1.0.Final/standalone/deployments/"
                        }
                }
                stage('--email--'){
                        steps{
                                emailext attachLog: true, attachmentsPattern: 'target/site/jacoco/index.html, target/site/surefire-report.html', body: '', subject: '', to: 'monika.mistry1@gmail.com'
                        }
                }
        }
}

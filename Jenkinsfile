Pipeline{
    any agent
    tools{
        maven 'maven3'
    }
    stages{
        stage('Build'){
            steps{
                sh script: 'mvn clean install -DskipTests'
            }
        }
        stage('nexus'){
            steps{
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'contact',
                        classifier: '',
                        file: 'target/contact-0.0.1-SNAPSHOT.war',
                        type: 'war'
                    ]
                ],
                credentialsId: 'nexus3',
                groupId: 'com.amina',
                nexusUrl: 'localhost:8081',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'http://localhost:8081/repository/contact-app/',
                version: '0.0.1-SNAPSHOT'
            }
        }
    }


}
pipeline {
    agent any

    environment {
     		APPROVAL_AUDIENCE		 = "himanshusinghcs0036@gmail.com"
     		NOTIFICATION_AUDIENCE 	 = "himanshusinghcs0036@gmail.com"
     		PROJECT_NAME			 = 'javatodolist'
     		DOCKER_IMAGE_NAME        = "himanshusrinet/cicddemo"
            DOCKER_CRED = 'docker_cred'
     	}

    stages {

        stage('Build') {
            steps{
            withMaven(maven : 'maven') {
            sh 'mvn clean -DskipTests=true install'
            sh "ls -ltrh"
            sh "mkdir -p dockerBuildDir"
            sh "ls -ltrh"
            }
        }
        }

        stage('Docker Build Initialize') {
                  steps {
                       sh("cp target/tasktodo-0.0.1-SNAPSHOT.jar dockerBuildDir/tasktodo-0.0.1-SNAPSHOT.jar")
                       sh("cp Dockerfile dockerBuildDir/")
                       sh("ls -ltrh dockerBuildDir/")
                  }
               }

        stage('Docker build'){
            steps{
                  dir('dockerBuildDependencies'){
                    script{
                    docker.withRegistry(url['https://hub.docker.com/' , 'docker_cred']){
                        sh "echo '*********** Creating Docker Image ***********'"
                        docker.build('himanshusrinet/cicddemo:sampletag','-f Dockerfile .')
                    }
                 }
                }
            }
        }

}

}

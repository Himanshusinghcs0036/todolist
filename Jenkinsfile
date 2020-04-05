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
            sh "mkdir dockerBuildDir"
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
                dir('dockerBuildDir'){
                       withDockerRegistry([credentialsId: "${env.DOCKER_CRED}", url: "https://hub.docker.com/"]){
                            sh "echo '*********** Creating Docker Image ***********'"
                            sh "docker build -t ${ev.DOCKER_IMAGE_NAME}:${PROJECT_NAME} -f Dockerfile ."
                            sh "docker push ${ev.DOCKER_IMAGE_NAME}:${PROJECT_NAME}"
                            sh "echo '*********** Docker Image Created ***********'"
                       }
                 }
            }
        }

}

}

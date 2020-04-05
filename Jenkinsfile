pipeline {
    agent any

    environment {
     		PROJECT_CREDENTIALS	 	 = '9e070679-76ee-45b0-8ea2-84cdc4c3ba25'
     		APPROVAL_AUDIENCE		 = "himanshusinghcs0036@gmail.com"
     		NOTIFICATION_AUDIENCE 	 = "himanshusinghcs0036@gmail.com"
     		PROJECT_NAME			 = 'javatodolist'
        registryCredential = 'docker_cred'
     	}

    stages {
      stage ('Initial environment setup') {
        steps {
          script {
          //IS_TAG = sh(script: "git name-rev --name-only --tags HEAD", returnStdout: true).trim()
          if (env.GIT_BRANCH == 'master') {
            env.IMAGE_NAME = "hub.docker.com/himanshusrinet/cicddemo"
            env.RELEASE_NAME = "hub.docker.com/himanshusrinet/cicddemo:${env.PROJECT_NAME}"
            env.K8S_SERVER = "https://kube:6443"
          }
        }
      }

    }

        stage('Build') {
          steps {
          withMaven(maven: 'mave'){
                sh("/usr/bin/mvn clean -DskipTests=true install")
                sh("ls -ltrh")
                sh("mkdir dockerBuildDir")
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



}

}

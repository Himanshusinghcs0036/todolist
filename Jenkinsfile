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

        stage('CLONE REPO') {
          steps {
            withCredentials([usernamePassword(credentialsId: 'github_cred', passwordVariable: 'GIT_PASSWORD', usernameVariable: 'GIT_USERNAME')]) {
                sh("echo USERNAME = ${GIT_USERNAME}")
                sh("echo PASSWORD = ${GIT_USERNAME}")
                sh('git clone https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com:Himanshusinghcs0036/todolist.git')
                sh("ls -ltrh")
            }
          }
        }

        stage('Install') {
          steps {
            scripts{
                sh "echo 'Last ONE'"
            }
          }
        }

    }
}

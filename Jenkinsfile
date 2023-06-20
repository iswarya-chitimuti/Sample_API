pipeline {
   agent any
   parameters{
        choice{
            name: 'ENVIRONMENT'
            choices: ['dev','qa','staging']
            description: 'Choose the environment to deploy'
        }
   }
   triggers{pollSCM('* * * * *')}
   stages {
       stage('Build') {
            parallel{
                stage('dev'){
                    when{
                        branch 'main'
                        environment name: 'ENVIRONMENT', value: 'dev'
                    }
                    steps{
                        echo 'Building the project to dev environment'
                    }
                }
                stage('qa'){
                    steps{
                        echo 'Building the project to QA environment'
                    }
                }
                stage('staging'){
                    steps{
                        echo 'Building the project to staging environment'
                    }
                }
            }
       }
   }
}
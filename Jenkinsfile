pipeline{
    
    agent any
    
    stages{
        stage("Build"){
            steps{
                echo "Build the project"
            }
        }
        
        stage("Deploy on QA"){
            steps{
                echo "deploy on the QA env"
            }
        }
        
        stage("Unit Testing"){
            steps{
                echo "run unit test"
            }
        }
        
        stage("Sanity Testing"){
            steps{
                echo "run sanity test"
            }
        }
        
        stage("REgression Testing"){
            steps{
                echo "run regression test"
            }
        }
        
       stage("Deploy on stage"){
            steps{
                echo "deploy on the stage env"
            }
        }
        
        stage("Sanity Testing on Stage"){
            steps{
                echo "run sanity test on stage"
            }
        }
        
        stage("Deploy on prod"){
            steps{
                echo "deploy on the prod env"
            }
        }
        
    }
    
}
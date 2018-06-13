@Library('aliasname@master') _
        
import org.k9.*

pipeline {
    agent any
    stages {
        stage('create resource ') {
            steps {
                script {
                    def params = [
                        launchcofig:[
                            "jsonBody":[
                            	"imageId": "ami-f2d3638a",
	                            "instanceType": "t2.micro",
	                            "launchConfigurationName": "my-launch-config",
	                            "securityGroups": ["sg-879965f8"],
	                            "userData": "https://s3-us-west-2.amazonaws.com/hudsonbay-test/scripts/script.sh",
	                            "keyName": "HudsonBay-V",
	                            "iamInstanceProfile": "ec2-s3-RO-role"
                    ]

                    httpParam:[
                        url:"http:/localhost:4321",
                        path:"/v1/launchcofig",
                        method: "post"

]
                    def httpObj = new http.SimpeHTTPBuilder(this,params.launchcofig)
                    httpObj.sendRequest()
                }
            }
        }


        // stage('Build') {
        //     steps {
        //         script {
        //             def buildObj = new build.Build(this,params)
        //             buildObj.checkout()
        //         }
        //     }
        // }
    }
}
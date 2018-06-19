@Library('test@master')
        
import org.k9.*

pipeline {
    agent any
    stages {
        stage('create resource ') {
            steps {
                script {
                    def params = [
                        launchconfig:[
                            "jsonBody":[
                            	"imageId": "ami-f2d3638a",
	                            "instanceType": "t2.micro",
	                            "launchConfigurationName": "my-launch-config",
	                            "securityGroups": ["sg-879965f8"],
	                            "userData": "https://s3-us-west-2.amazonaws.com/hudsonbay-test/aws/dev/script/blue-green/R1/scriptViaGroovy.sh ",
	                            "keyName": "HudsonBay-V",
	                            "iamInstanceProfile": "ec2-s3-RO-role"
                        	],
							httpParams:[
								url:"http://localhost:4321",
								path:"/v1/launchconfig",
								method: "POST"

                        	],	
						],
						
																					
                        targetgroup: [
                           "jsonBody": [
                               "name": "testTG",
                               "port": "4444",
                               "protocol": "HTTP" ,
                               "vpcId": "vpc-0f2c8a76"
                           ],
                     
					   
					   httpParams:[
                           url:"http://localhost:4321",
                           path:"/v1/targetgroup",
                           method: "POST"
                   
				   ]
				],
					   
				   
                        asg: [
                           "jsonBody": [
                                   "autoScalingGroupName": "my-auto-scaling-group",
                                   "launchConfigurationName": "my-launch-config",
                                   "desiredCapacity": "1",
                                   "maxSize": "2",
                                   "minSize": "1",
                                   "vpcZoneIdentifier": "subnet-4f628736",
                                   "targetGroupARNs":["arn:aws:elasticloadbalancing:us-west-2:702599048949:targetgroup/tg-1/fd89f1ccef7aff8c"]
                               ],
                       
					
				     httpParams:[
                         url:"http://localhost:4321",
                         path:"/v1/asg",
                         method: "POST"
                ]
							],
				  


                       elb :[
                           "jsonBody": [
                                   "name":"appELB",
                                   "securityGroups": ["sg-879965f8"],
                                   "subnets":["subnet-4f628736", "subnet-4787521d", "subnet-b0dfdbf8"]
                           ]
                     
                       
						   
							
					httpParams:[
                        url:"http://localhost:4321",
                        path:"/v1/loadbalancer",
                        method: "POST"
		
					]
						   ],
						
						
						
						
							
						elbListener: [
                             jsonBody: [
                               "defaultActions": [
                                   [
                                       "targetGroupArn": "arn:aws:elasticloadbalancing:us-west-2:702599048949:targetgroup/cool/20582d5d0f31e39e"
                                   ]
                               ],
                               "loadBalancerArn":"arn:aws:elasticloadbalancing:us-west-2:702599048949:loadbalancer/app/cool/77f57bdf01ad5db1",
                               "port": "80",
                               "protocol":"HTTP"
                           ]
                    
                         		
		
									
					httpParams:[
                            url:"http://localhost:4321",
                            path:"/v1/elbListener",
                            method: "POST"
							
							],
											
						],	
						],
													
                  //  def httpObj = new http.SimpleHTTPBuilder(this,params.launchcofig)
                    //def output = httpObj.sendRequest()
                    //echo "${output}"
                    def obj= new aws.ami.AMIDeployment(this,params)
                     obj.deploy()  
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
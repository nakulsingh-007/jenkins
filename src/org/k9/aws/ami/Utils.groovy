package org.k9.aws.ami

import groovy.time.*
import org.k9.*
//import org.k9.aws.ec2.instances.Instances
//import org.k9.aws.networking.route53.Route53
//import org.k9.aws.networking.route53.trafficflow.TrafficFlow

class Utils implements Serializable {
    def config
    def script
    //def output

    Utils(script, config) {
        this.script = script
        this.config = config
      //  this.output = output
    }
    def createAWSResources(def asg, def elb ){
        def lcOut = asg.createLaunchConfig()
        this.script.echo "${lcOut}"
    
        def lcOut1 = elb.createLoadBalancer()
        this.script.echo "${lcOut1}"
         
         def tarOut = elb.createtagertgroup()
         this.script.echo "${tarOut}"


         def asgOut = asg.createAutoscaling(tarOut)
         this.script.echo "${asgOut}"

         def elblOut = elb.createLoadBalancerlistenener(lcOut1,tarOut)
         this.script.echo "${elblOut}"



        
    //     if (lcOut['response'] == "success"){
    //     this.script.echo "LC created "
    //     }else{
    //     this.script.echo "LC error!!"
    //     status = [response: "error", msg: "LC error!!"]
    // return
    }
    
}

      
    


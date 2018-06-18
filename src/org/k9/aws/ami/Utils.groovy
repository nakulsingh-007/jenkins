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

    Utils(script, config, output) {
        this.script = script
        this.config = config
      //  this.output = output
    }
    def createAWSResources(def asg, def elb){
def lcOut =asg.createLaunchConfig()
    }

      
    }


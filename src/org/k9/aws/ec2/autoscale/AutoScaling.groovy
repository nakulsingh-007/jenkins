package org.k9.aws.ec2.autoscale

import groovy.time.*
import org.k9.*

class AutoScaling implements Serializable {
    def config
    def script
    // def output

    AutoScaling(script, config) {
        this.script = script
        this.config = config
        // this.output = output
    }
    def createLaunchConfig() {
        def lcOut = new http.SimpleHTTPBuilder(this.script,this.config.launchconfig)
        lcOut.sendRequest()
    
     def createAutoscaling() {
      //  def funcOutput = [:]this.config.asg['jsonBody']['autoScalingGroupName'] = "${this.config.deploymentName}-${this.config.subEnv}-asg-${output.dbData.version}-${output.dbData.buildNo}"
        //this.config.asg['jsonBody']['launchConfigurationName'] = output.global.launchConfName
       this.config.asg['jsonBody']['targetGroupARNs'] = [ output.global['tgARN'] ]
def lcOut4 = new http.SimpleHTTPBuilder(this.script,this.config.autoScalingGroup)
lcOut4.sendRequest()       

}
    }
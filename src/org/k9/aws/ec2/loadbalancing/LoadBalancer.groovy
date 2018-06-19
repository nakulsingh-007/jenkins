package org.k9.aws.ec2.loadbalancing

import groovy.time.*
import org.k9.*

class LoadBalancer implements Serializable {
    def config
    def script

    LoadBalancer(script, config) {
        this.script = script
        this.config = config
    }

 def createLoadBalancer() {
        def lcOut = new http.SimpleHTTPBuilder(this.script,this.config.elb)
        lcOut.sendRequest()
 }
 def createtagertgroup(){
     def tgOut= new http.SimpleHTTPBuilder(this.script,this.config.targetgroup)
     
     def out=tgOut.sendRequest()
     //this.script.echo "target group"${out}
     return out['tgARN']
     
 }

}
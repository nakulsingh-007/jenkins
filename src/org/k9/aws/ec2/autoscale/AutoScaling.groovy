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

    }
}
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
}
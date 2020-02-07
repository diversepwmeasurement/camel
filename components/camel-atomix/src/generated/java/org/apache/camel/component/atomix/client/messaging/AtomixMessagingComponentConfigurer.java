/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.atomix.client.messaging;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class AtomixMessagingComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        AtomixMessagingComponent target = (AtomixMessagingComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "atomix": target.setAtomix(property(camelContext, io.atomix.AtomixClient.class, value)); return true;
        case "configuration": target.setConfiguration(property(camelContext, org.apache.camel.component.atomix.client.messaging.AtomixMessagingConfiguration.class, value)); return true;
        case "configurationuri":
        case "configurationUri": target.setConfigurationUri(property(camelContext, java.lang.String.class, value)); return true;
        case "nodes": target.setNodes(property(camelContext, java.util.List.class, value)); return true;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "basicpropertybinding":
        case "basicPropertyBinding": target.setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        default: return false;
        }
    }

}


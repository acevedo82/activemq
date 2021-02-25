package com.nokia.smp.smallcells.messaging;

import java.util.Iterator;
import java.util.Map;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class MessageConverter {
	
	Logger logger = LoggerFactory.getLogger(MessageConverter.class);
	
    public void convertMessage(Exchange message ) {
    	logger.debug("Convering message");
    	
    	StringBuffer body = new StringBuffer();
    	if(message.getIn().getBody() instanceof Map) {
    		Map map = (Map) message.getIn().getBody();
    		Iterator<String> i = (map).keySet().iterator();
    		while(i.hasNext()) {
    			String key = i.next();
    			Object value = (Object) (map).get(key);
    			body.append(key).append("=").append(value).append(System.lineSeparator());
    		}    		
    		
    	} else {
    		String str = (String) message.getIn().getBody();
    		body.append(str);
    		
    	}
    	message.getIn().setBody(body.toString());
    	logger.debug("Body="+body.toString());
    	
    }
}

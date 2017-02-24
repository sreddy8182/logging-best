package logging.best.processor.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import logging.best.processor.LoggingProcessor;

public class SetBodyProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(SetBodyProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String[] body = new String[]{"1","2","3","4","5","STOP"};
		exchange.getOut().setBody(body);
		logger.info("Set the body of Exchange to "+body);
	}

}

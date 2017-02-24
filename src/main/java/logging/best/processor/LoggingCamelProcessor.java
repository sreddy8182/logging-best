package logging.best.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCamelProcessor implements Processor{
	
	Logger logger = LoggerFactory.getLogger(LoggingProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		logger.info("Logging Body from CamelProcessor Bean  "+exchange.getIn().getBody());
		
	}
}

package logging.best.processor;

import org.apache.camel.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingProcessor {
	
	Logger logger = LoggerFactory.getLogger(LoggingProcessor.class);
	
	public void callme(@Body Object body){
		logger.info("Logging Body from Normal Bean  "+body);
	}

}

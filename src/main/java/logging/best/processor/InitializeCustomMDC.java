package logging.best.processor;

import org.slf4j.MDC;

public class InitializeCustomMDC {

	public InitializeCustomMDC(String id){
		MDC.put("applicationId", id);
	}
	
}

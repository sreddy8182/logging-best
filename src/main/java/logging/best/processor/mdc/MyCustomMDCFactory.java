package logging.best.processor.mdc;

import org.apache.camel.Exchange;
import org.apache.camel.spi.UnitOfWork;
import org.apache.camel.spi.UnitOfWorkFactory;

public class MyCustomMDCFactory implements UnitOfWorkFactory{

	@Override
	public UnitOfWork createUnitOfWork(Exchange exchange) {
		return new MyCustomMDC(exchange);
	}

}

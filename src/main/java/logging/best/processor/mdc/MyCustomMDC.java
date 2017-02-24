package logging.best.processor.mdc;

import org.apache.camel.AsyncCallback;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.MDCUnitOfWork;
import org.apache.camel.spi.UnitOfWork;
import org.slf4j.MDC;

public class MyCustomMDC extends MDCUnitOfWork implements UnitOfWork {

	public static final String MDC_SPL_ID = "appId";
	private final String mySpeciaId;

	public MyCustomMDC(Exchange exchange) {
		super(exchange);
		this.mySpeciaId = MDC.get(MDC_SPL_ID);
		MDC.put(MDC_SPL_ID, exchange.getProperty(MDC_SPL_ID, String.class)!=null?exchange.getProperty(MDC_SPL_ID, String.class):"NoId");
	}

	@Override
	public UnitOfWork newInstance(Exchange exchange) {
		return new MyCustomMDC(exchange);
	}

	
	@Override
	public AsyncCallback beforeProcess(Processor processor, Exchange exchange, AsyncCallback callback) {
		return new MyCustomCallback(callback);
	}

	private static final class MyCustomCallback implements AsyncCallback {

		private final AsyncCallback delegate;
		private final String breadcrumbId;
		private final String exchangeId;
		private final String messageId;
		private final String correlationId;
		private final String routeId;
		private final String camelContextId;
		private final String specialId;

		private MyCustomCallback(AsyncCallback delegate) {
			this.delegate = delegate;
			this.breadcrumbId = MDC.get(MDC_BREADCRUMB_ID);
			this.exchangeId = MDC.get(MDC_EXCHANGE_ID);
			this.messageId = MDC.get(MDC_MESSAGE_ID);
			this.correlationId = MDC.get(MDC_CORRELATION_ID);
			this.routeId = MDC.get(MDC_ROUTE_ID);
			this.camelContextId = MDC.get(MDC_CAMEL_CONTEXT_ID);
			this.specialId = MDC.get(MDC_SPL_ID);
		}

		@Override
		public void done(boolean doneSync) {
			try {
				if (!doneSync) {
					// when done asynchronously then restore information from
					// previous thread
					if (breadcrumbId != null) {
						MDC.put(MDC_BREADCRUMB_ID, breadcrumbId);
					}
					if (specialId != null) {
						MDC.put(MDC_SPL_ID, specialId);
					}
					if (exchangeId != null) {
						MDC.put(MDC_EXCHANGE_ID, exchangeId);
					}
					if (messageId != null) {
						MDC.put(MDC_MESSAGE_ID, messageId);
					}
					if (correlationId != null) {
						MDC.put(MDC_CORRELATION_ID, correlationId);
					}
					if (camelContextId != null) {
						MDC.put(MDC_CAMEL_CONTEXT_ID, camelContextId);
					}
				}
				// need to setup the routeId finally
				if (routeId != null) {
					MDC.put(MDC_ROUTE_ID, routeId);
				}
				
			} finally {
				// muse ensure delegate is invoked
				delegate.done(doneSync);
			}

		}
		@Override
		  public String toString() {
		    return delegate.toString();
		  }

	}
}

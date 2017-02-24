This project is intended as  demo for MDC logging in fuse for per context logging and also per application logging , which can span across
multiple contexts and bundles.

1. For configuring MDC logging in fuse
2. To enable creating one file per context
3. To log multiple categories of relavant info to the context file
4. Custom MDC ( not best practice in terms of setting the key ) implementaion for a key called appId
    Using Custom UnitOfWork implmentation and by setting the property in camel exchange for the
    custom key appid
    Class implementation : logging.best.processor.mdc.MyCustomMDC   & logging.best.processor.mdc.MyCustomMDCFactory
    data : data/myloggingdemo.log
5. Custom MDC implementation for blueprint using MDC.put("applicationId", id) via a bean.
    Class implementaion : logging.best.processor.InitializeCustomMDC
    data : data/myloggingdemo
    

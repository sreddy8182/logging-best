This project is a demo 
1. For configuring MDC logging in fuse
2. To enable creating one file per context
3. To log multiple categories of relavant info to the context file
4. Custom MDC ( not best practice in terms of setting the key ) implementaion for a key called appId
    Using Custom UnitOfWork implmentation and by setting the property in camel exchange for the
    custom key
5. Custom MDC implementation for blueprint using MDC.put("applicationId", id) via a bean.
    Class implementaion : logging.best.processor.InitializeCustomMDC
    data : data/
    

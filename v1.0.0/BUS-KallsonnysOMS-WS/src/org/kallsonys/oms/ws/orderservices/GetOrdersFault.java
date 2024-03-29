
package org.kallsonys.oms.ws.orderservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-11-10T11:19:09.766-05:00
 * Generated source version: 2.6.3
 */

@WebFault(name = "OrderException", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types")
public class GetOrdersFault extends Exception {
    
    private com.integration.kallsonys.kallsonysschema.types.GlobalException orderException;

    public GetOrdersFault() {
        super();
    }
    
    public GetOrdersFault(String message) {
        super(message);
    }
    
    public GetOrdersFault(String message, Throwable cause) {
        super(message, cause);
    }

    public GetOrdersFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException orderException) {
        super(message);
        this.orderException = orderException;
    }

    public GetOrdersFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException orderException, Throwable cause) {
        super(message, cause);
        this.orderException = orderException;
    }

    public com.integration.kallsonys.kallsonysschema.types.GlobalException getFaultInfo() {
        return this.orderException;
    }
}

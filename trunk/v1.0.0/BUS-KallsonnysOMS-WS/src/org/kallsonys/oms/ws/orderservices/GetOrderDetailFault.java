
package org.kallsonys.oms.ws.orderservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-11-10T11:19:09.813-05:00
 * Generated source version: 2.6.3
 */

@WebFault(name = "OrderException", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types")
public class GetOrderDetailFault extends Exception {
    
    private com.integration.kallsonys.kallsonysschema.types.GlobalException orderException;

    public GetOrderDetailFault() {
        super();
    }
    
    public GetOrderDetailFault(String message) {
        super(message);
    }
    
    public GetOrderDetailFault(String message, Throwable cause) {
        super(message, cause);
    }

    public GetOrderDetailFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException orderException) {
        super(message);
        this.orderException = orderException;
    }

    public GetOrderDetailFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException orderException, Throwable cause) {
        super(message, cause);
        this.orderException = orderException;
    }

    public com.integration.kallsonys.kallsonysschema.types.GlobalException getFaultInfo() {
        return this.orderException;
    }
}

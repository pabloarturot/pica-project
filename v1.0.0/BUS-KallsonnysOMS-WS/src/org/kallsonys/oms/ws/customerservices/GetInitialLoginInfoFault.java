
package org.kallsonys.oms.ws.customerservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-11-10T11:19:06.518-05:00
 * Generated source version: 2.6.3
 */

@WebFault(name = "CustomerException", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types")
public class GetInitialLoginInfoFault extends Exception {
    
    private com.integration.kallsonys.kallsonysschema.types.GlobalException customerException;

    public GetInitialLoginInfoFault() {
        super();
    }
    
    public GetInitialLoginInfoFault(String message) {
        super(message);
    }
    
    public GetInitialLoginInfoFault(String message, Throwable cause) {
        super(message, cause);
    }

    public GetInitialLoginInfoFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException customerException) {
        super(message);
        this.customerException = customerException;
    }

    public GetInitialLoginInfoFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException customerException, Throwable cause) {
        super(message, cause);
        this.customerException = customerException;
    }

    public com.integration.kallsonys.kallsonysschema.types.GlobalException getFaultInfo() {
        return this.customerException;
    }
}

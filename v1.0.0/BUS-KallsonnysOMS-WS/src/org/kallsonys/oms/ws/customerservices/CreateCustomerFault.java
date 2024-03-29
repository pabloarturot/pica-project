
package org.kallsonys.oms.ws.customerservices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-11-10T11:19:06.638-05:00
 * Generated source version: 2.6.3
 */

@WebFault(name = "CustomerException", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types")
public class CreateCustomerFault extends Exception {
    
    private com.integration.kallsonys.kallsonysschema.types.GlobalException customerException;

    public CreateCustomerFault() {
        super();
    }
    
    public CreateCustomerFault(String message) {
        super(message);
    }
    
    public CreateCustomerFault(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateCustomerFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException customerException) {
        super(message);
        this.customerException = customerException;
    }

    public CreateCustomerFault(String message, com.integration.kallsonys.kallsonysschema.types.GlobalException customerException, Throwable cause) {
        super(message, cause);
        this.customerException = customerException;
    }

    public com.integration.kallsonys.kallsonysschema.types.GlobalException getFaultInfo() {
        return this.customerException;
    }
}

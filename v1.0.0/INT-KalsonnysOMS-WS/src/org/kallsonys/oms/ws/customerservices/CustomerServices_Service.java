package org.kallsonys.oms.ws.customerservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-10-22T03:16:44.816-05:00
 * Generated source version: 2.6.3
 * 
 */
@WebServiceClient(name = "CustomerServices", 
                  wsdlLocation = "file:/Users/macbook/Documents/INT-KalsonnysOMS-WS/resources/wsdl/customerServices.wsdl",
                  targetNamespace = "http://ws.oms.kallsonys.org/customerservices") 
public class CustomerServices_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.oms.kallsonys.org/customerservices", "CustomerServices");
    public final static QName CustomerServicesSOAP = new QName("http://ws.oms.kallsonys.org/customerservices", "CustomerServicesSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/macbook/Documents/INT-KalsonnysOMS-WS/resources/wsdl/customerServices.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerServices_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/macbook/Documents/INT-KalsonnysOMS-WS/resources/wsdl/customerServices.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerServices_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerServices_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns CustomerServices
     */
    @WebEndpoint(name = "CustomerServicesSOAP")
    public CustomerServices getCustomerServicesSOAP() {
        return super.getPort(CustomerServicesSOAP, CustomerServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerServices
     */
    @WebEndpoint(name = "CustomerServicesSOAP")
    public CustomerServices getCustomerServicesSOAP(WebServiceFeature... features) {
        return super.getPort(CustomerServicesSOAP, CustomerServices.class, features);
    }

}

package com.integration.kallsonys.productservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-08-31T20:03:03.024-05:00
 * Generated source version: 2.6.3
 * 
 */
@WebServiceClient(name = "ProductServices", 
                  wsdlLocation = "file:/Users/macbook/Documents/IntegrationRoutes/src/main/resources/wsdl/productServices.wsdl",
                  targetNamespace = "http://kallsonys.integration.com/productservices") 
public class ProductServices_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://kallsonys.integration.com/productservices", "ProductServices");
    public final static QName ProductServicesSOAP = new QName("http://kallsonys.integration.com/productservices", "ProductServicesSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/macbook/Documents/IntegrationRoutes/src/main/resources/wsdl/productServices.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ProductServices_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/macbook/Documents/IntegrationRoutes/src/main/resources/wsdl/productServices.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ProductServices_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ProductServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductServices_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ProductServices
     */
    @WebEndpoint(name = "ProductServicesSOAP")
    public ProductServices getProductServicesSOAP() {
        return super.getPort(ProductServicesSOAP, ProductServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductServices
     */
    @WebEndpoint(name = "ProductServicesSOAP")
    public ProductServices getProductServicesSOAP(WebServiceFeature... features) {
        return super.getPort(ProductServicesSOAP, ProductServices.class, features);
    }

}
package org.kallsonys.oms.ws.productservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.3
 * 2013-10-28T22:25:56.459-05:00
 * Generated source version: 2.6.3
 * 
 */
@WebService(targetNamespace = "http://ws.oms.kallsonys.org/productservices", name = "ProductServices")
@XmlSeeAlso({com.integration.kallsonys.kallsonysschema.types.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ProductServices {

    @WebResult(name = "infoProductList", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types", partName = "getProductsResponse")
    @WebMethod
    public com.integration.kallsonys.kallsonysschema.types.ProductList getProducts(
        @WebParam(partName = "getProductsRequest", name = "infoPaging", targetNamespace = "http://kallsonys.integration.com/kallsonysschema/types")
        com.integration.kallsonys.kallsonysschema.types.PagingDto getProductsRequest
    ) throws ProductFault;
}

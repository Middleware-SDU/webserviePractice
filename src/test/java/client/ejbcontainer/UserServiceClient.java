package client.ejbcontainer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import cn.edu.sdu.webservice.ejbcontainer.service.UserService;

/**
 * WebService Client
 * @author Yonggang Yuan
 *
 */

@WebServiceClient(
      wsdlLocation="http://localhost:8080/sdu-webservice-app/UserService/UserService?wsdl"
)
public class UserServiceClient extends Service {

    private final static URL WSDL_LOCATION;
    private final static WebServiceException WEBSERVICE_EXCEPTION;
    private final static QName WEBSERVICE_QNAME = new QName("http://ejbcontainer.webservice.sdu.edu.cn/", "UserService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/sdu-webservice-app/UserService/UserService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSDL_LOCATION = url;
        WEBSERVICE_EXCEPTION = e;
    }

    public UserServiceClient() {
        super(__getWsdlLocation(), WEBSERVICE_QNAME);
    }

    public UserServiceClient(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICE_QNAME, features);
    }

    public UserServiceClient(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICE_QNAME);
    }

    public UserServiceClient(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICE_QNAME, features);
    }

    public UserServiceClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserServiceClient(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     */
    @WebEndpoint(name = "UserServicePort")
    public UserService getManagerWebServicePort() {
        return super.getPort(new QName("http://ejbcontainer.webservice.sdu.edu.cn/", "UserServicePort"), UserService.class);
    }

    /**
     * 
     * @param features
     * @return
     */
    @WebEndpoint(name = "UserServicePort")
    public UserService getManagerWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ejbcontainer.webservice.sdu.edu.cn/", "UserServicePort"), UserService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICE_EXCEPTION!= null) {
            throw WEBSERVICE_EXCEPTION;
        }
        return WSDL_LOCATION;
    }

}

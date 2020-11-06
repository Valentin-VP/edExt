/**
 * ControladorInscripcionEdicionPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorInscripcionEdicionPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorInscripcionEdicionPublishService {

    public ControladorInscripcionEdicionPublishServiceLocator() {
    }


    public ControladorInscripcionEdicionPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorInscripcionEdicionPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorInscripcionEdicionPublishPort
    private java.lang.String ControladorInscripcionEdicionPublishPort_address = "http://127.0.0.1:1942/controladorInscripcionEdicion";

    public java.lang.String getControladorInscripcionEdicionPublishPortAddress() {
        return ControladorInscripcionEdicionPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorInscripcionEdicionPublishPortWSDDServiceName = "ControladorInscripcionEdicionPublishPort";

    public java.lang.String getControladorInscripcionEdicionPublishPortWSDDServiceName() {
        return ControladorInscripcionEdicionPublishPortWSDDServiceName;
    }

    public void setControladorInscripcionEdicionPublishPortWSDDServiceName(java.lang.String name) {
        ControladorInscripcionEdicionPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorInscripcionEdicionPublish getControladorInscripcionEdicionPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorInscripcionEdicionPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorInscripcionEdicionPublishPort(endpoint);
    }

    public publicadores.ControladorInscripcionEdicionPublish getControladorInscripcionEdicionPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorInscripcionEdicionPublishPortBindingStub _stub = new publicadores.ControladorInscripcionEdicionPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorInscripcionEdicionPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorInscripcionEdicionPublishPortEndpointAddress(java.lang.String address) {
        ControladorInscripcionEdicionPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorInscripcionEdicionPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorInscripcionEdicionPublishPortBindingStub _stub = new publicadores.ControladorInscripcionEdicionPublishPortBindingStub(new java.net.URL(ControladorInscripcionEdicionPublishPort_address), this);
                _stub.setPortName(getControladorInscripcionEdicionPublishPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorInscripcionEdicionPublishPort".equals(inputPortName)) {
            return getControladorInscripcionEdicionPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorInscripcionEdicionPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorInscripcionEdicionPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorInscripcionEdicionPublishPort".equals(portName)) {
            setControladorInscripcionEdicionPublishPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

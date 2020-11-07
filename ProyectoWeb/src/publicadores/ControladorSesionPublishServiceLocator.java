/**
 * ControladorSesionPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorSesionPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorSesionPublishService {

    public ControladorSesionPublishServiceLocator() {
    }


    public ControladorSesionPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorSesionPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorSesionPublishPort
    private java.lang.String ControladorSesionPublishPort_address = "http://127.0.0.1:1942/controladorSesion";

    public java.lang.String getControladorSesionPublishPortAddress() {
        return ControladorSesionPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorSesionPublishPortWSDDServiceName = "ControladorSesionPublishPort";

    public java.lang.String getControladorSesionPublishPortWSDDServiceName() {
        return ControladorSesionPublishPortWSDDServiceName;
    }

    public void setControladorSesionPublishPortWSDDServiceName(java.lang.String name) {
        ControladorSesionPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorSesionPublish getControladorSesionPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorSesionPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorSesionPublishPort(endpoint);
    }

    public publicadores.ControladorSesionPublish getControladorSesionPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorSesionPublishPortBindingStub _stub = new publicadores.ControladorSesionPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorSesionPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorSesionPublishPortEndpointAddress(java.lang.String address) {
        ControladorSesionPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorSesionPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorSesionPublishPortBindingStub _stub = new publicadores.ControladorSesionPublishPortBindingStub(new java.net.URL(ControladorSesionPublishPort_address), this);
                _stub.setPortName(getControladorSesionPublishPortWSDDServiceName());
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
        if ("ControladorSesionPublishPort".equals(inputPortName)) {
            return getControladorSesionPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorSesionPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorSesionPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorSesionPublishPort".equals(portName)) {
            setControladorSesionPublishPortEndpointAddress(address);
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

/**
 * ControladorListarAceptadosAEdicionPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorListarAceptadosAEdicionPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorListarAceptadosAEdicionPublishService {

    public ControladorListarAceptadosAEdicionPublishServiceLocator() {
    }


    public ControladorListarAceptadosAEdicionPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorListarAceptadosAEdicionPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorListarAceptadosAEdicionPublishPort
    private java.lang.String ControladorListarAceptadosAEdicionPublishPort_address = "http://127.0.0.1:1942/controladorListarAceptadosAEdicion";

    public java.lang.String getControladorListarAceptadosAEdicionPublishPortAddress() {
        return ControladorListarAceptadosAEdicionPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorListarAceptadosAEdicionPublishPortWSDDServiceName = "ControladorListarAceptadosAEdicionPublishPort";

    public java.lang.String getControladorListarAceptadosAEdicionPublishPortWSDDServiceName() {
        return ControladorListarAceptadosAEdicionPublishPortWSDDServiceName;
    }

    public void setControladorListarAceptadosAEdicionPublishPortWSDDServiceName(java.lang.String name) {
        ControladorListarAceptadosAEdicionPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorListarAceptadosAEdicionPublish getControladorListarAceptadosAEdicionPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorListarAceptadosAEdicionPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorListarAceptadosAEdicionPublishPort(endpoint);
    }

    public publicadores.ControladorListarAceptadosAEdicionPublish getControladorListarAceptadosAEdicionPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorListarAceptadosAEdicionPublishPortBindingStub _stub = new publicadores.ControladorListarAceptadosAEdicionPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorListarAceptadosAEdicionPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorListarAceptadosAEdicionPublishPortEndpointAddress(java.lang.String address) {
        ControladorListarAceptadosAEdicionPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorListarAceptadosAEdicionPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorListarAceptadosAEdicionPublishPortBindingStub _stub = new publicadores.ControladorListarAceptadosAEdicionPublishPortBindingStub(new java.net.URL(ControladorListarAceptadosAEdicionPublishPort_address), this);
                _stub.setPortName(getControladorListarAceptadosAEdicionPublishPortWSDDServiceName());
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
        if ("ControladorListarAceptadosAEdicionPublishPort".equals(inputPortName)) {
            return getControladorListarAceptadosAEdicionPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorListarAceptadosAEdicionPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorListarAceptadosAEdicionPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorListarAceptadosAEdicionPublishPort".equals(portName)) {
            setControladorListarAceptadosAEdicionPublishPortEndpointAddress(address);
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

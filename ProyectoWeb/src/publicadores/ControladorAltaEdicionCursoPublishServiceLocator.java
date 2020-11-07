/**
 * ControladorAltaEdicionCursoPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorAltaEdicionCursoPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorAltaEdicionCursoPublishService {

    public ControladorAltaEdicionCursoPublishServiceLocator() {
    }


    public ControladorAltaEdicionCursoPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAltaEdicionCursoPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAltaEdicionCursoPublishPort
    private java.lang.String ControladorAltaEdicionCursoPublishPort_address = "http://127.0.0.1:1942/controladorAltaEdicionCurso";

    public java.lang.String getControladorAltaEdicionCursoPublishPortAddress() {
        return ControladorAltaEdicionCursoPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAltaEdicionCursoPublishPortWSDDServiceName = "ControladorAltaEdicionCursoPublishPort";

    public java.lang.String getControladorAltaEdicionCursoPublishPortWSDDServiceName() {
        return ControladorAltaEdicionCursoPublishPortWSDDServiceName;
    }

    public void setControladorAltaEdicionCursoPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAltaEdicionCursoPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorAltaEdicionCursoPublish getControladorAltaEdicionCursoPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAltaEdicionCursoPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAltaEdicionCursoPublishPort(endpoint);
    }

    public publicadores.ControladorAltaEdicionCursoPublish getControladorAltaEdicionCursoPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorAltaEdicionCursoPublishPortBindingStub _stub = new publicadores.ControladorAltaEdicionCursoPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAltaEdicionCursoPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAltaEdicionCursoPublishPortEndpointAddress(java.lang.String address) {
        ControladorAltaEdicionCursoPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorAltaEdicionCursoPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorAltaEdicionCursoPublishPortBindingStub _stub = new publicadores.ControladorAltaEdicionCursoPublishPortBindingStub(new java.net.URL(ControladorAltaEdicionCursoPublishPort_address), this);
                _stub.setPortName(getControladorAltaEdicionCursoPublishPortWSDDServiceName());
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
        if ("ControladorAltaEdicionCursoPublishPort".equals(inputPortName)) {
            return getControladorAltaEdicionCursoPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaEdicionCursoPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaEdicionCursoPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAltaEdicionCursoPublishPort".equals(portName)) {
            setControladorAltaEdicionCursoPublishPortEndpointAddress(address);
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

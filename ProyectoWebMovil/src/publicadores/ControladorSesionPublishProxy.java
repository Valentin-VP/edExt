package publicadores;

public class ControladorSesionPublishProxy implements publicadores.ControladorSesionPublish {
  private String _endpoint = null;
  private publicadores.ControladorSesionPublish controladorSesionPublish = null;
  
  public ControladorSesionPublishProxy() {
    _initControladorSesionPublishProxy();
  }
  
  public ControladorSesionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorSesionPublishProxy();
  }
  
  private void _initControladorSesionPublishProxy() {
    try {
      controladorSesionPublish = (new publicadores.ControladorSesionPublishServiceLocator()).getControladorSesionPublishPort();
      if (controladorSesionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorSesionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorSesionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorSesionPublish != null)
      ((javax.xml.rpc.Stub)controladorSesionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorSesionPublish getControladorSesionPublish() {
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish;
  }
  
  public java.lang.String identificarUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.identificarUsuario(arg0, arg1);
  }
  
  public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    controladorSesionPublish.setMensaje(arg0);
  }
  
  public boolean existeUsuario(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.existeUsuario(arg0);
  }
  
  public java.lang.String obtenerCorreo() throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.obtenerCorreo();
  }
  
  public java.lang.String codificarPass(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.codificarPass(arg0);
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.getMensaje();
  }
  
  public java.lang.String obtenerNick() throws java.rmi.RemoteException{
    if (controladorSesionPublish == null)
      _initControladorSesionPublishProxy();
    return controladorSesionPublish.obtenerNick();
  }
  
  
}
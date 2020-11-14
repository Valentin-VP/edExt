package publicadores;

public class ControladorAltaUsuarioPublishProxy implements publicadores.ControladorAltaUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaUsuarioPublish controladorAltaUsuarioPublish = null;
  
  public ControladorAltaUsuarioPublishProxy() {
    _initControladorAltaUsuarioPublishProxy();
  }
  
  public ControladorAltaUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaUsuarioPublishProxy();
  }
  
  private void _initControladorAltaUsuarioPublishProxy() {
    try {
      controladorAltaUsuarioPublish = (new publicadores.ControladorAltaUsuarioPublishServiceLocator()).getControladorAltaUsuarioPublishPort();
      if (controladorAltaUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaUsuarioPublish getControladorAltaUsuarioPublish() {
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish;
  }
  
  public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish.listarInstitutos();
  }
  
  public void seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.seleccionarInstituto(arg0);
  }
  
  public void confirmarAltaUsuario(boolean arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.confirmarAltaUsuario(arg0);
  }
  
  public java.lang.String codificarPass(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish.codificarPass(arg0);
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish.getMensaje();
  }
  
  public void altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, publicadores.DtFecha arg4, java.lang.String arg5) throws java.rmi.RemoteException, publicadores.UsuarioRepetido{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.altaUsuario(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.setMensaje(arg0);
  }
  
  
}
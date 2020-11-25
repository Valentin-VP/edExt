package publicadores;

public class ControladorConsultaUsuarioPublishProxy implements publicadores.ControladorConsultaUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaUsuarioPublish controladorConsultaUsuarioPublish = null;
  
  public ControladorConsultaUsuarioPublishProxy() {
    _initControladorConsultaUsuarioPublishProxy();
  }
  
  public ControladorConsultaUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaUsuarioPublishProxy();
  }
  
  private void _initControladorConsultaUsuarioPublishProxy() {
    try {
      controladorConsultaUsuarioPublish = (new publicadores.ControladorConsultaUsuarioPublishServiceLocator()).getControladorConsultaUsuarioPublishPort();
      if (controladorConsultaUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaUsuarioPublish getControladorConsultaUsuarioPublish() {
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish;
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getMensaje();
  }
  
  public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    controladorConsultaUsuarioPublish.setMensaje(arg0);
  }
  
  public publicadores.DtUsuario elegirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.elegirUsuario(arg0, arg1);
  }
  
  public publicadores.DtEdicion[] infoEdiciones(boolean arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.infoEdiciones(arg0);
  }
  
  public publicadores.DtUsuario[] listarDtUsuarios() throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.listarDtUsuarios();
  }
  
  public publicadores.DtPrograma[] infoProgramas() throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.infoProgramas();
  }
  
  
}
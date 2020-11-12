package publicadores;

public class ControladorAltaEdicionCursoPublishProxy implements publicadores.ControladorAltaEdicionCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaEdicionCursoPublish controladorAltaEdicionCursoPublish = null;
  
  public ControladorAltaEdicionCursoPublishProxy() {
    _initControladorAltaEdicionCursoPublishProxy();
  }
  
  public ControladorAltaEdicionCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaEdicionCursoPublishProxy();
  }
  
  private void _initControladorAltaEdicionCursoPublishProxy() {
    try {
      controladorAltaEdicionCursoPublish = (new publicadores.ControladorAltaEdicionCursoPublishServiceLocator()).getControladorAltaEdicionCursoPublishPort();
      if (controladorAltaEdicionCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaEdicionCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaEdicionCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaEdicionCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaEdicionCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaEdicionCursoPublish getControladorAltaEdicionCursoPublish() {
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    return controladorAltaEdicionCursoPublish;
  }
  
  public publicadores.DtUsuarioBase[] getUsuarios() throws java.rmi.RemoteException{
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    return controladorAltaEdicionCursoPublish.getUsuarios();
  }
  
  public publicadores.DtUsuarioBase[] getDocentes() throws java.rmi.RemoteException{
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    return controladorAltaEdicionCursoPublish.getDocentes();
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    return controladorAltaEdicionCursoPublish.getMensaje();
  }
  
  public void altaEdicionCurso(java.lang.String arg0, java.lang.String arg1, publicadores.DtFecha arg2, publicadores.DtFecha arg3, java.lang.String[] arg4, boolean arg5, int arg6, publicadores.DtFecha arg7) throws java.rmi.RemoteException, publicadores.UsuarioNoDocente, publicadores.EdicionRepetida, publicadores.CursoNoExiste, publicadores.InstitutoInexistente{
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    controladorAltaEdicionCursoPublish.altaEdicionCurso(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente{
    if (controladorAltaEdicionCursoPublish == null)
      _initControladorAltaEdicionCursoPublishProxy();
    return controladorAltaEdicionCursoPublish.seleccionarInstituto(arg0);
  }
  
  
}
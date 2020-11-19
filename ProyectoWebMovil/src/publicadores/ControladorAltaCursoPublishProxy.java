package publicadores;

public class ControladorAltaCursoPublishProxy implements publicadores.ControladorAltaCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaCursoPublish controladorAltaCursoPublish = null;
  
  public ControladorAltaCursoPublishProxy() {
    _initControladorAltaCursoPublishProxy();
  }
  
  public ControladorAltaCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaCursoPublishProxy();
  }
  
  private void _initControladorAltaCursoPublishProxy() {
    try {
      controladorAltaCursoPublish = (new publicadores.ControladorAltaCursoPublishServiceLocator()).getControladorAltaCursoPublishPort();
      if (controladorAltaCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaCursoPublish getControladorAltaCursoPublish() {
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish;
  }
  
  public void confirmarAltaCurso() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.confirmarAltaCurso();
  }
  
  public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.listarInstitutos();
  }
  
  public void agregarPrevia(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.agregarPrevia(arg0);
  }
  
  public java.lang.String[] listarCategorias() throws java.rmi.RemoteException, publicadores.SinCategorias{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.listarCategorias();
  }
  
  public void altaCurso(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4, int arg5, java.lang.String arg6, publicadores.DtFecha arg7) throws java.rmi.RemoteException, publicadores.CursoRepetido, publicadores.InstitutoInexistente{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.altaCurso(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void agregarCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.agregarCategoria(arg0);
  }
  
  public void cancelarAltaCurso() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.cancelarAltaCurso();
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.getMensaje();
  }
  
  public void cleanCategorias() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.cleanCategorias();
  }
  
  public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.setMensaje(arg0);
  }
  
  
}
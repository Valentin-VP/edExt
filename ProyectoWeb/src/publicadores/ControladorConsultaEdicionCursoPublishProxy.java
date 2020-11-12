package publicadores;

public class ControladorConsultaEdicionCursoPublishProxy implements publicadores.ControladorConsultaEdicionCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaEdicionCursoPublish controladorConsultaEdicionCursoPublish = null;
  
  public ControladorConsultaEdicionCursoPublishProxy() {
    _initControladorConsultaEdicionCursoPublishProxy();
  }
  
  public ControladorConsultaEdicionCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaEdicionCursoPublishProxy();
  }
  
  private void _initControladorConsultaEdicionCursoPublishProxy() {
    try {
      controladorConsultaEdicionCursoPublish = (new publicadores.ControladorConsultaEdicionCursoPublishServiceLocator()).getControladorConsultaEdicionCursoPublishPort();
      if (controladorConsultaEdicionCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaEdicionCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaEdicionCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaEdicionCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaEdicionCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaEdicionCursoPublish getControladorConsultaEdicionCursoPublish() {
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish;
  }
  
  public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.seleccionarEdicion(arg0);
  }
  
  public java.lang.String[] getDocentes(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.getDocentes(arg0);
  }
  
  public publicadores.DtEdicion getDtEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.getDtEdicion(arg0);
  }
  
  public java.lang.String getNombreCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.getNombreCurso(arg0);
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.getMensaje();
  }
  
  public publicadores.DtCursoBase[] seleccionarCategoria(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CategoriaInexistente{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.seleccionarCategoria(arg0);
  }
  
  public publicadores.DtInstituto[] getInstitutosConCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.getInstitutosConCurso(arg0);
  }
  
  public publicadores.DtEdicionBase[] seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoNoExiste{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.seleccionarCurso(arg0);
  }
  
  public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente{
    if (controladorConsultaEdicionCursoPublish == null)
      _initControladorConsultaEdicionCursoPublishProxy();
    return controladorConsultaEdicionCursoPublish.seleccionarInstituto(arg0);
  }
  
  
}
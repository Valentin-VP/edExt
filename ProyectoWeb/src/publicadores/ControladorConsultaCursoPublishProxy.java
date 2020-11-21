package publicadores;

public class ControladorConsultaCursoPublishProxy implements publicadores.ControladorConsultaCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaCursoPublish controladorConsultaCursoPublish = null;
  
  public ControladorConsultaCursoPublishProxy() {
    _initControladorConsultaCursoPublishProxy();
  }
  
  public ControladorConsultaCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaCursoPublishProxy();
  }
  
  private void _initControladorConsultaCursoPublishProxy() {
    try {
      controladorConsultaCursoPublish = (new publicadores.ControladorConsultaCursoPublishServiceLocator()).getControladorConsultaCursoPublishPort();
      if (controladorConsultaCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaCursoPublish getControladorConsultaCursoPublish() {
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish;
  }
  
  public java.lang.String getMensaje() throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getMensaje();
  }
  
  public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    controladorConsultaCursoPublish.setMensaje(arg0);
  }
  
  public java.lang.String[] listarCategorias() throws java.rmi.RemoteException, publicadores.SinCategorias{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.listarCategorias();
  }
  
  public publicadores.DtCursoBase[] listarCursosInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.listarCursosInstituto(arg0);
  }
  
  public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.listarInstitutos();
  }
  
  public publicadores.DtCurso consultarCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.consultarCurso(arg0);
  }
  
  public publicadores.DtProgramaBase[] getProgramas() throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getProgramas();
  }
  
  public publicadores.DtCursoBase[] listarCursosCategoria(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CategoriaInexistente, publicadores.CategoriaSinCursos{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.listarCursosCategoria(arg0);
  }
  
  public publicadores.DtCurso[] listarCursosPlataforma() throws java.rmi.RemoteException, publicadores.SinCursos{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.listarCursosPlataforma();
  }
  
  
}
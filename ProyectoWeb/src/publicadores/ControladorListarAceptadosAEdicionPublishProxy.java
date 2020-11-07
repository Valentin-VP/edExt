package publicadores;

public class ControladorListarAceptadosAEdicionPublishProxy implements publicadores.ControladorListarAceptadosAEdicionPublish {
  private String _endpoint = null;
  private publicadores.ControladorListarAceptadosAEdicionPublish controladorListarAceptadosAEdicionPublish = null;
  
  public ControladorListarAceptadosAEdicionPublishProxy() {
    _initControladorListarAceptadosAEdicionPublishProxy();
  }
  
  public ControladorListarAceptadosAEdicionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorListarAceptadosAEdicionPublishProxy();
  }
  
  private void _initControladorListarAceptadosAEdicionPublishProxy() {
    try {
      controladorListarAceptadosAEdicionPublish = (new publicadores.ControladorListarAceptadosAEdicionPublishServiceLocator()).getControladorListarAceptadosAEdicionPublishPort();
      if (controladorListarAceptadosAEdicionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorListarAceptadosAEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorListarAceptadosAEdicionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorListarAceptadosAEdicionPublish != null)
      ((javax.xml.rpc.Stub)controladorListarAceptadosAEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorListarAceptadosAEdicionPublish getControladorListarAceptadosAEdicionPublish() {
    if (controladorListarAceptadosAEdicionPublish == null)
      _initControladorListarAceptadosAEdicionPublishProxy();
    return controladorListarAceptadosAEdicionPublish;
  }
  
  public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos{
    if (controladorListarAceptadosAEdicionPublish == null)
      _initControladorListarAceptadosAEdicionPublishProxy();
    return controladorListarAceptadosAEdicionPublish.listarInstitutos();
  }
  
  public publicadores.DtEdicionBase[] ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionNoExiste, publicadores.CursoNoExiste{
    if (controladorListarAceptadosAEdicionPublish == null)
      _initControladorListarAceptadosAEdicionPublishProxy();
    return controladorListarAceptadosAEdicionPublish.ingresarCurso(arg0);
  }
  
  public publicadores.DtEdicionCompleta ingresarEdicion(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionNoExiste{
    if (controladorListarAceptadosAEdicionPublish == null)
      _initControladorListarAceptadosAEdicionPublishProxy();
    return controladorListarAceptadosAEdicionPublish.ingresarEdicion(arg0);
  }
  
  public publicadores.DtCursoBase[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos{
    if (controladorListarAceptadosAEdicionPublish == null)
      _initControladorListarAceptadosAEdicionPublishProxy();
    return controladorListarAceptadosAEdicionPublish.ingresarInstituto(arg0);
  }
  
  
}
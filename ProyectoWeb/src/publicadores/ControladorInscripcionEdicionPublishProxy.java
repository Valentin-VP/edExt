package publicadores;

public class ControladorInscripcionEdicionPublishProxy implements publicadores.ControladorInscripcionEdicionPublish {
  private String _endpoint = null;
  private publicadores.ControladorInscripcionEdicionPublish controladorInscripcionEdicionPublish = null;
  
  public ControladorInscripcionEdicionPublishProxy() {
    _initControladorInscripcionEdicionPublishProxy();
  }
  
  public ControladorInscripcionEdicionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorInscripcionEdicionPublishProxy();
  }
  
  private void _initControladorInscripcionEdicionPublishProxy() {
    try {
      controladorInscripcionEdicionPublish = (new publicadores.ControladorInscripcionEdicionPublishServiceLocator()).getControladorInscripcionEdicionPublishPort();
      if (controladorInscripcionEdicionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorInscripcionEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorInscripcionEdicionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorInscripcionEdicionPublish != null)
      ((javax.xml.rpc.Stub)controladorInscripcionEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorInscripcionEdicionPublish getControladorInscripcionEdicionPublish() {
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    return controladorInscripcionEdicionPublish;
  }
  
  public void registrarInscripcionEd(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, publicadores.DtFecha arg3) throws java.rmi.RemoteException, publicadores.UsuarioNoExiste, publicadores.UsuarioNoEstudiante{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    controladorInscripcionEdicionPublish.registrarInscripcionEd(arg0, arg1, arg2, arg3);
  }
  
  public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoNoExiste{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    return controladorInscripcionEdicionPublish.seleccionarInstituto(arg0);
  }
  
  public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    return controladorInscripcionEdicionPublish.listarInstitutos();
  }
  
  public void confirmar() throws java.rmi.RemoteException, publicadores.InscripcionEdRepetido, publicadores.EdicionVigenteNoExiste, publicadores.UsuarioNoExiste{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    controladorInscripcionEdicionPublish.confirmar();
  }
  
  public publicadores.DtEdicionBase seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionVigenteNoExiste{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    return controladorInscripcionEdicionPublish.seleccionarCurso(arg0);
  }
  
  public void cancelar() throws java.rmi.RemoteException{
    if (controladorInscripcionEdicionPublish == null)
      _initControladorInscripcionEdicionPublishProxy();
    controladorInscripcionEdicionPublish.cancelar();
  }
  
  
}
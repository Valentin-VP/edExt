package publicadores;

public class ControladorSeleccionarEstudiantesPublishProxy implements publicadores.ControladorSeleccionarEstudiantesPublish {
  private String _endpoint = null;
  private publicadores.ControladorSeleccionarEstudiantesPublish controladorSeleccionarEstudiantesPublish = null;
  
  public ControladorSeleccionarEstudiantesPublishProxy() {
    _initControladorSeleccionarEstudiantesPublishProxy();
  }
  
  public ControladorSeleccionarEstudiantesPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorSeleccionarEstudiantesPublishProxy();
  }
  
  private void _initControladorSeleccionarEstudiantesPublishProxy() {
    try {
      controladorSeleccionarEstudiantesPublish = (new publicadores.ControladorSeleccionarEstudiantesPublishServiceLocator()).getControladorSeleccionarEstudiantesPublishPort();
      if (controladorSeleccionarEstudiantesPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorSeleccionarEstudiantesPublish != null)
      ((javax.xml.rpc.Stub)controladorSeleccionarEstudiantesPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorSeleccionarEstudiantesPublish getControladorSeleccionarEstudiantesPublish() {
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish;
  }
  
  public publicadores.DtCursoBase[] listarCursosInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.listarCursosInstituto(arg0);
  }
  
  public void limpiar() throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    controladorSeleccionarEstudiantesPublish.limpiar();
  }
  
  public publicadores.DtEdicionCompleta seleccionarCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.EdicionVigenteNoExiste{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.seleccionarCurso(arg0, arg1);
  }
  
  public void setEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    controladorSeleccionarEstudiantesPublish.setEdicion(arg0);
  }
  
  public void confirmarSeleccion() throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    controladorSeleccionarEstudiantesPublish.confirmarSeleccion();
  }
  
  public publicadores.DtInscripcionEd[] ordenarInscripciones(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    return controladorSeleccionarEstudiantesPublish.ordenarInscripciones(arg0);
  }
  
  public void cambiarEstadoInscripcion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorSeleccionarEstudiantesPublish == null)
      _initControladorSeleccionarEstudiantesPublishProxy();
    controladorSeleccionarEstudiantesPublish.cambiarEstadoInscripcion(arg0, arg1);
  }
  
  
}
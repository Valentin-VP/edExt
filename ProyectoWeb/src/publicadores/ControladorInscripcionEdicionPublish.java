/**
 * ControladorInscripcionEdicionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorInscripcionEdicionPublish extends java.rmi.Remote {
    public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoNoExiste;
    public void registrarInscripcionEd(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, publicadores.DtFecha arg3) throws java.rmi.RemoteException, publicadores.UsuarioNoExiste, publicadores.UsuarioNoEstudiante;
    public publicadores.DtEdicionBase seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionVigenteNoExiste;
    public void confirmar() throws java.rmi.RemoteException, publicadores.InscripcionEdRepetido, publicadores.EdicionVigenteNoExiste, publicadores.UsuarioNoExiste;
    public void cancelar() throws java.rmi.RemoteException;
    public publicadores.DtInstituto[] listarInstitutos(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.SinInstitutos;
}

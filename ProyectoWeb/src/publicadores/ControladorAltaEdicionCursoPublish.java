/**
 * ControladorAltaEdicionCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaEdicionCursoPublish extends java.rmi.Remote {
    public publicadores.DtUsuarioBase[] getDocentes() throws java.rmi.RemoteException;
    public publicadores.DtUsuarioBase[] getUsuarios() throws java.rmi.RemoteException;
    public void altaEdicionCurso(java.lang.String arg0, java.lang.String arg1, publicadores.DtFecha arg2, publicadores.DtFecha arg3, publicadores.ArrayList arg4, boolean arg5, int arg6, publicadores.DtFecha arg7) throws java.rmi.RemoteException, publicadores.UsuarioNoDocente, publicadores.EdicionRepetida, publicadores.CursoNoExiste, publicadores.InstitutoInexistente;
    public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente;
}

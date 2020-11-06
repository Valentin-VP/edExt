/**
 * ControladorAltaUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaUsuarioPublish extends java.rmi.Remote {
    public java.lang.String codificarPass(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException;
    public void altaUsuario(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, publicadores.DtFecha arg4, java.lang.String arg5) throws java.rmi.RemoteException, publicadores.UsuarioRepetido;
    public void seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public void confirmarAltaUsuario(boolean arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException;
    public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos;
}

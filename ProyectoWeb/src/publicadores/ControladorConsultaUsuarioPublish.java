/**
 * ControladorConsultaUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaUsuarioPublish extends java.rmi.Remote {
    public java.lang.String getMensaje() throws java.rmi.RemoteException;
    public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtUsuario elegirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public publicadores.DtEdicion[] infoEdiciones(boolean arg0) throws java.rmi.RemoteException;
    public publicadores.DtUsuario[] listarDtUsuarios() throws java.rmi.RemoteException;
    public publicadores.DtPrograma[] infoProgramas() throws java.rmi.RemoteException;
}

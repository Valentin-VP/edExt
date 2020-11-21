/**
 * ControladorSesionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorSesionPublish extends java.rmi.Remote {
    public java.lang.String identificarUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean existeUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerCorreo() throws java.rmi.RemoteException;
    public java.lang.String codificarPass(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoSuchAlgorithmException;
    public java.lang.String getMensaje() throws java.rmi.RemoteException;
    public java.lang.String obtenerNick() throws java.rmi.RemoteException;
}

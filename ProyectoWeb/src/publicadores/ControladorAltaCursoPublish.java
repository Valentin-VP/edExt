/**
 * ControladorAltaCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaCursoPublish extends java.rmi.Remote {
    public void confirmarAltaCurso() throws java.rmi.RemoteException;
    public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos;
    public void altaCurso(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, int arg4, int arg5, java.lang.String arg6, publicadores.DtFecha arg7) throws java.rmi.RemoteException, publicadores.CursoRepetido, publicadores.InstitutoInexistente;
    public java.lang.String[] listarCategorias() throws java.rmi.RemoteException, publicadores.SinCategorias;
    public void agregarCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public void agregarPrevia(java.lang.String arg0) throws java.rmi.RemoteException;
    public void cancelarAltaCurso() throws java.rmi.RemoteException;
    public java.lang.String getMensaje() throws java.rmi.RemoteException;
    public void cleanCategorias() throws java.rmi.RemoteException;
}

/**
 * ControladorConsultaEdicionCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaEdicionCursoPublish extends java.rmi.Remote {
    public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getDocentes(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicion getDtEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getNombreCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCursoBase[] seleccionarCategoria(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CategoriaInexistente;
    public publicadores.DtInstituto[] getInstitutosConCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicionBase[] seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CursoNoExiste;
    public publicadores.DtCursoBase[] seleccionarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente;
}
/**
 * ControladorConsultaCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaCursoPublish extends java.rmi.Remote {
    public publicadores.DtCursoBase[] listarCursosInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos;
    public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos;
    public java.lang.String[] listarCategorias() throws java.rmi.RemoteException, publicadores.SinCategorias;
    public publicadores.DtCursoBase[] listarCursosCategoria(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.CategoriaInexistente, publicadores.CategoriaSinCursos;
    public publicadores.DtProgramaBase[] getProgramas() throws java.rmi.RemoteException;
    public publicadores.DtCurso consultarCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCurso[] listarCursosPlataforma() throws java.rmi.RemoteException, publicadores.SinCursos;
    public java.lang.String getMensaje() throws java.rmi.RemoteException;
    public void setMensaje(java.lang.String arg0) throws java.rmi.RemoteException;
}

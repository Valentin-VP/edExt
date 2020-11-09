/**
 * ControladorSeleccionarEstudiantesPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorSeleccionarEstudiantesPublish extends java.rmi.Remote {
    public publicadores.DtCursoBase[] listarCursosInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos;
    public void limpiar() throws java.rmi.RemoteException;
    public publicadores.DtEdicionCompleta seleccionarCurso(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.EdicionVigenteNoExiste;
    public void setEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public void confirmarSeleccion() throws java.rmi.RemoteException;
    public publicadores.DtInscripcionEd[] ordenarInscripciones(java.lang.String arg0) throws java.rmi.RemoteException;
    public void cambiarEstadoInscripcion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}

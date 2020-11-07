/**
 * ControladorListarAceptadosAEdicionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorListarAceptadosAEdicionPublish extends java.rmi.Remote {
    public publicadores.DtInstituto[] listarInstitutos() throws java.rmi.RemoteException, publicadores.SinInstitutos;
    public publicadores.DtEdicionBase[] ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionNoExiste, publicadores.CursoNoExiste;
    public publicadores.DtEdicionCompleta ingresarEdicion(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.EdicionNoExiste;
    public publicadores.DtCursoBase[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.InstitutoInexistente, publicadores.InstitutoSinCursos;
}

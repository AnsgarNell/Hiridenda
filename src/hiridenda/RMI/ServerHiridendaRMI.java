/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hiridenda.RMI;

import hiridenda.OntologyManager;
import java.math.BigInteger;
import java.rmi.RemoteException;

/**
 *
 * @author InAns
 */
public class ServerHiridendaRMI implements InterfaceHiridendaRMI{

    private OntologyManager ontologyManager;

    public ServerHiridendaRMI (OntologyManager ontologyManager) throws RemoteException
    {
        this.ontologyManager = ontologyManager;
    }

     public void addUnidad(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, String strTipoID, String strRecID) throws RemoteException 
     {
        ontologyManager.addUnidad(intID, strNombre, intCantidad, intCantidadActual, strTipoID, strRecID);
    }
     
    public void addLocalizacion(String intID, String strNombre, BigInteger boolEstado) throws RemoteException 
    {
        ontologyManager.addLocalizacion(intID, strNombre, boolEstado);
    }

    public void addTipo(String intID, String strNombre) throws RemoteException 
    {
        ontologyManager.addTipo(intID, strNombre);
    }

    public void addTurno(String intID, String strNombre, BigInteger boolEstado) throws RemoteException 
    {
        ontologyManager.addTurno(intID, strNombre, boolEstado);
    }

    public void addRecepcion(String intID, String strMatricula, String strDNI, BigInteger boolEstado, String strTurID, String strLocID) throws RemoteException 
    {
        ontologyManager.addRecepcion(intID, strMatricula, strDNI, boolEstado, strTurID, strLocID);
    }

    public void addLoteEntrada(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException 
    {
        ontologyManager.addLoteEntrada(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);
    }

    public void addLoteRuptura(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException {
        ontologyManager.addLoteRuptura(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);
    }

    public void addLoteSalida(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException {
        ontologyManager.addLoteSalida(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);
    }

    public void addLoteUni(String domainID, String rangeID) throws RemoteException {
        ontologyManager.addLoteUni(domainID, rangeID);
    }

    public void addLoteMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException {
        ontologyManager.addLoteMag(domainID, rangeID, intMax, intMin, boolTrack);
    }

    public void addLotrMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException {
        ontologyManager.addLotrMag(domainID, rangeID, intMax, intMin, boolTrack);
    }

    public void addLotsMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException {
        ontologyManager.addLotsMag(domainID, rangeID, intMax, intMin, boolTrack);
    }

    public void addLoteEntRupt(String domainID, String rangeID) throws RemoteException {
        ontologyManager.addLoteEntRupt(domainID, rangeID);
    }

    public void addLoteRuptSal(String domainID, String rangeID) throws RemoteException {
        ontologyManager.addLoteRuptSal(domainID, rangeID);
    }

    public void addLoteEntSal(String domainID, String rangeID) throws RemoteException {
        ontologyManager.addLoteEntSal(domainID, rangeID);
    }

    public void addSubClaseMagnitud(String intID) throws RemoteException {
        ontologyManager.addSubClaseMagnitud(intID);
    }
}

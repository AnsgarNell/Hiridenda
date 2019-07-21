/*
 * Interfaz que define todos los métodos disponibles en el servidor RMI
 */

package hiridenda.RMI;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author InAns
 */
public interface InterfaceHiridendaRMI extends Remote
{
    // TODO: Cambiar el nombre del servicio si se desea
    public static final String SERVICE_NAME = "HiriDenda";

    // IMPORTANTE: Todos los métodos DEBEN arrojar RemoteException
    public void addUnidad(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, String strTipoID, String strRecID) throws RemoteException;
    public void addLocalizacion(String intID, String strNombre, BigInteger boolEstado) throws RemoteException;
    public void addTipo(String intID, String strNombre) throws RemoteException;
    public void addTurno(String intID, String strNombre, BigInteger boolEstado) throws RemoteException;
    public void addRecepcion(String intID, String strMatricula, String strDNI, BigInteger boolEstado, String strTurID, String strLocID) throws RemoteException;
    public void addLoteEntrada(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException;
    public void addLoteRuptura(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException;
    public void addLoteSalida(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException;
    public void addLoteUni(String domainID, String rangeID) throws RemoteException;
    public void addLoteMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException;
    public void addLotrMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException;
    public void addLotsMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) throws RemoteException;
    public void addLoteEntRupt(String domainID, String rangeID) throws RemoteException;
    public void addLoteRuptSal(String domainID, String rangeID) throws RemoteException;
    public void addLoteEntSal(String domainID, String rangeID) throws RemoteException;
    public void addSubClaseMagnitud(String intID) throws RemoteException;
}

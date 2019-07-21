/*
 * Clase cliente que se ejecutará en Oracle a través de triggers cada vez que
 * se realicen cambios en la base de datos
 */

package hiridenda.RMI;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author InAns
 */
public class ClienteOracle{

    // Función privada que se encarga de conectar con el servidor RMI antes
    // de ejecutar las funciones de actualización
    private static InterfaceHiridendaRMI localizarServidor()
    {
         try
         {

            Registry registry = LocateRegistry.getRegistry();

            // TODO: En caso de ser necesario, comprobar si se puede conectar a otro equipo
            InterfaceHiridendaRMI compute = (InterfaceHiridendaRMI)registry.lookup(InterfaceHiridendaRMI.SERVICE_NAME);
            return compute;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // IMPORTANTE: los métodos DEBEN ser static para poder ser llamados desde
    // Oracle   
    public static void addUnidad(String intID, String strNombre, Integer intCantidad, Integer intCantidadActual, String strTipoID, String strRecID) throws RemoteException{
        BigInteger BICantidad = BigInteger.valueOf(intCantidad);
        BigInteger BICantidadActual = BigInteger.valueOf(intCantidadActual);
        localizarServidor().addUnidad(intID, strNombre, BICantidad, BICantidadActual, strTipoID, strRecID);
    }
    public static void addLocalizacion(String intID, String strNombre, Integer boolEstado) throws RemoteException{
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        localizarServidor().addLocalizacion(intID, strNombre, BIEstado);
    }
    public static void addTipo(String intID, String strNombre) throws RemoteException{
        localizarServidor().addTipo(intID, strNombre);
    }
    public static void addTurno(String intID, String strNombre, Integer boolEstado) throws RemoteException{
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        localizarServidor().addTurno(intID, strNombre, BIEstado);
    }
    public static void addRecepcion(String intID, String strMatricula, String strDNI, Integer boolEstado, String strTurID, String strLocID) throws RemoteException {
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        localizarServidor().addRecepcion(intID, strMatricula, strDNI, BIEstado, strTurID, strLocID);
    }
    public static void addLoteEntrada(String intID, String strNombre, Integer intCantidad, Integer intCantidadActual, Integer boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException{
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        BigInteger BICantidad = BigInteger.valueOf(intCantidad);
        BigInteger BICantidadActual = BigInteger.valueOf(intCantidadActual);
        localizarServidor().addLoteEntrada(intID, strNombre, BICantidad, BICantidadActual, BIEstado, strDate, strTurID, strLocID);
    }
    public static void addLoteRuptura(String intID, String strNombre, Integer intCantidad, Integer intCantidadActual, Integer boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException{
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        BigInteger BICantidad = BigInteger.valueOf(intCantidad);
        BigInteger BICantidadActual = BigInteger.valueOf(intCantidadActual);
        localizarServidor().addLoteRuptura(intID, strNombre, BICantidad, BICantidadActual, BIEstado, strDate, strTurID, strLocID);
    }
    public static void addLoteSalida(String intID, String strNombre, Integer intCantidad, Integer intCantidadActual, Integer boolEstado, String strDate, String strTurID, String strLocID) throws RemoteException{
        BigInteger BIEstado = BigInteger.valueOf(boolEstado);
        BigInteger BICantidad = BigInteger.valueOf(intCantidad);
        BigInteger BICantidadActual = BigInteger.valueOf(intCantidadActual);
        localizarServidor().addLoteSalida(intID, strNombre, BICantidad, BICantidadActual, BIEstado, strDate, strTurID, strLocID);
    }
    public static void addLoteUni(String domainID, String rangeID) throws RemoteException{
        localizarServidor().addLoteUni(domainID, rangeID);
    }
    public static void addLoteMag(String domainID, String rangeID, Integer intMax, Integer intMin, Integer boolTrack) throws RemoteException{
        BigInteger BIMax = BigInteger.valueOf(intMax);
        BigInteger BIMin = BigInteger.valueOf(intMin);
        BigInteger BITrack = BigInteger.valueOf(boolTrack);
        localizarServidor().addLoteMag(domainID, rangeID, BIMax, BIMin, BITrack);
    }
    public static void addLotrMag(String domainID, String rangeID, Integer intMax, Integer intMin, Integer boolTrack) throws RemoteException{
        BigInteger BIMax = BigInteger.valueOf(intMax);
        BigInteger BIMin = BigInteger.valueOf(intMin);
        BigInteger BITrack = BigInteger.valueOf(boolTrack);
        localizarServidor().addLotrMag(domainID, rangeID, BIMax, BIMin, BITrack);
    }
    public static void addLotsMag(String domainID, String rangeID, Integer intMax, Integer intMin, Integer boolTrack) throws RemoteException{
        BigInteger BIMax = BigInteger.valueOf(intMax);
        BigInteger BIMin = BigInteger.valueOf(intMin);
        BigInteger BITrack = BigInteger.valueOf(boolTrack);
        localizarServidor().addLotsMag(domainID, rangeID, BIMax, BIMin, BITrack);
    }
    public static void addLoteEntRupt(String domainID, String rangeID) throws RemoteException{
        localizarServidor().addLoteEntRupt(domainID, rangeID);
    }
    public static void addLoteRuptSal(String domainID, String rangeID) throws RemoteException{
        localizarServidor().addLoteRuptSal(domainID, rangeID);
    }
    public static void addLoteEntSal(String domainID, String rangeID) throws RemoteException{
        localizarServidor().addLoteEntSal(domainID, rangeID);
    }
    public static void addSubClaseMagnitud(String intID) throws RemoteException{
        localizarServidor().addSubClaseMagnitud(intID);
    }
}


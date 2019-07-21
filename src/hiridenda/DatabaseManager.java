/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiridenda;

import database.TLocalizacion;
import database.TLoteEnt;
import database.TLoteEntRupt;
import database.TLoteEntSal;
import database.TLoteMag;
import database.TLoteRupt;
import database.TLoteRuptSal;
import database.TLoteSal;
import database.TLoteUni;
import database.TLotrMag;
import database.TLotsMag;
import database.TMagnitud;
import database.TRecepcion;
import database.TTipo;
import database.TTurno;
import database.TUnidad;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author InAns
 */
public class DatabaseManager {
    
    // Utilidades que facilitan la conexión a la base de datos relacional
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private InformationPanel informationPanel;  // TextBox donde escribir mensajes
    private OntologyManager ontologyManager;
    
    public DatabaseManager(InformationPanel informationPanel, OntologyManager ontologyManager)
    {
        this.informationPanel = informationPanel;
        this.ontologyManager = ontologyManager;
    }
    
    @Override
    protected void finalize()
    {
        try
        {
            em.close();
            emf.close();
            super.finalize();
        }
        catch (Throwable ex)
        {
            Logger.getLogger(OntologyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Función para poblar la ontología a partir de los datos de una
    // base de datos relacional
    public void populateOntology()
    {
        Collection data;
        Iterator iterator;

        // Nos conectamos a la base de datos
        em = getEntityManager();

        //////////////////////////////
        // DATOS ESTÁTICOS
        //////////////////////////////
        
        // Obtenemos todos los datos de la tabla T_LOCALIZACION
        data = em.createNamedQuery("TLocalizacion.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos de la localización
            TLocalizacion localizacion = (TLocalizacion) iterator.next();
            String intID = localizacion.getLocId().toString();
            String strNombre = localizacion.getLocNombre();
            BigInteger boolEstado = localizacion.getLocEstado();

            ontologyManager.addLocalizacion(intID, strNombre, boolEstado);         
        }
        
        // Obtenemos todos los datos de la tabla T_MAGNITUD
        data = em.createNamedQuery("TMagnitud.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos de la magnitud
            TMagnitud magnitud = (TMagnitud) iterator.next();
            String intID = magnitud.getMagId().toString();

            ontologyManager.addSubClaseMagnitud(intID);          
        }
        
        // Obtenemos todos los datos de la tabla T_TIPO
        data = em.createNamedQuery("TTipo.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del tipo
            TTipo tipo = (TTipo) iterator.next();
            String intID = tipo.getTipId().toString();
            String strNombre = tipo.getTipNombre();

            ontologyManager.addTipo(intID, strNombre);           
        }
        
        // Obtenemos todos los datos de la tabla T_TURNO
        data = em.createNamedQuery("TTurno.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del turno
            TTurno turno = (TTurno) iterator.next();
            String intID = turno.getTurId().toString();
            String strNombre = turno.getTurNombre();
            BigInteger boolEstado = turno.getTurEstado();

            ontologyManager.addTurno(intID, strNombre, boolEstado);            
        }
        
        //////////////////////////////
        // DATOS DINÁMICOS
        //////////////////////////////
        
        // Obtenemos todos los datos de la tabla T_RECEPCION
        data = em.createNamedQuery("TRecepcion.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos de la recepción
            TRecepcion recepcion = (TRecepcion) iterator.next();
            String intID = recepcion.getRecId().toString();
            String strMatricula = recepcion.getRecMatricula();
            String strDNI = recepcion.getRecDniTransp();
            BigInteger boolEstado = recepcion.getRecEstado();
            String strTurID = recepcion.getRecTurId().getTurId().toString();
            String strLocID = recepcion.getRecLocId().getLocId().toString();

            ontologyManager.addRecepcion(intID, strMatricula, strDNI, boolEstado, strTurID, strLocID);      
        }
        
        // Obtenemos todos los datos de la tabla T_UNIDAD
        data = em.createNamedQuery("TUnidad.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos de la unidad
            TUnidad unidad = (TUnidad) iterator.next();
            String intID = unidad.getUniId().toString();
            String strNombre = unidad.getUniDescrip();
            BigInteger intCantidad = unidad.getUniCant();
            BigInteger intCantidadActual = unidad.getUniCantAct();
            String strTipoID = unidad.getUniTipoId().getTipId().toString();
            String strRecepcionID = unidad.getUniRecId().getRecId().toString();

            ontologyManager.addUnidad(intID, strNombre, intCantidad, intCantidadActual, strTipoID, strRecepcionID);
            
        }
        
        // Obtenemos todos los datos de la tabla T_LOTE_ENT
        data = em.createNamedQuery("TLoteEnt.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de entrada
            TLoteEnt lote_entrada = (TLoteEnt) iterator.next();
            String intID = lote_entrada.getLoteId().toString();
            String strNombre = lote_entrada.getLoteDescrip();
            BigInteger intCantidad = lote_entrada.getLoteCant();
            BigInteger intCantidadActual = lote_entrada.getLoteCantAct();
            BigInteger boolEstado = lote_entrada.getLoteEstado();
            String strDate = lote_entrada.getLoteDate().toString();
            String strTurID = lote_entrada.getLoteTurId().getTurId().toString();
            String strLocID = lote_entrada.getLoteLocId().getLocId().toString();

            ontologyManager.addLoteEntrada(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);            
        }
        
         // Obtenemos todos los datos de la tabla T_LOTE_RUPT
        data = em.createNamedQuery("TLoteRupt.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de ruptura
            TLoteRupt lote_ruptura = (TLoteRupt) iterator.next();
            String intID = lote_ruptura.getLotrId().toString();
            String strNombre = lote_ruptura.getLotrDescrip();
            BigInteger intCantidad = lote_ruptura.getLotrCant();
            BigInteger intCantidadActual = lote_ruptura.getLotrCantAct();
            BigInteger boolEstado = lote_ruptura.getLotrEstado();
            String strDate = lote_ruptura.getLotrDate().toString();
            String strTurID = lote_ruptura.getLotrTurId().getTurId().toString();
            String strLocID = lote_ruptura.getLotrLocId().getLocId().toString();

            ontologyManager.addLoteRuptura(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);                 
        }
        
         // Obtenemos todos los datos de la tabla T_LOTE_SAL
        data = em.createNamedQuery("TLoteSal.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de salida
            TLoteSal lote_salida = (TLoteSal) iterator.next();
            String intID = lote_salida.getLotsId().toString();
            String strNombre = lote_salida.getLotsDescrip();
            BigInteger intCantidad = lote_salida.getLotsCant();
            BigInteger intCantidadActual = lote_salida.getLotsCantAct();
            BigInteger boolEstado = lote_salida.getLotsEstado();
            String strDate = lote_salida.getLotsDate().toString();
            String strTurID = lote_salida.getLotsTurId().getTurId().toString();
            String strLocID = lote_salida.getLotsLocId().getLocId().toString();
            
            ontologyManager.addLoteSalida(intID, strNombre, intCantidad, intCantidadActual, boolEstado, strDate, strTurID, strLocID);                    
        }
        
        //////////////////////////////
        // TABLAS RELACIONALES
        //////////////////////////////
        
        // Obtenemos todos los datos de la tabla T_LOTE_UNI
        data = em.createNamedQuery("TLoteUni.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote y de la unidad
            TLoteUni loteUni = (TLoteUni) iterator.next();
            String domainID = loteUni.getTLoteEnt().getLoteId().toString();
            String rangeID = loteUni.getTUnidad().getUniId().toString();

            ontologyManager.addLoteUni(domainID, rangeID);          
        }
        
        // Obtenemos todos los datos de la tabla T_LOTE_MAG
        data = em.createNamedQuery("TLoteMag.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote y magnitud
            TLoteMag loteMag = (TLoteMag) iterator.next();
            String domainID = loteMag.getTLoteEnt().getLoteId().toString();
            String rangeID = loteMag.getTMagnitud().getMagId().toString();
            BigInteger intMax = loteMag.getLotmagMax();
            BigInteger intMin = loteMag.getLotmagMin();
            BigInteger boolTrack = loteMag.getLotmagTrack();
      
            ontologyManager.addLoteMag(domainID, rangeID, intMax, intMin, boolTrack);     
        }
        
        // Obtenemos todos los datos de la tabla T_LOTR_MAG
        data = em.createNamedQuery("TLotrMag.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote y magnitud
            TLotrMag lotrMag = (TLotrMag) iterator.next();
            String domainID = lotrMag.getTLoteRupt().getLotrId().toString();
            String rangeID = lotrMag.getTMagnitud().getMagId().toString();
            BigInteger intMax = lotrMag.getLotmagMax();
            BigInteger intMin = lotrMag.getLotmagMin();
            BigInteger boolTrack = lotrMag.getLotmagTrack();
      
            ontologyManager.addLotrMag(domainID, rangeID, intMax, intMin, boolTrack);       
        }
        
        // Obtenemos todos los datos de la tabla T_LOTS_MAG
        data = em.createNamedQuery("TLotsMag.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote y magnitud
            TLotsMag lotsMag = (TLotsMag) iterator.next();
            String domainID = lotsMag.getTLoteSal().getLotsId().toString();
            String rangeID = lotsMag.getTMagnitud().getMagId().toString();
            BigInteger intMax = lotsMag.getLotmagMax();
            BigInteger intMin = lotsMag.getLotmagMin();
            BigInteger boolTrack = lotsMag.getLotmagTrack();
      
            ontologyManager.addLotsMag(domainID, rangeID, intMax, intMin, boolTrack);       
        }
        
        // Obtenemos todos los datos de la tabla T_LOTE_ENT_RUPT
        data = em.createNamedQuery("TLoteEntRupt.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de entrada y salida
            TLoteEntRupt loteEnt_Rupt = (TLoteEntRupt) iterator.next();
            String domainID = loteEnt_Rupt.getTLoteRupt().getLotrId().toString();
            String rangeID = loteEnt_Rupt.getTLoteEnt().getLoteId().toString();

            ontologyManager.addLoteEntRupt(domainID, rangeID);      
        }
        
        // Obtenemos todos los datos de la tabla T_LOTE_RUPT_SAL
        data = em.createNamedQuery("TLoteRuptSal.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de ruptura y salida
            TLoteRuptSal loteRupt_Sal = (TLoteRuptSal) iterator.next();
            String domainID = loteRupt_Sal.getTLoteSal().getLotsId().toString();
            String rangeID = loteRupt_Sal.getTLoteRupt().getLotrId().toString();

            ontologyManager.addLoteRuptSal(domainID, rangeID);            
        }
        
        // Obtenemos todos los datos de la tabla T_LOTE_ENT_SAL
        data = em.createNamedQuery("TLoteEntSal.findAll").getResultList();
        iterator = data.iterator();
        while(iterator.hasNext())
        {
            // Obtenemos los datos del lote de ruptura y salida
            TLoteEntSal loteEnt_Sal = (TLoteEntSal) iterator.next();
            String domainID = loteEnt_Sal.getTLoteSal().getLotsId().toString();
            String rangeID = loteEnt_Sal.getTLoteEnt().getLoteId().toString();

            ontologyManager.addLoteEntSal(domainID, rangeID);            
        }

        // Indicamos el final del proceso
        informationPanel.writeControl("Ontología poblada");
    }
    
     // función para conectarse a la base de datos
    private EntityManager getEntityManager()
    {
       if (emf == null)
       {
           emf = Persistence.createEntityManagerFactory("HiridendaPU");
       }
       return emf.createEntityManager();
    }
}

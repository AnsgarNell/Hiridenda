/*
 * Clase que actúa como gestor de la ontología
 */

package hiridenda;

import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.IDBConnection;
import com.hp.hpl.jena.db.ModelRDB;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author InAns
 */
public class OntologyManager extends Thread
{

    // TODO: Adaptar prefijo y nombre del modelo si se desea
    private final String strPrefix = "http://www.hiridenda.com/ontologies/Hiridenda.owl#";
    private final String strModel = "Hiridenda";

    private ModelRDB modelRDB;  // Variable del modelo persistente
    private OntModel ontModel;  // Máscara del modelo persistente

    // Conector a la base de datos de la ONTOLOGÍA.
    // Se ha declarado global ya que debe cerrarse al finalizar la sesión
    private IDBConnection conn;

    private InformationPanel informationPanel;  // TextBox donde escribir mensajes


    public OntologyManager(InformationPanel informationPanel)
    {
        this.informationPanel = informationPanel;
        try
        {
            // TODO: Modificar la conexión a la base de datos que contenga la ontología
            // TODO: ¿Definir datos en fichero para poder cambiar de BBDD sin recompilar?
            String className = "oracle.jdbc.driver.OracleDriver"; // path of driver class
            Class.forName(className); // Load the Driver
            String DB_URL = "jdbc:oracle:thin:@//localhost:1521/jena"; // URL of database
            String DB_USER = "jena"; // database user id
            String DB_PASSWD = "jena"; // database password
            String DB = "Oracle"; // database type

            // Crear la conexión a la base de datos
            conn = new DBConnection(DB_URL, DB_USER, DB_PASSWD, DB);

            // Si no existe la ontología, la creamos, y si no la recuperamos
            if(!conn.containsModel(strModel))
            {
                modelRDB = ModelRDB.createModel(conn, strModel);
            }
            else
            {
                modelRDB = ModelRDB.open(conn, strModel);
            }
            // Crear máscara sobre el modelo persistente
            ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, modelRDB); 
            printModel();
        }
        catch (ClassNotFoundException ex)
        {
            this.informationPanel.writeError(ex.getMessage());
        }
    }
    
    public void run()
    {
        
    }

    @Override
    protected void finalize()
    {
        try
        {
            // Cerramos todas las conexiones abiertas
            if(!(conn == null))
            {
                conn.close();
            }
            super.finalize();
        }
        catch (Throwable ex)
        {
            Logger.getLogger(OntologyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Función para leer una ontología de un archivo
    public void readModel(String strPath)
    {
        resetModel();
        strPath = strPath.replace("\\", "//");
        modelRDB.read("file:" + strPath,"RDF/XML");
        printModel();
        informationPanel.writeControl("Ontología cargada");
    }

    public void resetModel()
    {
        if(modelRDB != null)
            modelRDB.removeAll();
    }

    // Función para listar todos los componentes de la ontología
    public void printModel()
    {    
        informationPanel.eraseTree();
        for (Iterator<OntClass> i = ontModel.listClasses();i.hasNext();)
        {
            OntClass cls = i.next();
            informationPanel.writeClass(cls.getLocalName());
            for(Iterator it = cls.listInstances(true);it.hasNext();)
            {
                    Individual ind = (Individual)it.next();
                    if(ind.isIndividual())
                    {
                        informationPanel.writeIndividual(cls.getLocalName(), ind.getLocalName());
                        for(Iterator<OntProperty> iterator = cls.listDeclaredProperties();iterator.hasNext();)
                        {
                            OntProperty property = iterator.next();
                            if(ind.hasProperty(property))
                            {
                                String strValue = ind.getPropertyValue(property).toString();
                                if(strValue.indexOf("^^") > 0)
                                    strValue = strValue.substring(0, strValue.indexOf("^^"));
                                else if(strValue.indexOf("#") > 0)
                                    strValue = strValue.substring(strValue.indexOf("#"));
                                informationPanel.writeProperty(property.getLocalName() + " " + strValue);
                            }
                        }
                        
                    }
            }
        }
    }
    
    private void addProperties(OntClass clase, Individual individual)
    {
        //informationPanel.writeClass(clase.getLocalName());
        informationPanel.writeIndividual(clase.getLocalName(), individual.getLocalName());
        for(Iterator<OntProperty> iterator = clase.listDeclaredProperties();iterator.hasNext();)
        {
            OntProperty property = iterator.next();
            if(individual.hasProperty(property))
            {
                String strValue = individual.getPropertyValue(property).toString();
                if(strValue.indexOf("^^") > 0)
                    strValue = strValue.substring(0, strValue.indexOf("^^"));
                else if(strValue.indexOf("#") > 0)
                    strValue = strValue.substring(strValue.indexOf("#"));
                informationPanel.writeProperty(property.getLocalName() + " " + strValue);
            }
        }
        informationPanel.writeControl("Añadido " + individual.getLocalName());
    }

    public void addUnidad(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, String strTipoID, String strRecepcionID) 
    {
        // Obtenemos la clase "unidad" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "unidad");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "unidad_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "UNI_DESCRIP");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty cantidad = ontModel.getDatatypeProperty(strPrefix + "UNI_CANT");
        individual.setPropertyValue(cantidad, ontModel.createTypedLiteral(intCantidad));
        DatatypeProperty cantidadActual = ontModel.getDatatypeProperty(strPrefix + "UNI_CANT_ACT");
        individual.setPropertyValue(cantidadActual, ontModel.createTypedLiteral(intCantidadActual));

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "UNI_TIPO");

        // Obtenemos la clase "tipo" de la ontología
        Individual individualProperty = ontModel.getIndividual(strPrefix + "tipo_" + strTipoID);
        individual.setPropertyValue(objectProperty, individualProperty);

        objectProperty = ontModel.getObjectProperty(strPrefix + "UNI_REC");

        // Obtenemos la clase "recepcion" de la ontología
        individualProperty = ontModel.getIndividual(strPrefix + "recepcion_" + strRecepcionID);
        individual.setPropertyValue(objectProperty, individualProperty);
        addProperties(clase, individual);
    }

    public void addLocalizacion(String intID, String strNombre, BigInteger boolEstado) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "localizacion" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "localizacion");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "localizacion_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "LOC_NOMBRE");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "LOC_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));
        addProperties(clase, individual);
        informationPanel.writeControl("Añadido " + individual.getLocalName());
    }

    public void addTipo(String intID, String strNombre) 
    {
        // Obtenemos la clase "tipo" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "tipo");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "tipo_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "TIP_NOMBRE");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        addProperties(clase, individual);
    }

    public void addTurno(String intID, String strNombre, BigInteger boolEstado) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "turno" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "turno");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "turno_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "TUR_NOMBRE");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "TUR_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));
        addProperties(clase, individual);
    }

    public void addRecepcion(String intID, String strMatricula, String strDNI, BigInteger boolEstado, String strTurID, String strLocID) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "recepcion" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "recepcion");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strMatricula = strMatricula.replace(' ', '_');
        strDNI = strDNI.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "recepcion_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "REC_MATRICULA");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strMatricula));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "REC_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "REC_TUR");        
        // Obtenemos la clase "turno" de la ontología
        Individual individualProperty = ontModel.getIndividual(strPrefix + "turno_" + strTurID);
        individual.setPropertyValue(objectProperty, individualProperty);

        objectProperty = ontModel.getObjectProperty(strPrefix + "REC_LOC");

        // Obtenemos la clase "localizacion" de la ontología
        individualProperty = ontModel.getIndividual(strPrefix + "localizacion_" + strLocID);
        individual.setPropertyValue(objectProperty, individualProperty);
        addProperties(clase, individual);
    }

    public void addLoteEntrada(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "lote_entrada" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "lote_entrada");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "lote_entrada_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "LOTE_DESCRIP");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty cantidad = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT");
        individual.setPropertyValue(cantidad, ontModel.createTypedLiteral(intCantidad));
        DatatypeProperty cantidadActual = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT_ACT");
        individual.setPropertyValue(cantidadActual, ontModel.createTypedLiteral(intCantidadActual));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "LOTE_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));
        DatatypeProperty dateProperty = ontModel.getDatatypeProperty(strPrefix + "LOTE_DATE");
        individual.setPropertyValue(dateProperty, ontModel.createTypedLiteral(strDate));

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_TUR");

        // Obtenemos la clase "turno" de la ontología
        Individual individualProperty = ontModel.getIndividual(strPrefix + "turno_" + strTurID);
        individual.setPropertyValue(objectProperty, individualProperty);  

        objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_LOC");

        // Obtenemos la clase "localizacion" de la ontología
        individualProperty = ontModel.getIndividual(strPrefix + "localizacion_" + strLocID);
        individual.setPropertyValue(objectProperty, individualProperty);
        addProperties(clase, individual);
    }

    public void addLoteRuptura(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "lote_ruptura" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "lote_ruptura");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "lote_ruptura_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "LOTE_DESCRIP");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty cantidad = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT");
        individual.setPropertyValue(cantidad, ontModel.createTypedLiteral(intCantidad));
        DatatypeProperty cantidadActual = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT_ACT");
        individual.setPropertyValue(cantidadActual, ontModel.createTypedLiteral(intCantidadActual));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "LOTE_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));
        DatatypeProperty dateProperty = ontModel.getDatatypeProperty(strPrefix + "LOTE_DATE");
        individual.setPropertyValue(dateProperty, ontModel.createTypedLiteral(strDate));

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_TUR");

        // Obtenemos la clase "turno" de la ontología
        Individual individualProperty = ontModel.getIndividual(strPrefix + "turno_" + strTurID);
        individual.setPropertyValue(objectProperty, individualProperty);   

        objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_LOC");

        // Obtenemos la clase "localizacion" de la ontología
        individualProperty = ontModel.getIndividual(strPrefix + "localizacion_" + strLocID);
        individual.setPropertyValue(objectProperty, individualProperty);
        addProperties(clase, individual);
    }

    public void addLoteSalida(String intID, String strNombre, BigInteger intCantidad, BigInteger intCantidadActual, BigInteger boolEstado, String strDate, String strTurID, String strLocID) 
    {
        boolean estadoActivo = boolEstado.equals(BigInteger.ONE);
        // Obtenemos la clase "lote_salida" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "lote_salida");

        // Hay que sustituir los espacios en blanco ya que el nombre
        // es en realidad un URI
        strNombre = strNombre.replace(' ', '_');

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "lote_salida_" + intID);

        // Establecemos las Data Properties
        DatatypeProperty ID = ontModel.getDatatypeProperty(strPrefix + "LOTE_DESCRIP");
        individual.setPropertyValue(ID, ontModel.createTypedLiteral(strNombre));
        DatatypeProperty cantidad = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT");
        individual.setPropertyValue(cantidad, ontModel.createTypedLiteral(intCantidad));
        DatatypeProperty cantidadActual = ontModel.getDatatypeProperty(strPrefix + "LOTE_CANT_ACT");
        individual.setPropertyValue(cantidadActual, ontModel.createTypedLiteral(intCantidadActual));
        DatatypeProperty estado = ontModel.getDatatypeProperty(strPrefix + "LOTE_ESTADO");
        individual.setPropertyValue(estado, ontModel.createTypedLiteral(estadoActivo));
        DatatypeProperty dateProperty = ontModel.getDatatypeProperty(strPrefix + "LOTE_DATE");
        individual.setPropertyValue(dateProperty, ontModel.createTypedLiteral(strDate));

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_TUR");

        // Obtenemos la clase "turno" de la ontología
        Individual individualProperty = ontModel.getIndividual(strPrefix + "turno_" + strTurID);
        individual.setPropertyValue(objectProperty, individualProperty);   

        objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_LOC");

        // Obtenemos la clase "localizacion" de la ontología
        individualProperty = ontModel.getIndividual(strPrefix + "localizacion_" + strLocID);
        individual.setPropertyValue(objectProperty, individualProperty);
        addProperties(clase, individual);
    }

    public void addLoteUni(String domainID, String rangeID) 
    {
        // Obtenemos el lote
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_entrada_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_UNI");

        // Obtenemos la clase "turno" de la ontología
        Individual rangeIndividual = ontModel.getIndividual(strPrefix + "unidad_" + rangeID);
        domainIndividual.setPropertyValue(objectProperty, rangeIndividual);  

        // Establecemos la object property inversa
        objectProperty = ontModel.getObjectProperty(strPrefix + "UNI_LOTE");
        rangeIndividual.setPropertyValue(objectProperty, domainIndividual);
    }

    public void addLoteMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) 
    {
        // Obtenemos la subclase de magnitud
        OntClass clase = ontModel.getOntClass(strPrefix + "magnitud_" + rangeID);

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "magnitud_" + rangeID + "_lote_" + domainID);

        // Establecemos las Data Properties
        DatatypeProperty max = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MAX");
        individual.setPropertyValue(max, ontModel.createTypedLiteral(intMax));
        DatatypeProperty min = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MIN");
        individual.setPropertyValue(min, ontModel.createTypedLiteral(intMin));
        DatatypeProperty track = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_TRACK");
        individual.setPropertyValue(track, ontModel.createTypedLiteral(boolTrack));


        // Obtenemos el lote
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_entrada_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_MAG");
        domainIndividual.setPropertyValue(objectProperty, individual); 
        addProperties(clase, individual);
    }

    public void addLotrMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) 
    {
        // Obtenemos la subclase de magnitud
        OntClass clase = ontModel.getOntClass(strPrefix + "magnitud_" + rangeID);

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "magnitud_" + rangeID + "_lote_" + domainID);

        // Establecemos las Data Properties
        DatatypeProperty max = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MAX");
        individual.setPropertyValue(max, ontModel.createTypedLiteral(intMax));
        DatatypeProperty min = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MIN");
        individual.setPropertyValue(min, ontModel.createTypedLiteral(intMin));
        DatatypeProperty track = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_TRACK");
        individual.setPropertyValue(track, ontModel.createTypedLiteral(boolTrack));


        // Obtenemos el lote
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_ruptura_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_MAG");
        domainIndividual.setPropertyValue(objectProperty, individual);
        addProperties(clase, individual);
    }

    public void addLotsMag(String domainID, String rangeID, BigInteger intMax, BigInteger intMin, BigInteger boolTrack) 
    {
        // Obtenemos la subclase de magnitud
        OntClass clase = ontModel.getOntClass(strPrefix + "magnitud_" + rangeID);

        // Añadimos la unidad a la ontología
        Individual individual = clase.createIndividual(strPrefix + "magnitud_" + rangeID + "_lote_" + domainID);

        // Establecemos las Data Properties
        DatatypeProperty max = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MAX");
        individual.setPropertyValue(max, ontModel.createTypedLiteral(intMax));
        DatatypeProperty min = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_MIN");
        individual.setPropertyValue(min, ontModel.createTypedLiteral(intMin));
        DatatypeProperty track = ontModel.getDatatypeProperty(strPrefix + "LOTMAG_TRACK");
        individual.setPropertyValue(track, ontModel.createTypedLiteral(boolTrack));


        // Obtenemos el lote
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_salida_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTE_MAG");
        domainIndividual.setPropertyValue(objectProperty, individual);
        addProperties(clase, individual);
    }

    public void addLoteEntRupt(String domainID, String rangeID) 
    {
        // Obtenemos el lote de ruptura
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_ruptura_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTR_LOTE");

        // Obtenemos el lote de entrada
        Individual rangeIndividual = ontModel.getIndividual(strPrefix + "lote_entrada_" + rangeID);
        domainIndividual.setPropertyValue(objectProperty, rangeIndividual);  
    }

    public void addLoteRuptSal(String domainID, String rangeID) 
    {
        // Obtenemos el lote de salida
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_salida_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTS_LOTR");

        // Obtenemos el lote de ruptura
        Individual rangeIndividual = ontModel.getIndividual(strPrefix + "lote_ruptura_" + rangeID);
        domainIndividual.setPropertyValue(objectProperty, rangeIndividual);
    }

    public void addLoteEntSal(String domainID, String rangeID) 
    {
        // Obtenemos el lote de salida
        Individual domainIndividual = ontModel.getIndividual(strPrefix + "lote_salida_" + domainID);

        // Establecemos las Object Properties
        ObjectProperty objectProperty = ontModel.getObjectProperty(strPrefix + "LOTS_LOTE");

        // Obtenemos el lote de entrada
        Individual rangeIndividual = ontModel.getIndividual(strPrefix + "lote_entrada_" + rangeID);
        domainIndividual.setPropertyValue(objectProperty, rangeIndividual);  
    }

    public void addSubClaseMagnitud(String intID) 
    {
        // Obtenemos la clase "magnitud" de la ontología
        OntClass clase = ontModel.getOntClass(strPrefix + "magnitud");

        // Obtenemos una nueva subclase de la ontología
        OntClass subClase = ontModel.createClass(strPrefix + "magnitud_" + intID);

        // Añadimos la subclase a la clase "magnitud"
        clase.addSubClass(subClase);
    }
}

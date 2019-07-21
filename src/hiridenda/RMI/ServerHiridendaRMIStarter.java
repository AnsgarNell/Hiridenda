/*
 * Clase para arrancar el servidor RMI
 */

package hiridenda.RMI;

import hiridenda.InformationPanel;
import hiridenda.OntologyManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author InAns
 */
public final class ServerHiridendaRMIStarter extends RMIStarter {


    private OntologyManager ontologyManager;
    private InformationPanel informationPanel;  // TextBox donde escribir mensajes

    public ServerHiridendaRMIStarter(OntologyManager ontologyManager, InformationPanel informationPanel) {
        super();
        this.ontologyManager = ontologyManager;
        this.informationPanel = informationPanel;
        addClassToRMI(InterfaceHiridendaRMI.class);
        doCustomRmiHandling();
    }

    @Override
    public void doCustomRmiHandling() {
        try {
            // Arrancamos nuestro servidor RMI
            InterfaceHiridendaRMI engine = new ServerHiridendaRMI(ontologyManager);
            InterfaceHiridendaRMI engineStub = (InterfaceHiridendaRMI)UnicastRemoteObject.exportObject(engine, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(InterfaceHiridendaRMI.SERVICE_NAME, engineStub);
            informationPanel.writeControl("Servidor arrancado");
        }
        catch(Exception e) {
            e.printStackTrace();
            informationPanel.writeError(e.getMessage());
        }

    }
}


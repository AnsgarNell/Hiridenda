/*
 * Clase abstracta que define el comportamiento para arrancar un servidor
 * o cliente RMI (carga las clases necesarias)
 */

package hiridenda.RMI;

/**
 *
 * @author InAns
 */
public abstract class RMIStarter {

    public RMIStarter()
    {
        System.setProperty("java.security.policy", PolicyFileLocator.getLocationOfPolicyFile());

        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    }

    // Todas las clases propias que se vayan a usar en RMI deben ser añadidas
    // mediante este procedimiento
    protected void addClassToRMI(Class classToAdd)
    {
        System.setProperty("java.rmi.server.codebase", classToAdd.getProtectionDomain().getCodeSource().getLocation().toString());
    }

    /**
     * extend this class and do RMI handling here
     */
    public abstract void doCustomRmiHandling();

}


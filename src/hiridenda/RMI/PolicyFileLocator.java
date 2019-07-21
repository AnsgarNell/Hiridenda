/*
 * Esta clase se encarga de incluir en cada ejecución un archiov .policy
 * que configura las opciones de seguridad del servidor RMI
 */

package hiridenda.RMI;

/**
 *
 * @author InAns
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class PolicyFileLocator {

    // TODO: Acordarse de incluir siempre el archivo .policy en la raíz de las fuentes (carpeta src)
    public static final String POLICY_FILE_NAME = "/server.policy";

    public static String getLocationOfPolicyFile() {
        try {
            File tempFile = File.createTempFile("server", ".policy");
            InputStream is = PolicyFileLocator.class.getResourceAsStream(POLICY_FILE_NAME);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            int read = 0;
            while((read = is.read()) != -1) {
                writer.write(read);
            }
            writer.close();
            tempFile.deleteOnExit();
            return tempFile.getAbsolutePath();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

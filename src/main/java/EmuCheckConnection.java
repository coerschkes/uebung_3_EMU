import net.sf.yad2xx.Device;
import net.sf.yad2xx.FTDIException;
import net.sf.yad2xx.FTDIInterface;

public class EmuCheckConnection {

    private Device device = null;
    private boolean connected = true;

    public EmuCheckConnection() throws FTDIException {
        Device[] devices = FTDIInterface.getDevices();
        System.out.println("Connected devices: " + devices.length);
    }

    public void disconnect() {
    }

    public void connect() {
    }

    public void sendProgrammingMode() {
    }

    public void sendRequest(MESSWERT messwert) {
    }
}

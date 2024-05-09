import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            boolean b = true;
            final EmuConnector emuConnector = new EmuConnector();
            final BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
            while (b) {
                final String input = inputBuffer.readLine();
                switch (input) {
                    case "exit" -> {
                        emuConnector.disconnect();
                        b = false;
                    }
                    case "connect" -> emuConnector.connect();
                    case "pmode" -> emuConnector.sendProgrammingMode();
                    case "snumber" -> emuConnector.sendRequest(
                            Measurement.SERIAL_NUMBER);
                    case "text" -> emuConnector.sendRequest(Measurement.TEXT);
                    case "power" -> emuConnector.sendRequest(Measurement.POWER);
                    case "apower" -> emuConnector.sendRequest(Measurement.APPARENT_POWER);
                    case "powerf" -> emuConnector.sendRequest(Measurement.POWER_FACTOR);
                    case "print" -> emuConnector.printBuffer();
                    case "clear" -> emuConnector.clearBuffer();
                    default -> System.out.println("Unknown input!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

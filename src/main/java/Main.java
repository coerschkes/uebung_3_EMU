import net.sf.yad2xx.FTDIException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            boolean b = true;
            EmuCheckConnection ecc
                    = new EmuCheckConnection();
            BufferedReader ein = new BufferedReader(
                    new InputStreamReader(System.in));
            while (b) {
                String input = ein.readLine();
                if (input.equals("exit")) {
                    ecc.disconnect();
                    b = false;
                } else if (input.equals("connect")) {
                    ecc.connect();
                } else if (input.equals("pmode")) {
                    ecc.sendProgrammingMode();
                } else if (input.equals("seriennummer")) {
                    ecc.sendRequest(
                            MESSWERT.Seriennummer);
                } else if (input.equals("text")) {
                    ecc.sendRequest(MESSWERT.Text);
                } else if (input.equals("")) {
                } else {
                    System.out.println(
                            "Falscher Befehl!");
                }
            }
        } catch (FTDIException ftdiExc) {
            System.out.println("FTDIException");
            ftdiExc.printStackTrace();
        } catch (IOException ioExc) {
            System.out.println("IOException");
            ioExc.printStackTrace();
        }
    }
}

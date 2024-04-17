import java.io.*;
import net.sf.yad2xx.FTDIException;

public class Main {
	public static void main(String[] args){
		try{
			boolean b = true;
			EmuCheckConnection ecc 
 				= new EmuCheckConnection();
			BufferedReader ein = new BufferedReader(
				new InputStreamReader(System.in));
			while(b){
				String eingabe = ein.readLine();
				if (eingabe.equals("exit")){
					ecc.disconnect();
					b=false;
				}
				else if (eingabe.equals("connect")){
					ecc.connect();
				}
				else if (eingabe.equals("pmode")){
					ecc.sendProgrammingMode();
				}
				else if (eingabe.equals("seriennummer")){
					ecc.sendRequest(
 						MESSWERT.Seriennummer);
				}
				else if (eingabe.equals("text")){
					ecc.sendRequest(MESSWERT.Text);
				}
				else if(eingabe.equals("")){
				}
				else{
					System.out.println(
 						"Falscher Befehl!");
				}
 			}
 		}
		catch(FTDIException ftdiExc) {
			System.out.println("FTDIException");
			ftdiExc.printStackTrace();
		}	
		catch(IOException ioExc) {
			System.out.println("IOException");
			ioExc.printStackTrace();
		}
	}
}

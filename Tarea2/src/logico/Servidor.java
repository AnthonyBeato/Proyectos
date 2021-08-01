package logico;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread {
	
	public static Vector entradas = new Vector();
	
	public static void main (String args[]) 
	{
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(7000);
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada."+ioe);
		    System.exit(1);
		}
		
		while(true) {
			try {
				Socket socket = server.accept();
			} catch (IOException ioe) {
				System.out.println("Error: "+ioe);
			}
		}
	}

}

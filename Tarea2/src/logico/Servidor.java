package logico;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread {
	
	public static Vector entradas = new Vector();
	
	public static void main (String args[]) 
	{
		//Controladora.getInstance().FileRespaldo("factura/factura.txt", args[0]);
		System.out.println("Entro");
		ServerSocket server = null;
		try {
			server = new ServerSocket(7000);
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada."+ioe);
		    System.exit(1);
		}
		
		
		try {
			Socket socket = server.accept();
			System.out.println("Conexion aceptada de: "+socket.getInetAddress());
			Flujo flujo = new Flujo(socket);
			Thread t = new Thread(flujo);
			t.start();
		} catch (IOException ioe) {
			System.out.println("Error: "+ioe);
		}
		
	} 

}

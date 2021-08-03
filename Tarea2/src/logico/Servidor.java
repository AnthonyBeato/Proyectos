package logico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor{
	
	public static Vector<Flujo> entradas = new Vector<Flujo>();
	
	public static void main (String args[])  
	{
		//Controladora.getInstance().FileRespaldo("factura/factura.txt", args[0]);
		System.out.println("Entro");
		ServerSocket server = null;
		try {
			server = new ServerSocket(7000);
			Socket socket;
			
			while(true) {
				socket = server.accept();
				
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				Flujo flujo = new Flujo(socket);
				flujo.start();
			}
			
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada."+ioe);
		    System.exit(1);
		}
		
	} 
	
	/* while (true) {
				try {
					socket = server.accept();
					System.out.println("Conexion aceptada de: "+socket.getInetAddress());
					Flujo flujo = new Flujo(socket);
					Thread t = new Thread(flujo);
					t.start();
				} catch (IOException ioe) {
					System.out.println("Error: "+ioe);
				}
			}
	*/
}

package logico;

import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class Flujo extends Thread
{
  Socket nsfd;
  DataInputStream FlujoLectura;
  DataOutputStream FlujoEscritura;

  public Flujo (Socket sfd)
  {
    nsfd = sfd;
    try
    {
      FlujoLectura = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
      FlujoEscritura = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
    }
    catch(IOException ioe)
   {
     System.out.println("IOException(Flujo): "+ioe);
   }
 }

 public void run()
 {
    System.out.println("Llego al inicio");
	Date fecha = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String fecha2 = formatter.format(fecha);
	
	String nameSourceFactura = "resplado/"+fecha2+".txt";
	
	String sourceFactura = "factura/factura.txt";
	String destinationFactura = nameSourceFactura;
	
	System.out.println("Desde: " + sourceFactura);
	System.out.println("Hacia: " + destinationFactura);
	
	try {
		File inFile = new File(sourceFactura);
		File outFile = new File(destinationFactura);
		
		FileInputStream in = new FileInputStream(inFile);
		FileOutputStream out = new FileOutputStream(outFile);
		
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		
		in.close();
		out.close();
		System.out.println("Llego hasta el final del flujo");
		
	} catch (IOException e) {
		System.out.println("Error en salida/entrada");
	}
		
	 
 }

}

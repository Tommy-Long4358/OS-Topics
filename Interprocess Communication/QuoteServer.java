/**
 * Tommy Long
 * Group 8
 * 2/27/22
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class QuoteServer
{
	public static void main(String [] args)
	{
		try
		{
			// Establish port 6017
			ServerSocket sock = new ServerSocket(6017);
			
			System.out.println("Socket Connected!");
			
			/* now listen for connections */
			while(true)
			{
				
				// accept the socket
				Socket client = sock.accept();
				
				// quote to be written to socket and returned by client
				String quote = "Hello World";
				
				// Send quote to the client who stores the quote
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				
				/* Write the quote to the socket */
				pout.println(quote);
				
				/* Close the socket and resume */
				/* Listening to connections */
				client.close();
			}
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
		
	}
	

}

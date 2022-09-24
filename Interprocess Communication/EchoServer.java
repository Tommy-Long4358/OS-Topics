/**
 * Tommy Long
 * Group 8
 * 2/27/22
 */



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer
{
	public static void main(String[] args)
	{
		try
		{
			// Establish port 6017
			
			ServerSocket sock = new ServerSocket(6017);
			
			System.out.println("Socket connected to port 6017!");
			
			// Listen to port 6017 and accept it
			Socket client = sock.accept();
			while(true)
			{
				// PrintWriter class to write the server input to the client on the same port number.
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				
				
				// Get output of the client from EchoClient class.
				InputStream serverInput = client.getInputStream();
				
				// Read the output of the client, that is translated into char.
				InputStreamReader serverInputReader = new InputStreamReader(serverInput);
				
				// Write the server quote to the client
				pout.println("Hello there! I am the server.");
				
			}
		}
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}
}

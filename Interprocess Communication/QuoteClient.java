/**
 * Tommy Long
 * Group 8
 * 2/27/22
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class QuoteClient
{
	public static void main(String[] args)
	{		
		try
		{
			// Establish a sock with the same port number as the server.
			Socket sock = new Socket("127.0.0.1", 6017);
			
			// Get input from the socket.
			InputStream serverInput = sock.getInputStream();
			
			// Reads the input from input and converts it into char.
			InputStreamReader serverInputReader = new InputStreamReader(serverInput);
			
			// Char is then read by the BufferedReader class to be translated into strings.
			BufferedReader bin = new BufferedReader(serverInputReader);
			
			// Store bufferedReader as a string
			String quote = bin.readLine();
			
			// print out the quote returned by the server.
			System.out.println(quote);
			
			// close the socket
			sock.close();
		} 
		catch (IOException ioe)
		{
			System.err.println(ioe);
		}
	}

}

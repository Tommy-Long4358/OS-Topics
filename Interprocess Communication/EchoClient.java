/**
 * Tommy Long
 * Group 8
 * 2/27/22
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient 
{
	public static void main(String args[]) 
	{
		try 
		{
			// Establish port 6017.
			Socket socket = new Socket("127.0.0.1", 6017);
			
			// PrintWriter class to write socket input to Server.
			PrintWriter pout = new PrintWriter(socket.getOutputStream(), true);
			
			// Get quote from the server using the InputStream
			InputStream serverInput = socket.getInputStream();
			
			// Reads the quote using InputStreamReader
			InputStreamReader serverInputReader = new InputStreamReader(serverInput);
			
			// Get quote from the client usint InputStream
			InputStream userInput = System.in;
			
			// Translates the quote using InputStreamReader
			InputStreamReader userInputReader = new InputStreamReader(userInput);
			
			// Reads the userInputReader with BufferedReader
			BufferedReader userRead = new BufferedReader(userInputReader);
			BufferedReader serverRead = new BufferedReader(serverInputReader);
			
			String input = "";
			
			// Loop until user exits
			while(true)
			{
				System.out.println("Enter your message: ");
				
				// User input that is stored in userRead
				input = userRead.readLine();
				
				if (input.equals("Exit"))
				{
					break;
				}
				
				// Write user input quote to the EchoServer.
				pout.println(input);
			
				// Display the server message as a response to the user input.
				System.out.println(serverRead.readLine());
			}
			
			System.out.println("Socket closing...");
			socket.close();
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}

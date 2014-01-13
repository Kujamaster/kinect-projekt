package network;

import java.io.*;
import java.net.*;

public class ClientSide {
	static int x = 140;
	static int y = 230;

	public static void main(String [] args) {
		String serverName = "194.47.32.179";
		int port = 6066;
		try {
			System.out.println("Connecting to " + serverName + ":" + port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF(x + " " + y);
			out.writeChars(x + " " + y);
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
			client.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

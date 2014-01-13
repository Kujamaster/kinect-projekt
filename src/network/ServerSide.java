package network;

import java.net.*;
import java.io.*;

public class ServerSide extends Thread{
	private ServerSocket serverSocket;
	private String message;
	public ServerSide(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				//BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
				DataInputStream in = new DataInputStream(server.getInputStream());
				//readMessage(in);
				System.out.println(in.readChar());
				//message = in.readLine();
				//System.out.println(message);
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
				
			} catch(SocketTimeoutException e) {
				System.out.println("Socket timed out!");
				break;
			} catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
		run();
	}
	public static void main(String [] args) {
		int port = 6066;
		try {
			Thread t = new ServerSide(port);
			t.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readMessage(BufferedReader a) {
		StringBuffer sb = new StringBuffer();
		String s = "";
		
		try {
			s = a.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String data = s;
		System.out.println(data);
	}
}

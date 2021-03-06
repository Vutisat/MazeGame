package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class MazeClient {
	XmlRpcClient xmlRPCclient = null;
	int port;
	String id = "";
	String username;
	String password;
	
	public MazeClient(String host,int p) throws IOException {
		port = p;
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://" + host+":"+port));
		xmlRPCclient = new XmlRpcClient();
		xmlRPCclient.setConfig(config);
	}
	
	public void run() {
		try{
			Scanner input = new Scanner(System.in);
			connect();}
		catch(Exception err) {
			System.err.println("Error in run: " + err);
			return;
		}
	}
	
	public void connect() throws XmlRpcException  {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Username: ");
		username = input.next();
		
		System.out.print("Password: ");
		password = input.next();
		
		id = connectToServer(username, password);
		if (id.equals("-1")) {
			throw new XmlRpcException("Wrong Login");
		}
	}
	
	public String connectToServer(String user, String pass) throws XmlRpcException {
		Object[] params = new Object[]{user, pass};
		String result= (String) xmlRPCclient.execute("MazeServer.connect", params);
		return result;
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage:  java AddMessage <HOST> <PORT>");
		}
		
		int port = -1;
		try {
			port = Integer.parseInt(args[1]);
		} catch (Exception err) {
			System.out.println("specify port");
			return;
		}

		try {
			MazeClient client = new MazeClient(args[0],port);
			client.run();
		}
		catch (Exception err) {
			System.err.println("Error initializing client: " + err);
			return;
		}
	}
	
}
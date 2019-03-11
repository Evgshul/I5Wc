package jtm.activity12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class ChatServer implements Runnable {

	// Common structures for all threads:
	static final int port = 9999; // port to listen on
	// server socket, which listens to new connections
	static ServerSocket server;
	// Thread safe list of connections to connected clients
	static Vector<ChatServer> connections;

	// Structures for separate threads:
	// reference to client socket when new connection is accepted
	private Socket client;
	private Scanner in; // for reading from client socket
	private PrintWriter out; // for writing to client socket

	/**
	 * This is entry point to start Chat Server. Note that this method do not
	 * use behavior which is implemented for Runnable interface.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 1. initialize vector of connections
		connections = new Vector<ChatServer>();
		System.out.println("server started");
		/*try{
			server = new ServerSocket(9999);
			Socket socket = server.accept();
			connections.add(new ChatServer(socket));
			
		}catch(IOException e){
			e.printStackTrace();
		}*/
		// TODO 2. try to create ServerSocket on specified port
			// TODO 3. handle exceptions (show exception and exit with error
			// status)
		Socket socket = null;
		Thread t = null;
		while (true) {
			try{
				server = new ServerSocket(port);
				socket = server.accept();
				connections.add(new ChatServer(socket));
			
			}catch(IOException e){
				e.printStackTrace();
			}
			
			
			// TODO 1. Try to initialize client Socket in infinite loop wi	th
			// server.accept() method
				// TODO 2. handle exceptions
			// TODO 3. if socket is initialized successfully, create new Thread
			// passing new ChatServer(socket) as a parameter for it.
			// Then invoke start() method for this thread
		}
		
	}

	/**
	 * This method processes each connected client and writes received messages
	 * to all other clients
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		while(true){
			
		//client =
		}
		
		
		// TODO try to read lines in loop from the input reader of the
		// client and
		// write it to all clients (including current client) in form:
		// "> message"
		// HINT: use connections to traverse all clients and invoke
		// sendMsg(msg)
		// for them
				// TODO 2. if message is "quit" or "exit", break loop
			// TODO 3. handle exceptions
			// TODO 4. finally close all inputs and outputs of the connection,
			// and
			// remove current object reference from connections collection
			// and handle exceptions for these operations, if necessary
	}

	/**
	 * This constructor is used to pass client Socket reference for new thread
	 * 
	 * @param client
	 */
	ChatServer(Socket client) {
		// TODO 1. save passed client socket reference into current object
		// TODO 2. Add newly created ChatServer into connections collection
		// TODO 3. Try to add input and output streams to the client socket
		// HINT: to see output for each entered message, construct PrintWriter
		// with auto flush option (or use flush() method)
			// TODO handle exceptions
		try{
		client = server.accept();
		connections.add(new ChatServer(client));
	    in = new Scanner(new InputStreamReader(client.getInputStream())); 
		out = new PrintWriter(client.getOutputStream());
		out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	/**
	 * This method is used to write message to the all connected clients
	 * 
	 * @param msg
	 */
	public void sendMsg(String msg) {
		// TODO print passed message into output stream (out) with writer of
		// current
		// object
	}
}

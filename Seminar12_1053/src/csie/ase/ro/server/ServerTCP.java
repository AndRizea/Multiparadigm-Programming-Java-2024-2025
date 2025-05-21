package csie.ase.ro.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	public static void main(String[] args) {
		int port = 8001;

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Server connected on port: " + port);

			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String receivedMessage = dataInputStream.readUTF();
			System.out.println("Message received: " + receivedMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

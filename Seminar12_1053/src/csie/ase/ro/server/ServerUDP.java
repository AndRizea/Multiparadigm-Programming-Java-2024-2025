package csie.ase.ro.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {

	public static void main(String[] args) {
		int port = 8000;

		try (DatagramSocket socket = new DatagramSocket(port)) {
			System.out.println("Server started on port " + port);
			while (true) {
				byte[] buffer = new byte[256];
				DatagramPacket packetToBeReceived = new DatagramPacket(buffer, buffer.length);
				socket.receive(packetToBeReceived);
				String messageReceived = new String(packetToBeReceived.getData());
				System.out.println("Received message: " + messageReceived);

				String response = new String("Data received");
				byte[] bytes = response.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(bytes, bytes.length, packetToBeReceived.getAddress(),
						packetToBeReceived.getPort());
				socket.send(packetToSend);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

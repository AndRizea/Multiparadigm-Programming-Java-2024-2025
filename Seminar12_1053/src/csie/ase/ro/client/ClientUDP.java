package csie.ase.ro.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

import csie.ase.ro.sensor.SensorData;

public class ClientUDP {

	public static void main(String[] args) {
		SensorData sensor1 = new SensorData(20, 17.5f);

		try (DatagramSocket socket = new DatagramSocket()) {
			for (int i = 0; i < 5; i++) {
				Random random = new Random();
				int humidity = random.nextInt(100);
				float temperature = random.nextFloat(45.5f);
				SensorData sensor = new SensorData(humidity, temperature);

				String message = sensor.toString();
				byte[] bytes = message.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(bytes, bytes.length,
						InetAddress.getByName("localhost"), 8000);
				socket.send(packetToSend);

				byte[] buffer = new byte[256];
				DatagramPacket packetResponse = new DatagramPacket(buffer, buffer.length);
				socket.receive(packetResponse);
				String messageReceived = new String(packetResponse.getData());
				System.out.println("Received message: " + messageReceived);
				Thread.sleep(2000);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package csie.ase.ro.client;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import csie.ase.ro.sensor.SensorData;

public class ClientTCP {
	
	public static void main(String[] args) {
		SensorData sensor = new SensorData(20, 17.5f);
		
		try(Socket socket = new Socket("localhost", 8001)){
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF(sensor.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

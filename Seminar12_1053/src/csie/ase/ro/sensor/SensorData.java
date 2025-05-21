package csie.ase.ro.sensor;

public class SensorData {

	private int humidity;
	private float temperature;

	public SensorData(int humidity, float temperature) {
		this.humidity = humidity;
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SensorData [humidity=");
		builder.append(humidity);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append("]");
		return builder.toString();
	}

}

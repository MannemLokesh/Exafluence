package com.exfscm.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection  = "Devices")
public class Devices 
{
	private double Battery_Level;
	private String Route_From;
	private long Device_Id;
	private String Route_To;
	private double First_Sensor_temperature;
	public double getBattery_Level() {
		return Battery_Level;
	}
	public void setBattery_Level(double battery_Level) {
		Battery_Level = battery_Level;
	}
	public String getRoute_From() {
		return Route_From;
	}
	public void setRoute_From(String route_From) {
		Route_From = route_From;
	}
	public long getDevice_Id() {
		return Device_Id;
	}
	public void setDevice_Id(long device_Id) {
		Device_Id = device_Id;
	}
	public String getRoute_To() {
		return Route_To;
	}
	public void setRoute_To(String route_To) {
		Route_To = route_To;
	}
	public double getFirst_Sensor_temperature() {
		return First_Sensor_temperature;
	}
	public void setFirst_Sensor_temperature(double first_Sensor_temperature) {
		First_Sensor_temperature = first_Sensor_temperature;
	}
	
	
}

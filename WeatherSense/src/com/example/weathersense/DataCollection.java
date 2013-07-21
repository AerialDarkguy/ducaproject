package com.example.weathersense;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//uses string data retrieved from WeatherHttp and organizes it into seperate variables
//variables can be retrieved ex: DataCollection.getTempMin();
public class DataCollection {

	
	private static double temp_min;
	private static double temp_max;
	private static String hum;
	
	
	private static JsonParser jp;
	private static JsonElement root;
	private static JsonObject rootobj;
	
	public static void syncData(String data){
		jp = new JsonParser();
		root = jp.parse(data);
		rootobj = root.getAsJsonObject();
		
		temp_min = rootobj.get("main").getAsJsonObject().get("temp_min").getAsDouble();
		temp_max = rootobj.get("main").getAsJsonObject().get("temp_max").getAsDouble();
		hum = rootobj.get("main").getAsJsonObject().get("hum").getAsString();
	}
	
	public double getTempMin(){
		return temp_min;
	}
	
	public double getTempMax(){
		return temp_max;
	}
	
	public String getHum(){
		return hum;
	}
	
}

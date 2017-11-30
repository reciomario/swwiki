package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import utils.SwUtils;

public class Vehicle {
	
	private String edited;
    private String model;
    private String cargo_capacity;
    private String crew;
    private String[] films;
    private String vehicle_class;
    private String url;
    private String passengers;
    private String[] pilots;
    private String created;
    private String consumables;
    private String manufacturer;
    private String name;
    private String length;
    private String max_atmosphering_speed;
    private String cost_in_credits;

    public String getEdited (){
        return edited;
    }

    public void setEdited (String edited){
        this.edited = edited;
    }

    public String getModel (){
        return model;
    }

    public void setModel (String model){
        this.model = model;
    }

    public String getCargo_capacity (){
        return cargo_capacity;
    }

    public void setCargo_capacity (String cargo_capacity){
        this.cargo_capacity = cargo_capacity;
    }

    public String getCrew (){
        return crew;
    }

    public void setCrew (String crew){
        this.crew = crew;
    }

    public String[] getFilms (){
        return films;
    }

    public void setFilms (String[] films){
        this.films = films;
    }

    public String getVehicle_class (){
        return vehicle_class;
    }

    public void setVehicle_class (String vehicle_class){
        this.vehicle_class = vehicle_class;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public String getPassengers (){
        return passengers;
    }

    public void setPassengers (String passengers){
        this.passengers = passengers;
    }

    public String[] getPilots (){
        return pilots;
    }

    public void setPilots (String[] pilots){
        this.pilots = pilots;
    }

    public String getCreated (){
        return created;
    }

    public void setCreated (String created){
        this.created = created;
    }

    public String getConsumables (){
        return consumables;
    }

    public void setConsumables (String consumables){
        this.consumables = consumables;
    }

    public String getManufacturer (){
        return manufacturer;
    }

    public void setManufacturer (String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getLength (){
        return length;
    }

    public void setLength (String length){
        this.length = length;
    }

    public String getMax_atmosphering_speed (){
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed (String max_atmosphering_speed){
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public String getCost_in_credits (){
        return cost_in_credits;
    }

    public void setCost_in_credits (String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    @Override
    public String toString(){
        return "ClassPojo [edited = "+edited+", model = "+model+", cargo_capacity = "+cargo_capacity+", crew = "+crew+", films = "+films+", vehicle_class = "+vehicle_class+", url = "+url+", passengers = "+passengers+", pilots = "+pilots+", created = "+created+", consumables = "+consumables+", manufacturer = "+manufacturer+", name = "+name+", length = "+length+", max_atmosphering_speed = "+max_atmosphering_speed+", cost_in_credits = "+cost_in_credits+"]";
    }
    
    public List<Vehicle> getAll() throws IOException {
    	String msg = SwUtils.sender("https://swapi.co/api/vehicles/");
    	
    	List<Vehicle> vehiList = new ArrayList<Vehicle>();
    	Gson gson = new Gson();
    	ModelList results = gson.fromJson(msg, ModelList.class);
    	for (JsonElement pa : results.results) {
			 Vehicle vehi = gson.fromJson(pa.getAsJsonObject(), Vehicle.class);	
			 vehiList.add(vehi);
		}
    	
    	//More results?
    	while(results.hasMore()) {
    		msg = SwUtils.sender(results.next);
    		results = gson.fromJson(msg, ModelList.class);
    		for (JsonElement pa : results.results) {
    			Vehicle vehi = gson.fromJson(pa.getAsJsonObject(), Vehicle.class);	
    			vehiList.add(vehi);
    		}   		
    	}
    	return vehiList;
    }
}

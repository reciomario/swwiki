package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import utils.SwUtils;

public class Starship {
	
	private String edited;
	private String model;
	private String MGLT;
	private String cargo_capacity;
	private String starship_class;
	private String crew;
	private String[] films;
	private String url;
	private String hyperdrive_rating;
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
	
	public String getMGLT (){
	    return MGLT;
	}
	
	public void setMGLT (String MGLT){
	    this.MGLT = MGLT;
	}
	
	public String getCargo_capacity (){
	    return cargo_capacity;
	}
	
	public void setCargo_capacity (String cargo_capacity){
	    this.cargo_capacity = cargo_capacity;
	}
	
	public String getStarship_class (){
	    return starship_class;
	}
	
	public void setStarship_class (String starship_class){
	    this.starship_class = starship_class;
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
	
	public String getUrl (){
	    return url;
	}
	
	public void setUrl (String url){
	    this.url = url;
	}
	
	public String getHyperdrive_rating (){
	    return hyperdrive_rating;
	}
	
	public void setHyperdrive_rating (String hyperdrive_rating){
	    this.hyperdrive_rating = hyperdrive_rating;
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
	
	public void setManufacturer (String manufacturer){
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
	
	public void setCost_in_credits (String cost_in_credits){
	    this.cost_in_credits = cost_in_credits;
	}
	
	@Override
	public String toString(){
	    return "ClassPojo [edited = "+edited+", model = "+model+", MGLT = "+MGLT+", cargo_capacity = "+cargo_capacity+", starship_class = "+starship_class+", crew = "+crew+", films = "+films+", url = "+url+", hyperdrive_rating = "+hyperdrive_rating+", passengers = "+passengers+", pilots = "+pilots+", created = "+created+", consumables = "+consumables+", manufacturer = "+manufacturer+", name = "+name+", length = "+length+", max_atmosphering_speed = "+max_atmosphering_speed+", cost_in_credits = "+cost_in_credits+"]";
	}
	
	public List<Starship> getAll() throws IOException {
    	String msg = SwUtils.sender("https://swapi.co/api/starships/");
    	
    	List<Starship> shipList = new ArrayList<Starship>();
    	Gson gson = new Gson();
    	ModelList results = gson.fromJson(msg, ModelList.class);
    	for (JsonElement pa : results.results) {
    		Starship ship = gson.fromJson(pa.getAsJsonObject(), Starship.class);	
			 shipList.add(ship);
		}
    	
    	//More results?
    	while(results.hasMore()) {
    		msg = SwUtils.sender(results.next);
    		results = gson.fromJson(msg, ModelList.class);
    		for (JsonElement pa : results.results) {
    			Starship ship = gson.fromJson(pa.getAsJsonObject(), Starship.class);	
    			shipList.add(ship);
    		}   		
    	}
    	return shipList;
    }
}

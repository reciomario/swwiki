package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import utils.SwUtils;

public class Planet {
	
    private String terrain;
    private String edited;
    private String diameter;
    private String[] films;
    private String url;
    private String surface_water;
    private String created;
    private String orbital_period;
    private String name;
    private String rotation_period;
    private String climate;
    private String gravity;
    private String population;
    private String[] residents;

    public String getTerrain (){
        return terrain;
    }

    public void setTerrain (String terrain){
        this.terrain = terrain;
    }

    public String getEdited (){
        return edited;
    }

    public void setEdited (String edited){
        this.edited = edited;
    }

    public String getDiameter (){
        return diameter;
    }

    public void setDiameter (String diameter){
        this.diameter = diameter;
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

    public String getSurface_water (){
        return surface_water;
    }

    public void setSurface_water (String surface_water){
        this.surface_water = surface_water;
    }

    public String getCreated (){
        return created;
    }

    public void setCreated (String created){
        this.created = created;
    }

    public String getOrbital_period (){
        return orbital_period;
    }

    public void setOrbital_period (String orbital_period){
        this.orbital_period = orbital_period;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getRotation_period (){
        return rotation_period;
    }

    public void setRotation_period (String rotation_period){
        this.rotation_period = rotation_period;
    }

    public String getClimate (){
        return climate;
    }

    public void setClimate (String climate){
        this.climate = climate;
    }

    public String getGravity (){
        return gravity;
    }

    public void setGravity (String gravity){
        this.gravity = gravity;
    }

    public String getPopulation (){
        return population;
    }

    public void setPopulation (String population){
        this.population = population;
    }

    public String[] getResidents (){
        return residents;
    }

    public void setResidents (String[] residents){
        this.residents = residents;
    }

    @Override
    public String toString(){
        return "ClassPojo [terrain = "+terrain+", edited = "+edited+", diameter = "+diameter+", films = "+films+", url = "+url+", surface_water = "+surface_water+", created = "+created+", orbital_period = "+orbital_period+", name = "+name+", rotation_period = "+rotation_period+", climate = "+climate+", gravity = "+gravity+", population = "+population+", residents = "+residents+"]";
    }
	
    public List<Planet> getAll() throws IOException {
    	String msg = SwUtils.sender("https://swapi.co/api/planets/");
    	
    	List<Planet> planetList = new ArrayList<Planet>();
    	Gson gson = new Gson();
    	ModelList results = gson.fromJson(msg, ModelList.class);
    	for (JsonElement pa : results.results) {
			 Planet planet = gson.fromJson(pa.getAsJsonObject(), Planet.class);	
			 planetList.add(planet);
		}
    	
    	//More results?
    	while(results.hasMore()) {
    		msg = SwUtils.sender(results.next);
    		results = gson.fromJson(msg, ModelList.class);
    		for (JsonElement pa : results.results) {
    			Planet planet = gson.fromJson(pa.getAsJsonObject(), Planet.class);	
    			planetList.add(planet);
    		}   		
    	}
    	return planetList;
    }
		
}

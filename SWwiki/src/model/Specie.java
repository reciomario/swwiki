package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import utils.SwUtils;

public class Specie { 
	
	private String edited;
    private String skin_colors;
    private String eye_colors;
    private String average_height;
    private String average_lifespan;
    private String hair_colors;
    private String created;
    private String classification;
    private String name;
    private String designation;
    private String homeworld;
    private String[] films;
    private String language;
    private String[] people;
    private String url;

    public String getEdited (){
        return edited;
    }

    public void setEdited (String edited){
        this.edited = edited;
    }

    public String getSkin_colors (){
        return skin_colors;
    }

    public void setSkin_colors (String skin_colors){
        this.skin_colors = skin_colors;
    }

    public String getEye_colors (){
        return eye_colors;
    }

    public void setEye_colors (String eye_colors){
        this.eye_colors = eye_colors;
    }

    public String getAverage_height (){
        return average_height;
    }

    public void setAverage_height (String average_height){
        this.average_height = average_height;
    }

    public String getAverage_lifespan (){
        return average_lifespan;
    }

    public void setAverage_lifespan (String average_lifespan){
        this.average_lifespan = average_lifespan;
    }

    public String getHair_colors (){
        return hair_colors;
    }

    public void setHair_colors (String hair_colors){
        this.hair_colors = hair_colors;
    }

    public String getCreated (){
        return created;
    }

    public void setCreated (String created){
        this.created = created;
    }

    public String getClassification (){
        return classification;
    }

    public void setClassification (String classification){
        this.classification = classification;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDesignation (){
        return designation;
    }

    public void setDesignation (String designation){
        this.designation = designation;
    }

    public String getHomeworld (){
        return homeworld;
    }

    public void setHomeworld (String homeworld){
        this.homeworld = homeworld;
    }

    public String[] getFilms (){
        return films;
    }

    public void setFilms (String[] films){
        this.films = films;
    }

    public String getLanguage (){
        return language;
    }

    public void setLanguage (String language){
        this.language = language;
    }

    public String[] getPeople (){
        return people;
    }

    public void setPeople (String[] people){
        this.people = people;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    @Override
    public String toString(){
        return "ClassPojo [edited = "+edited+", skin_colors = "+skin_colors+", eye_colors = "+eye_colors+", average_height = "+average_height+", average_lifespan = "+average_lifespan+", hair_colors = "+hair_colors+", created = "+created+", classification = "+classification+", name = "+name+", designation = "+designation+", homeworld = "+homeworld+", films = "+films+", language = "+language+", people = "+people+", url = "+url+"]";
    }
    
    public List<Specie> getAll() throws IOException {
    	String msg = SwUtils.sender("https://swapi.co/api/species/");
    	
    	List<Specie> espeList = new ArrayList<Specie>();
    	Gson gson = new Gson();
    	ModelList results = gson.fromJson(msg, ModelList.class);
    	for (JsonElement pa : results.results) {
    		Specie espe = gson.fromJson(pa.getAsJsonObject(), Specie.class);	
    		espeList.add(espe);
		}
    	
    	//More results?
    	while(results.hasMore()) {
    		msg = SwUtils.sender(results.next);
    		results = gson.fromJson(msg, ModelList.class);
    		for (JsonElement pa : results.results) {
    			Specie especie = gson.fromJson(pa.getAsJsonObject(), Specie.class);	
    			espeList.add(especie);
    		}   		
    	}
    	return espeList;
    }

}

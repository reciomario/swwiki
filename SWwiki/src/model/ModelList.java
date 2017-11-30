package model;

import java.util.ArrayList;

import com.google.gson.JsonArray;

public class ModelList {
	
	public int count;
    public String next;
    public String previous;
    public JsonArray results;

    public boolean hasMore() {
        return (next != null && next.length() != 0);
    }

}

package nl.hhs.werkbon.werkbon.Models;

import java.util.ArrayList;

/**
 * Created by jeroner on 10/01/15.
 */
public class Installation {

    private String capacity;
    private ArrayList<Converter> converters;
    private ArrayList<Module> modules;
    private String roofing;

    private String roofAccess;
    private String tiles;
    private String shadow;
    private String cupboard;
    private String accessibility;
    private String preparing;
    private String other;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Installation() { }

    public Installation(String capacity, ArrayList<Converter> converters, ArrayList<Module> modules, String roofing, String roofAccess, String tiles, String shadow, String cupboard, String accessibility, String preparing, String other) {
        this.capacity = capacity;
        this.converters = converters;
        this.modules = modules;
        this.roofing = roofing;
        this.roofAccess = roofAccess;
        this.tiles = tiles;
        this.shadow = shadow;
        this.cupboard = cupboard;
        this.accessibility = accessibility;
        this.preparing = preparing;
        this.other = other;
    }

    public String getCapacity() {
        return capacity;
    }

    public ArrayList<Converter> getConverters() {
        return converters;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public String getRoofing() {
        return roofing;
    }

    public String getRoofAccess() {
        return roofAccess;
    }

    public String getTiles() {
        return tiles;
    }

    public String getShadow() {
        return shadow;
    }

    public String getCupboard() {
        return cupboard;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getPreparing() {
        return preparing;
    }

    public String getOther() {
        return other;
    }
}

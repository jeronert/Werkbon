package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

/**
 * Created by Niels on 16/01/2015.
 */
public class Material implements Serializable {

    private String name;
    private String type;
    private String number;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Material() { }

    public Material(String name, String type, String number)
    {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getType() { return type; }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString()
    {
        return name + "\n\t" + type + "\n\t" + number;
    }
}

package nl.hhs.werkbon.werkbon.Models;

/**
 * Created by Niels on 16/01/2015.
 */
public class Material {
    private String name;
    private String type;
    private String number;

    public Material(String name, String type, String number)
    {
        this.name = name;
        this.type = type;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return name + "\n " + type;
    }
}

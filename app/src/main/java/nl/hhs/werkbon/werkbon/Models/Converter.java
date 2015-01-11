package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

/**
 * Created by jeroner on 10/01/15.
 */
public class Converter implements Serializable {

    private String type;
    private String quantity;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Converter() { }

    public Converter(String type, String quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }
}

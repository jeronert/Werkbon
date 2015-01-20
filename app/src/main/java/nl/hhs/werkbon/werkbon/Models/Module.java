package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

public class Module implements Serializable {

    private String type;
    private String quantity;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Module() { }

    public Module(String type, String quantity) {
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

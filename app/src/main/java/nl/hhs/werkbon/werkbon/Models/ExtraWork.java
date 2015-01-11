package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

/**
 * Created by jeroner on 10/01/15.
 */
public class ExtraWork implements Serializable {

    private String type;
    private String quantity;
    private String description;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private ExtraWork() { }

    public ExtraWork(String type, String quantity, String description) {
        this.type = type;
        this.quantity = quantity;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}

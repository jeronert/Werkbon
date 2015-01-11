package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

/**
 * Created by jeroner on 10/01/15.
 */
public class Photograph implements Serializable {

    private String id;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Photograph() { }

    public Photograph(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

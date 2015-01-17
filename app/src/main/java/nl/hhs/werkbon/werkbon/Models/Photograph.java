package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

/**
 * Created by jeroner on 10/01/15.
 */
public class Photograph implements Serializable {

    private String id;
    private String file;
    private String description;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Photograph() { }

    public Photograph(String id, String file, String description) {
        this.id          = id;
        this.file        = file;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getFile() {
        return file;
    }

    public String getDescription() {
        return description;
    }
}

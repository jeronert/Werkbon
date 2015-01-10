package nl.hhs.werkbon.werkbon;

/**
 * Created by jeroner on 10/01/15.
 */
public class Photograph {

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

package nl.hhs.werkbon.werkbon.Models;

/**
 * Created by jeroner on 10/01/15.
 */
public class Phone {

    private String number;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Phone() { }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

package nl.hhs.werkbon.werkbon;

import java.util.ArrayList;

/**
 * Created by jeroner on 10/01/15.
 */
public class WorkOrder {

    private int id;
    private Customer customer;
    private Installation system;
    private ArrayList<Photograph> photographs;
    private ArrayList<ExtraWork> extraWork;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private WorkOrder() { }

    public WorkOrder(int id, Customer customer, Installation system, ArrayList<Photograph> photographs, ArrayList<ExtraWork> extraWork) {
        this.id          = id;
        this.customer    = customer;
        this.system      = system;
        this.photographs = photographs;
        this.extraWork   = extraWork;
    }

    public int getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Installation getSystem() {
        return this.system;
    }

    public ArrayList<Photograph> getPhotographs() {
        return this.photographs;
    }

    public ArrayList<ExtraWork> getExtraWork() {
        return this.extraWork;
    }

}

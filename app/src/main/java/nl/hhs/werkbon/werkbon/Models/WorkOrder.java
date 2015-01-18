package nl.hhs.werkbon.werkbon.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeroner on 10/01/15.
 */
public class WorkOrder implements Serializable {

    private int id;
    private Customer customer;
    private Installation system;
    private ArrayList<Photograph> photographs;
    private ArrayList<ExtraWork> extraWork;

    private String installDate;
    private Map<String, CheckPair> finish;
    private Map<String, CheckPair> safety;
    private ArrayList<Material> usedMaterial;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private WorkOrder() {
        installDate = "";
        finish = new HashMap<>();
        safety = new HashMap<>();
        usedMaterial = new ArrayList<>();

        finish.put("satisfactoryInstall", new CheckPair(false, ""));
        finish.put("cableConcealed", new CheckPair(false, ""));
        finish.put("cableBushingSealed", new CheckPair(false, ""));
        finish.put("cableTrace", new CheckPair(false, ""));
        finish.put("cleanedUp", new CheckPair(false, ""));

        safety.put("ladder", new CheckPair(false, ""));
        safety.put("cherryPicker", new CheckPair(false, ""));
        safety.put("shingleLift", new CheckPair(false, ""));
        safety.put("RSS", new CheckPair(false, ""));
        safety.put("windowAnchor", new CheckPair(false, ""));
    }

    public WorkOrder(int id, Customer customer, Installation system, ArrayList<Photograph> photographs, ArrayList<ExtraWork> extraWork) {
        this();

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

    public String toStringForFilter(){
        return this.getCustomer().getInitials() + " " + this.getCustomer().getLastName() + " " + this.getCustomer().getAddress() + " " + this.getCustomer().getHouseNumber() + " " + this.getCustomer().getZipcode() + " " + this.getCustomer().getCity();
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public Map<String, CheckPair> getFinish() {
        return finish;
    }

    public void setFinish(Map<String, CheckPair> finish) {
        this.finish = finish;
    }

    public Map<String, CheckPair> getSafety() {
        return safety;
    }

    public void setSafety(Map<String, CheckPair> safety) {
        this.safety = safety;
    }

    public ArrayList<Material> getUsedMaterial() {
        return usedMaterial;
    }

    public void setUsedMaterial(ArrayList<Material> usedMaterial) {
        this.usedMaterial = usedMaterial;
    }

    public class CheckPair implements Serializable {
        boolean isChecked;
        String comment;

        CheckPair() {}

        CheckPair(boolean isChecked, String comment)
        {
            this.isChecked = isChecked;
            this.comment = comment;
        }

        public boolean isChecked() { return isChecked; }

        public String getComment() { return comment; }

        public void setChecked(boolean isChecked) { this.isChecked = isChecked; }

        public void setComment(String comment) { this.comment = comment; }
    }
}

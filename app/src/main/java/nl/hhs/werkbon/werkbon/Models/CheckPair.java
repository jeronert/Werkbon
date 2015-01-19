package nl.hhs.werkbon.werkbon.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by Niels on 19/01/2015.
 */
public class CheckPair implements Serializable {
    boolean isChecked;
    String comment;

    private CheckPair() {}

    CheckPair(boolean isChecked, String comment)
    {
        this.isChecked = isChecked;
        this.comment = comment;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
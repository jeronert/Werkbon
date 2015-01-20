package nl.hhs.werkbon.werkbon.Models;

import java.io.Serializable;

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
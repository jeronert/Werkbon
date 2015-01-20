package nl.hhs.werkbon.werkbon;

public interface IStagingTab {
    /**
     * Sets the edittext fields and checkboxes according to the finish collection in workorder
     */
    public void updateFields();

    /**
     * Sets the WorkOrder members according to the edittexts and checkboxes
     */
    public void updateWorkOrder();
}

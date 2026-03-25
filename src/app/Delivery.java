package app;

public class Delivery {

    private int deliveryID;
    private int clientID;
    private int machineID;
    private String deliveryDate;
    private String status;

    public Delivery() {
    }

    public Delivery(int clientID, int machineID, String deliveryDate, String status) {
        this.clientID = clientID;
        this.machineID = machineID;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package app;


public class Machine {
    
    private int machineID;
    private String type;
    private String brand;
    private String model;
    private String serialNumber;
    private String status;
    
    
    public Machine() 
    { 
    
    }
    
    public Machine(int machineID, String type, String brand, String model, String serialNumber, String status) {
        this.machineID = machineID;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.status = status;
    }

    
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getMachineID() {
        return machineID;
    }
    public String getType() {
        return type;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public String getStatus() {
        return status;
    }

    
    public Object[] toArray() {
        return new Object[]{machineID, type, brand, model, serialNumber, status};
    }
    
    @Override
    public String toString() {
    return getBrand() + " " + getModel() + " (" + getSerialNumber() + ")";
}

}

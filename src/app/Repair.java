
package app;


public class Repair {
     private int repairID;
    private String machine_type;
    private String brand;
    private String model;
    private String repair_date;
    private String repair_type;
    
    
    public Repair()
    {
        
    }
    
    public Repair(int repairID, String machine_type, String brand, String model, String repair_date, String repair_type)
    {
        this.repairID = repairID;
        this.machine_type = machine_type;
        this.brand = brand;
        this.model = model;
        this.repair_date = repair_date;
        this.repair_type = repair_type;
    }
    
    
    public void setRepairID(int repairID)
    {
        this.repairID = repairID;
    }
    public void setMachine_type(String machine_type)
    {
        this.machine_type = machine_type;
    }
    public void setBrand (String brand)
    {
        this.brand = brand;
    }
    public void setModel (String model)
    {
        this.model = model;
    }
    
    public void setRepair_date (String repair_date)
    {
        this.repair_date = repair_date;
    }
    public void setRepair_type (String repair_type)
    {
        this.repair_type = repair_type;
    }
    
    
    public int getRepairID() 
    {
        return repairID; 
    }
    public String getMachine_type() 
    { 
        return machine_type; 
    }
    public String getBrand() 
    { 
        return brand; 
    }
    public String getModel() 
    { 
        return model; 
    }
    public String getRepair_date() 
    { 
        return repair_date; 
    }
    public String getRepair_type() 
    { 
        return repair_type; 
    }
    
    
    public Object[] toArray()
    {
        return new Object[]
        {
            repairID, machine_type, brand, model, repair_date, repair_type
        };
    }
    
    @Override
    public String toString() 
    {
        return getMachine_type();
    }
    
    
}



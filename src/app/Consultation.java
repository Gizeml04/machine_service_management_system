
package app;


public class Consultation {
    private int consultationID;
    private String machine_type;
    private String brand;
    private String model;
    private String consultation_date;
    private String consultation_type;


public Consultation()
    {
        
    }

public Consultation(int consultationID, String machine_type, String brand, String model, String consultation_date, String consultation_type)
    {
        this.consultationID = consultationID;
        this.machine_type = machine_type;
        this.brand = brand;
        this.model = model;
        this.consultation_date = consultation_date;
        this.consultation_type = consultation_type;
    }

public void setConsultationID(int consultationID)
    {
        this.consultationID = consultationID;
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
    
    public void setConsultation_date (String consultation_date)
    {
        this.consultation_date = consultation_date;
    }
    public void setConsultation_type (String consultation_type)
    {
        this.consultation_type = consultation_type;
    }
    
    
    public int getConsultationID() 
    {
        return consultationID; 
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
    public String getConsultation_date() 
    { 
        return consultation_date; 
    }
    public String getConsultation_type() 
    { 
        return consultation_type; 
    }

public Object[] toArray()
    {
        return new Object[]
        {
            consultationID, machine_type, brand, model, consultation_date, consultation_type
        };
    }
    
    @Override
    public String toString() 
    {
        return getMachine_type();
    }
}
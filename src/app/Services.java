package app;

public class Services {
    private int serviceID;
    private String name;
    private String type;
    private String price;
    
    public Services()
    {
        
    }
    
    public Services(int serviceID, String name, String type, String price)
    {
        this.serviceID = serviceID;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    public void setServiceID(int serviceID)
    {
        this.serviceID = serviceID;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }
    
    public Object[] toArray()
    {
        return new Object[]
        {
            serviceID, name, type, price
        };
    }
}

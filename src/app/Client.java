package app;


public class Client {
    private int clientID;
    private String name;
    private String address;
    private String city;
    private String phone;
    private String email;
    
    
    public Client()
    {
        
    }
    
    public Client(int clientID, String name, String addres, String city, String phone, String email)
    {
        this.clientID = clientID;
        this.name = name;
        this.address = addres;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }
    
    
    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress (String address)
    {
        this.address = address;
    }
    public void setCity (String city)
    {
        this.city = city;
    }
    
    public void setPhone (String phone)
    {
        this.phone = phone;
    }
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    
    public int getClientID() 
    {
        return clientID; 
    }
    public String getName() 
    { 
        return name; 
    }
    public String getAddress() 
    { 
        return address; 
    }
    public String getCity() 
    { 
        return city; 
    }
    public String getPhone() 
    { 
        return phone; 
    }
    public String getEmail() 
    { 
        return email; 
    }
    
    
    public Object[] toArray()
    {
        return new Object[]
        {
            clientID, name, address, city, phone, email
        };
    }
    
    @Override
    public String toString() 
    {
        return getName();
    }
    
    
}

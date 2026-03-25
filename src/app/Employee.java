package app;


public class Employee {
    private int employeeID;
    private String name;
    private String address;
    private String city;
    private String position;
    private String phone;
    private String email;
    
    
    public Employee()
    {
        
    }
    
    public Employee(int employeeID, String name, String addres, String city, String position, String phone, String email)
    {
        this.employeeID = employeeID;
        this.name = name;
        this.address = addres;
        this.city = city;
        this.position = position;
        this.phone = phone;
        this.email = email;
    }
    
    
    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
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
    public void setPosition (String position)
    {
        this.position = position;
    }
    public void setPhone (String phone)
    {
        this.phone = phone;
    }
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    public int getEmployeeID()
    {
        return employeeID;
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
    public String getPosition() 
    { 
        return position; 
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
            employeeID, name, address, city, position, phone, email
        };
    }
    
    
}



package org.example;

public class User {
    private Integer id;
    private String name;
    private String Qname;
    private int ordered;
    private String description;
    private Integer status;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getQname()
    {
        return Qname;
    }

    public void setQname(String qname)
    {
        Qname = qname;
    }

    public int getOrdered()
    {
        return ordered;
    }

    public void setOrdered(int ordered)
    {
        this.ordered = ordered;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Qname='" + Qname + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

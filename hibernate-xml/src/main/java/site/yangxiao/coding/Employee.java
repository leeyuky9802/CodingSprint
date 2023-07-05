package site.yangxiao.coding;

import java.util.Date;

public class Employee {
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private Date dateJoined;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, Date dataJoined) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateJoined = dataJoined;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}

package com.example.springangularcrud.model;

import javax.persistence.*;


@Entity
@Table(name="student")
public class Student {
     private long id ;
     public String firstName;
     public String lastName;
     public String emailId;

     public Student(){

     }

     public Student(long id, String firstName,String lastName, String emailId){
         this.id = id;
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
     }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
                + "]";
    }



}

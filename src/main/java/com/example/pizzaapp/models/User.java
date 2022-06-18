package com.example.pizzaapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty
    @NotNull
    private String Firstname;

    @NotEmpty
    @NotNull
    private String Surname;

    @NotNull
    private Date Birthdate;

    @NotEmpty
    @NotNull
    @Email
    private String Email;

    @Size(min = 8)
    @NotNull
    private String Password;

    public User(@NotNull @NotEmpty String firstname,
                @NotNull @NotEmpty String surname,
                @NotNull Date birthdate,
                @NotEmpty @NotNull @Email String email,
                @Size(min = 8) @NotNull String password) {
        Firstname = Objects.requireNonNull(firstname);
        Surname = Objects.requireNonNull(surname);
        Birthdate = Objects.requireNonNull(birthdate);
        Email = Objects.requireNonNull(email);
        Password = Objects.requireNonNull(password);
    }

    public User() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(Firstname, user.Firstname) && Objects.equals(Surname, user.Surname) && Objects.equals(Birthdate, user.Birthdate) && Objects.equals(Email, user.Email) && Objects.equals(Password, user.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Firstname, Surname, Birthdate, Email, Password);
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Firstname='" + Firstname + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Birthdate=" + Birthdate +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}

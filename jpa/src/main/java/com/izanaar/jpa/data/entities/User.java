package com.izanaar.jpa.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String title;

    @Column
    private String description;


    public User() {
    }



    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User))
            return false;

        User comparable = (User) obj;

        boolean allFieldsAreEqual = true;


        return comparable.getLogin().equals(login) && comparable.getDescription().equals(description) && comparable.getPassword().equals(password) &&
                comparable.getTitle().equals(title);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

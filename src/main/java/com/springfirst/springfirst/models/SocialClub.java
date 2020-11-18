package com.springfirst.springfirst.models;

import lombok.Data;
import org.aspectj.bridge.IMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table (name = "Social_club")
public class SocialClub implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @NotBlank (message = "Status cannot be empty")
    private String status;

    private int isPrivate; // 1 = yes, 0 = no

    private int pinStatus; // 1 = yes, 0 = no

    @ManyToOne
    private User user;

    @ManyToOne(targetEntity = Location.class)
    private Location location;

    private Date createdAt;

    @PrePersist
    void createdAt () {
        this.createdAt = new Date ();
    }

}

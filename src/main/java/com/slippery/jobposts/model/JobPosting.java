package com.slippery.jobposts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String name;
    private String postProfile;
    private String postDesc;
    private String location;
    private Integer reqExperience;
    @Transient
    private List<String> postTechStack;
    private LocalDateTime timePosted;

}

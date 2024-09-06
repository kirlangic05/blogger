package com.my_blog.blogger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Useras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(nullable = false,unique = true, length = 20)
    private String username;
    //@Column(nullable = false,unique = true,length = 45)
    private String email;
    //@Column(nullable = false, length = 64)
    private String password;

    @OneToMany(mappedBy = "useras",orphanRemoval = true,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Blog> blogs = new ArrayList<>();


}

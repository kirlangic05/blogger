package com.my_blog.blogger.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(length = 1000)
    private String description;

    @JsonFormat(pattern = "d MMM yyyy")
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "userasId")
    @JsonBackReference
    private Useras useras;

}


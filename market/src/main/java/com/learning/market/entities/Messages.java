package com.learning.market.entities;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable =  false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content;
    }
}

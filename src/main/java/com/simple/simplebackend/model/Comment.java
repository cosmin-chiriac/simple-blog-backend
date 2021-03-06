package com.simple.simplebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Min(value = 1, message = "The rating must be between 1 and 5")
    @Max(value = 5, message = "The rating must be between 1 and 5")
    private int rating;

    private String title;

    @Lob
    private String message;

    @ManyToOne()
    @JsonBackReference(value = "comment-user-details")
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JsonBackReference(value = "comment-article-details")
    @JoinColumn(name = "articleId")
    private Article article;
}

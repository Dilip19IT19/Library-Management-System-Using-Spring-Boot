package com.DiYukti.LIBMS.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "title", "author", "category", "description", "price", "pages" })
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Float price;
    private int pages;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category category;

}

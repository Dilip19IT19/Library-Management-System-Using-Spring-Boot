package com.DiYukti.LIBMS.dto;


import lombok.Data;


@Data
public class BookInput
{
    String title;
    String description;
    Float price;
    Integer pages;
    Long authorId;
    Long categoryId;
}

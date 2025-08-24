package com.DiYukti.LIBMS.dto;

import lombok.Data;

@Data

public class PageableCategoryInput
{
    int page;
    int size;
    String sortBy;
    boolean ascending;
}

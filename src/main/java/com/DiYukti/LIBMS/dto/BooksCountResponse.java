package com.DiYukti.LIBMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksCountResponse
{
    private Long count;
    private String name;
}

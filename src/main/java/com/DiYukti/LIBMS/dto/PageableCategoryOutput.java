package com.DiYukti.LIBMS.dto;

import com.DiYukti.LIBMS.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableCategoryOutput
{
    private List<Category> categories;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}

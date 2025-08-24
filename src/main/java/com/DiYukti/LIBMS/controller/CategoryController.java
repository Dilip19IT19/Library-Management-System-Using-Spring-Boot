package com.DiYukti.LIBMS.controller;



import com.DiYukti.LIBMS.dto.*;
import com.DiYukti.LIBMS.entity.Author;
import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.entity.Category;
import com.DiYukti.LIBMS.repository.CategoryRepository;
import com.DiYukti.LIBMS.service.AuthorService;
import com.DiYukti.LIBMS.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CategoryController
{
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final CategoryRepository categoryRepository;

    @MutationMapping(name = "saveCategory")
    public Category createCategory(@Argument("category") CategoryInput categoryInput)
    {
        Category category= Category.builder()
                .name(categoryInput.getName())
                .description(categoryInput.getDescription())
                .build();
        return categoryService.createCategoryToDb(category);
    }

    @QueryMapping(name = "getAllCategories")
    public List<Category> fetchAllCategories()
    {
        return categoryService.getAllCategoriesFromDb();
    }

    @QueryMapping(name="getCategoryById")
    public Category fetchSpecificCategory(@Argument Long categoryId)
    {
        return categoryService.getSpecificCategoryFromDb(categoryId);
    }

    @MutationMapping(name = "updateCategory")
    public Category updateCategory(@Argument("categoryId") Long categoryId, @Argument("category") CategoryInput categoryInput)
    {

        Category category=Category.builder()
                .name(categoryInput.getName())
                .description(categoryInput.getDescription())
                .build();
        return categoryService.updateCategoryFromDb(categoryId,category);
    }

    @MutationMapping(name = "deleteCategory")
    public boolean deleteCategory(@Argument Long categoryId)
    {
        return categoryService.deleteCategoryFromDb(categoryId);
    }

    @MutationMapping(name = "addBookToCategory")
    public Category addBookToCategory(@Argument Long categoryId, @Argument("book") BookInput bookInput)
    {
        Author author=authorService.getSpecificAuthorFromDb(bookInput.getAuthorId());
        Book book= Book.builder()
                .pages(bookInput.getPages())
                .price(bookInput.getPrice())
                .title(bookInput.getTitle())
                .author(author)
                .description(bookInput.getDescription())
                .build();
        return categoryService.addBookToCategory(categoryId,book);
    }

    @MutationMapping(name = "removeBookFromCategory")
    public Category removeBookFromCategory(@Argument Long categoryId, @Argument("book") BookInput bookInput)
    {
        Author author=authorService.getSpecificAuthorFromDb(bookInput.getAuthorId());
        Book book= Book.builder()
                .pages(bookInput.getPages())
                .price(bookInput.getPrice())
                .title(bookInput.getTitle())
                .author(author)
                .description(bookInput.getDescription())
                .build();
        return categoryService.removeBookFromCategory(categoryId,book);
    }

@QueryMapping("getAllPaginatedCategories")
    public PageableCategoryOutput getAllPaginatedCategories(@Argument("pageableCategoryInput")PageableCategoryInput input)
    {
        int size=input.getSize();
        int page=input.getPage();
        String sortBy=input.getSortBy();
        boolean ascending=input.isAscending();
        Sort sort=ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Category> categories= categoryRepository.getAllPaginatedCategories(pageable);
        PageableCategoryOutput output= PageableCategoryOutput.builder()
                .categories(categories.stream().toList())
                .pageSize(categories.getSize())
                .pageNumber(categories.getNumber())
                .totalPages(categories.getTotalPages())
                .totalElements(categories.getTotalElements())
                .build();
        return output;
    }

    @QueryMapping("getBooksCountPerCategory")
    public List<BooksCountResponse> getBooksCountPerCategory()
    {
        List<Object[]> results= categoryRepository.getBooksCountPerPage();
        return results.stream().map(row-> new BooksCountResponse(((Number) row[0]).longValue(),(String) row[1])).collect(Collectors.toList());
    }

}

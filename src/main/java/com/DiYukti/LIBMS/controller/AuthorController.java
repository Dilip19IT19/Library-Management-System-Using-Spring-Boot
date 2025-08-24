package com.DiYukti.LIBMS.controller;

import com.DiYukti.LIBMS.dto.AuthorInput;
import com.DiYukti.LIBMS.dto.BookInput;
import com.DiYukti.LIBMS.entity.Author;
import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.entity.Category;
import com.DiYukti.LIBMS.service.AuthorService;
import com.DiYukti.LIBMS.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController
{
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @MutationMapping(name = "saveAuthor")
    public Author saveAuthor(@Argument("author") AuthorInput authorInput)
    {
        Author author=Author.builder()
                .name(authorInput.getName())
                .bio(authorInput.getBio())
                .build();
        return authorService.saveAuthorToDb(author);
    }

    @QueryMapping(name = "getAllAuthors")
    public List<Author> fetchAllAuthors()
    {
        return authorService.getAllAuthorsFromDb();
    }

    @QueryMapping(name = "getAuthorById")
    public Author fetchSpecificAuthorById(@Argument Long authorId)
    {
        return authorService.getSpecificAuthorFromDb(authorId);
    }

    @MutationMapping(name = "updateAuthor")
    public Author updateAuthor(@Argument("authorId") Long authorId, @Argument("author") AuthorInput authorInput)
    {
        Author author= Author.builder()
                .name(authorInput.getName())
                .bio(authorInput.getBio())
                .build();
        return authorService.updateAuthorFromDb(authorId,author);

    }

    @MutationMapping(name = "deleteAuthor")
    public boolean deleteAuthor(@Argument Long authorId)
    {
        return authorService.deleteAuthorFromDb(authorId);
    }

    @MutationMapping(name = "addBookToAuthor")
    public Author addBookToAuthor(@Argument("authorId") Long authorId, @Argument("book") BookInput bookInput)
    {
        Category category=categoryService.getSpecificCategoryFromDb(bookInput.getCategoryId());
        Book book=Book.builder()
                .pages(bookInput.getPages())
                .price(bookInput.getPrice())
                .title(bookInput.getTitle())
                .description(bookInput.getDescription())
                .category(category)
                .build();
        return authorService.enlistNewBookToAuthorProfile(authorId,book);
    }

    @MutationMapping(name = "removeBookFromAuthor")
    public Author removeBookFromAuthor(@Argument("authorId") Long authorId, @Argument("book") BookInput bookInput)
    {
        Category category=categoryService.getSpecificCategoryFromDb(bookInput.getCategoryId());
        Book book=Book.builder()
                .pages(bookInput.getPages())
                .price(bookInput.getPrice())
                .title(bookInput.getTitle())
                .description(bookInput.getDescription())
                .category(category)
                .build();
        return authorService.deListBookToAuthorProfile(authorId,book);
    }


}

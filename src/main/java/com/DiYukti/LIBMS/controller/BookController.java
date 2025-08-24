package com.DiYukti.LIBMS.controller;

import com.DiYukti.LIBMS.dto.BookInput;
import com.DiYukti.LIBMS.entity.Author;
import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.entity.Category;
import com.DiYukti.LIBMS.service.AuthorService;
import com.DiYukti.LIBMS.service.BookService;
import com.DiYukti.LIBMS.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @QueryMapping(name = "getAllBooks")
    public List<Book> fetchAllBooksFromDb()
    {
        return bookService.getAllBooksFromDB();
    }

    @QueryMapping(name = "getBookById")
    public Book fetchSpecificBookFromDb(@Argument Long bookId)
    {
        return bookService.getSpecificBook(bookId);
    }

    @MutationMapping(name = "saveBook")
    @Transactional
    public Book saveBookToDb(@Argument BookInput book)
    {
        Author author=authorService.getSpecificAuthorFromDb(book.getAuthorId());
        Category category=categoryService.getSpecificCategoryFromDb(book.getCategoryId());
        Book newBook=Book.builder()
                .pages(book.getPages())
                .price(book.getPrice())
                .title(book.getTitle())
                .category(category)
                .author(author)
                .description(book.getDescription())
                .build();
        return bookService.saveBookToDB(newBook);
    }

    @MutationMapping(name = "updateBook")
    @Transactional
    public Book updateBookById(@Argument("bookId") Long bookId, @Argument("book") BookInput bookInput)
    {

        Author author=authorService.getSpecificAuthorFromDb(bookInput.getAuthorId());
        Category category=categoryService.getSpecificCategoryFromDb(bookInput.getCategoryId());

        Book newBook=Book.builder()
                .pages(bookInput.getPages())
                .price(bookInput.getPrice())
                .title(bookInput.getTitle())
                .category(category)
                .author(author)
                .description(bookInput.getDescription())
                .build();
        return bookService.updateBookById(bookId,newBook);
    }

    @MutationMapping(name = "deleteBook")
    public boolean deleteBookFromDb(@Argument Long bookId)
    {
        return bookService.deleteBookByIdFromDb(bookId);

    }

}

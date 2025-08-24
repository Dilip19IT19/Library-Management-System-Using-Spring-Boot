package com.DiYukti.LIBMS.service;


import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;


    public Book saveBookToDB(Book book)
    {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooksFromDB()
    {
        return bookRepository.findAll();
    }

    public Book getSpecificBook(Long bookId)
    {
        return  bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("No book found with id: "+bookId));

    }

    @Transactional
    public Book updateBookById(Long bookId,Book newBook)
    {
        Book oldBook=bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("No book found with id: "+bookId));
        oldBook.setTitle(newBook.getTitle()!=null && !newBook.getTitle().isEmpty() ? newBook.getTitle() : oldBook.getTitle() );

        oldBook.setDescription( newBook.getDescription()!=null && !newBook.getDescription().isEmpty() ? newBook.getDescription() : oldBook.getDescription() );
        oldBook.setPrice( newBook.getPrice()!=null ? newBook.getPrice() : oldBook.getPrice() );

        return oldBook;
    }

    @Transactional
    public boolean deleteBookByIdFromDb(Long bookId)
    {
        Book oldBook=bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("No book found with id: "+bookId));
        try {
            bookRepository.deleteById(bookId);
            return true;
        }
        catch (Exception e)
        {
            log.error("Occured occured for {}: ",bookId);
            return false;
        }
    }

}
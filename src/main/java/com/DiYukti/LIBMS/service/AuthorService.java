package com.DiYukti.LIBMS.service;



import com.DiYukti.LIBMS.entity.Author;
import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class AuthorService
{
    private final AuthorRepository authorRepository;

    public Author saveAuthorToDb(Author author)
    {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthorsFromDb()
    {
        return authorRepository.findAll();
    }

    public Author getSpecificAuthorFromDb(Long authorId)
    {
        return authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("No author found with id: "+authorId));
    }

    @Transactional
    public Author enlistNewBookToAuthorProfile(Long authorId, Book book)
    {
        Author author=authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("No author found with id: "+authorId));
        author.getBooks().add(book);
        book.setAuthor(author);
        return author;
    }

    @Transactional
    public Author updateAuthorFromDb(Long authorId, Author newAuthor)
    {
        Author oldAuthor=authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("No author found with id: "+authorId));
        oldAuthor.setName( newAuthor.getName()!=null && !newAuthor.getName().isEmpty() ? newAuthor.getName(): oldAuthor.getName() );
        oldAuthor.setBio( newAuthor.getBio()!=null && !newAuthor.getBio().isEmpty() ? newAuthor.getBio(): oldAuthor.getBio() );
        return oldAuthor;
    }

    @Transactional
    public Author deListBookToAuthorProfile(Long authorId, Book book)
    {
        Author author=authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("No author found with id: "+authorId));
        if(author.getBooks().stream().filter((bk)->bk.getId()==book.getId()).findFirst().isPresent())
        {
            author.getBooks().remove(book);
        }
        return author;
    }

    @Transactional
    public Boolean deleteAuthorFromDb(Long authorId)
    {
        Author author=authorRepository.findById(authorId).orElseThrow(()-> new EntityNotFoundException("No author found with id: "+authorId));
        try
        {
            authorRepository.delete(author);
            return true;
        }
        catch (Exception e)
        {
            log.error("Error occurred while deleting author with id: {} ",authorId);
            log.error("Error : {}",e.getMessage());
            return  false;
        }

    }
}
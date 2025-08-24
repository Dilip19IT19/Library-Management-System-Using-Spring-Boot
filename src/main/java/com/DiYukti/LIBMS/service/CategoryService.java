package com.DiYukti.LIBMS.service;


import com.DiYukti.LIBMS.entity.Book;
import com.DiYukti.LIBMS.entity.Category;
import com.DiYukti.LIBMS.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public Category createCategoryToDb(Category category)
    {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategoriesFromDb()
    {
        return categoryRepository.findAll();
    }

    public Category getSpecificCategoryFromDb(Long categoryId)
    {
        return categoryRepository.findById(categoryId).orElseThrow(()->new EntityNotFoundException("No category found with id: "+categoryId));
    }

    @Transactional
    public Category updateCategoryFromDb(Long categoryId, Category newCategory)
    {
        Category oldCategory =categoryRepository.findById(categoryId).orElseThrow(()->new EntityNotFoundException("No category found with id: "+categoryId));
        oldCategory.setName(newCategory.getName()!=null && !newCategory.getName().isEmpty() ? newCategory.getName() : oldCategory.getName() );
        oldCategory.setDescription(newCategory.getDescription()!=null && !newCategory.getDescription().isEmpty() ? newCategory.getDescription() : oldCategory.getDescription() );
        return oldCategory;
    }

    @Transactional
    public Category addBookToCategory(Long categoryId, Book book)
    {
        Category category =categoryRepository.findById(categoryId).orElseThrow(()->new EntityNotFoundException("No category found with id: "+categoryId));
        category.getBooks().add(book);
        book.setCategory(category);
        return category;
    }

    @Transactional
    public Category removeBookFromCategory(Long categoryId, Book book)
    {
        Category category =categoryRepository.findById(categoryId).orElseThrow(()->new EntityNotFoundException("No category found with id: "+categoryId));
        if(category.getBooks().stream().filter((bk)->bk.getId()== book.getId()).findFirst().isPresent())
        {
            category.getBooks().remove(book);
        }
        else
        {
            log.info("No book having id : {} found in category id {}", book.getId(),categoryId);
        }
        return  category;
    }

    public boolean deleteCategoryFromDb(Long categoryId)
    {
        try
        {
            categoryRepository.deleteById(categoryId);
            return true;
        }
        catch (Exception e)
        {
            log.error("Error occurred while deleting category id: {}",categoryId);
            log.error(e.getMessage());
            return false;
        }

    }
}

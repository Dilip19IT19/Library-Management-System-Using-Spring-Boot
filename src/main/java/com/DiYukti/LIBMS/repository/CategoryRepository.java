package com.DiYukti.LIBMS.repository;

import com.DiYukti.LIBMS.dto.BooksCountResponse;
import com.DiYukti.LIBMS.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category, Long>
{
    @Query(value = "select * from category",nativeQuery = true)
    Page<Category> getAllPaginatedCategories(Pageable pageable);
    @Query(
            value = "SELECT COUNT(b.title) AS count, c.name AS name FROM category c LEFT JOIN book b ON c.id = b.category_id GROUP BY c.name",
            nativeQuery = true
    )
    List<Object[]> getBooksCountPerPage();

}
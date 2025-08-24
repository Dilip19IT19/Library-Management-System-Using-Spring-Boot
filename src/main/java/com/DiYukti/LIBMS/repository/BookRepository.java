package com.DiYukti.LIBMS.repository;

import com.DiYukti.LIBMS.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
package com.main.book;

import com.main.schema.BookEntity;
import com.main.schema.FavoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;
    private FavoRepository favoRepository;
    private EntityManager entityManager;
    public BookServiceImpl(BookRepository bookRepository,
                           FavoRepository favoRepository
    )
    {
        this.favoRepository=favoRepository;
        this.bookRepository=bookRepository;
    }



    @Override
    public BookEntity addBook(BookEntity book) {
        return bookRepository.save(book);
    }
    @Override
    public BookEntity deleteBook(Integer id) {
        BookEntity book=bookRepository.findById(id).orElse(null);
        bookRepository.deleteById(id);
        return book;
    }
    @Override
    public List<BookEntity> findBookAll() {
        return bookRepository.findAll();
    }
    @Override
    public BookEntity findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Override
    public Page<BookEntity> findBookPaginated(int pageNumber, int pageSize) {
//        pageNumber = 1;
//        pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return bookRepository.findAll(pageable);
    }



    @Override
    public FavoEntity addFavo(FavoEntity favo) {
        return favoRepository.save(favo);
    }
    @Override
    public FavoEntity deleteFavo(Integer id) {
        FavoEntity favo=favoRepository.findById(id).orElse(null);
        favoRepository.deleteById(id);
        return favo;
    }

    @Override
    public List<FavoEntity> findFavoAll() {
        return favoRepository.findAll();
    }
    @Override
    public Page<FavoEntity> findFavoPaginated(int pageNumber, int pageSize) {
//        pageNumber = 1;
//        pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return favoRepository.findAll(pageable);
    }



}

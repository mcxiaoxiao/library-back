package com.main.book;
import com.main.schema.BookEntity;
import com.main.schema.FavoEntity;
import org.springframework.data.domain.Page;
import java.util.List;

public interface BookService {
    BookEntity addBook(BookEntity book);
    BookEntity deleteBook(Integer id);


    //查询相关
    BookEntity findBookById(int id);
    List<BookEntity> findBookAll();
    Page<BookEntity> findBookPaginated(int pageNumber, int pageSize);


    FavoEntity addFavo(FavoEntity book);
    FavoEntity deleteFavo(Integer id);

    List<FavoEntity> findFavoAll();
    Page<FavoEntity> findFavoPaginated(int pageNumber, int pageSize);

}

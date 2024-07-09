package com.main.book;

import com.main.schema.BookEntity;
import com.main.schema.FavoEntity;
import com.main.schema.PagesBookEntity;
import com.main.schema.PagesFavoEntity;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import javax.annotation.Resource;
@DgsComponent
public class BookResolver {
    @Resource
    private BookService bookService;
    @DgsQuery
    public PagesBookEntity findBookAll(@InputArgument Integer pageNumber, @InputArgument Integer pageSize) {
        PagesBookEntity p = new PagesBookEntity();
        p.list = bookService.findBookPaginated(pageNumber,pageSize).getContent();
        p.totalCount = bookService.findBookAll().size();
        return p;
    }
    @DgsQuery
    public BookEntity findBookById(@InputArgument Integer id) {
        return bookService.findBookById(id);
    }
    @DgsMutation
    public BookEntity addBook(@InputArgument BookEntity book) {
        return bookService.addBook(book);
    }
    @DgsMutation
    public BookEntity deleteBook(@InputArgument Integer id) {
        return bookService.deleteBook(id);
    }



    @DgsQuery
    public PagesFavoEntity findFavoAll(@InputArgument Integer pageNumber, @InputArgument Integer pageSize) {
        PagesFavoEntity p = new PagesFavoEntity();
        p.list = bookService.findFavoPaginated(pageNumber,pageSize).getContent();
        p.totalCount = bookService.findFavoAll().size();
        return p;
    }

    @DgsMutation
    public FavoEntity addFavo(@InputArgument FavoEntity favo) {
        return bookService.addFavo(favo);
    }
    @DgsMutation
    public FavoEntity deleteFavo(@InputArgument Integer id) {
        return bookService.deleteFavo(id);
    }



}



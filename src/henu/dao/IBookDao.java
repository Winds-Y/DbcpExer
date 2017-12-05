package henu.dao;

import henu.bean.BookBean;

import java.util.List;

/**
 * User: Yangtse
 * Date: 2017/11/20
 * Time: 17:40
 */
public interface IBookDao {
    List<BookBean>findAll();
    boolean findItem(String bookName,String bookPublisher);
    void update(String bookName,String bookPublisher,int number);
    void delete(String bookName,String bookPublisher);
}

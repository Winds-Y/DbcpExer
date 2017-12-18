package henu.dao.impl;

import henu.bean.BookBean;
import henu.dao.IBookDao;
import henu.util.DbcpPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Yangtse
 * Date: 2017/12/4
 * Time: 20:04
 */
public class BookDaoImp implements IBookDao {
    private String sql;
    private ResultSet resultSet;
    @Override
    public List<BookBean> findAll() {
        List<BookBean>list=new ArrayList<>();
        sql="select * from bookinfo";
        DbcpPool.initDBConn();
        try {
            DbcpPool.setSql(sql);
            resultSet=DbcpPool.executeQuery();
            while (resultSet.next()){
                BookBean bookBean=new BookBean();
                bookBean.setBookName(resultSet.getString(BookBean.BOOKNAME));
                bookBean.setBookPrice(resultSet.getDouble(BookBean.BOOKPRICE));
                bookBean.setBookAuthor(resultSet.getString(BookBean.BOOKAUTHOR));
                bookBean.setBookPublisher(resultSet.getString(BookBean.BOOKPUBLISHER));
                bookBean.setBookNumber(resultSet.getInt(BookBean.BOOKNUMBER));
                list.add(bookBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
        return list;
    }

    @Override
    public boolean findItem(String bookName, String bookPublisher) {
        boolean isExist=false;
        DbcpPool.initDBConn();
        sql="select * from bookinfo where "+BookBean.BOOKNAME+" =? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setString(1,bookName);
            DbcpPool.setString(2,bookPublisher);
            isExist=DbcpPool.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
        return isExist;
    }

    @Override
    public void update(String bookName, String bookPublisher, int number) {
        DbcpPool.initDBConn();
        sql="update bookinfo set "+BookBean.BOOKNUMBER+"=? where "+BookBean.BOOKNAME+"=? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setInt(1,number);
            DbcpPool.setString(2,bookName);
            DbcpPool.setString(3,bookPublisher);
            DbcpPool.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
    }

    @Override
    public void delete(String bookName, String bookPublisher) {
        DbcpPool.initDBConn();
        sql="delete from bookinfo where "+BookBean.BOOKNAME+"=? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setString(1,bookName);
            DbcpPool.setString(2,bookPublisher);
            DbcpPool.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
    }

    @Override
    public void add(BookBean newBook) {
        DbcpPool.initDBConn();
        sql="insert into bookinfo (" +
                BookBean.BOOKNAME+","+
                BookBean.BOOKPRICE+","+
                BookBean.BOOKAUTHOR+","+
                BookBean.BOOKPUBLISHER+","+
                BookBean.BOOKNUMBER+
                ") values(?,?,?,?,?)";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setString(1,newBook.getBookName());
            DbcpPool.setDouble(2,newBook.getBookPrice());
            DbcpPool.setString(3,newBook.getBookAuthor());
            DbcpPool.setString(4,newBook.getBookPublisher());
            DbcpPool.setInt(5,newBook.getBookNumber());
            DbcpPool.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
    }

}

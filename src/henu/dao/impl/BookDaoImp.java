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
        BookBean bookBean=new BookBean();
        DbcpPool.initDBconn();
        try {
            DbcpPool.setSql(sql);
            resultSet=DbcpPool.executeQuery();
            while (resultSet.next()){
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
        DbcpPool.initDBconn();
        sql="select * from bookinfo where "+BookBean.BOOKNAME+" =? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.cbsetString(1,bookName);
            DbcpPool.cbsetString(2,bookPublisher);
            isExist=DbcpPool.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
        return isExist;
    }

    @Override
    public void update(String bookName, String bookPublisher, int number) {
        DbcpPool.initDBconn();
        sql="update bookinfo set "+BookBean.BOOKNUMBER+"=? where "+BookBean.BOOKNAME+"=? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.cbsetInt(1,number);
            DbcpPool.cbsetString(2,bookName);
            DbcpPool.cbsetString(3,bookPublisher);
            DbcpPool.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
    }

    @Override
    public void delete(String bookName, String bookPublisher) {
        DbcpPool.initDBconn();
        sql="delete from bookinfo where "+BookBean.BOOKNAME+"=? and "+BookBean.BOOKPUBLISHER+"=?";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.cbsetString(1,bookName);
            DbcpPool.cbsetString(2,bookPublisher);
            DbcpPool.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
    }

}

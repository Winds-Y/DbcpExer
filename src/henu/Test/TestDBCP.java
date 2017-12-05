package henu.Test;

import henu.bean.BookBean;
import henu.factory.DaoFactory;
import henu.util.DbcpPool;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Yangtse
 * Date: 2017/12/4
 * Time: 17:06
 */
public class TestDBCP {
    public static void main(String[] args){
        search();
    }
    static void search(){
        List<BookBean> bookList= DaoFactory.getBookDaoInstance().findAll();
        for(BookBean bookBean:bookList){
            System.out.println(bookBean.getBookName());
        }
    }
    public static void add(){
        DbcpPool.initDBconn();
        String sql="insert into bookinfo ("+ BookBean.BOOKNAME+","+
                BookBean.BOOKPRICE+","+
                BookBean.BOOKAUTHOR+","+
                BookBean.BOOKPUBLISHER+","+
                BookBean.BOOKNUMBER+")values (?,?,?,?,?)";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.cbsetString(1,"安徒生童话");
            DbcpPool.cbsetDouble(2,20.9);
            DbcpPool.cbsetString(3,"安徒生");
            DbcpPool.cbsetString(4,"人民出版社");
            DbcpPool.cbsetInt(5,1000);
            DbcpPool.executeUpdate();
            DbcpPool.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

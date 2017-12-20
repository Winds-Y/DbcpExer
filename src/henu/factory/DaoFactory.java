package henu.factory;

import henu.dao.IBookDao;
import henu.dao.IUser;
import henu.dao.impl.BookDaoImp;
import henu.dao.impl.UserDaoImp;

/**
 * User: Yangtse
 * Date: 2017/12/4
 * Time: 20:06
 */
public class DaoFactory {
    public static IBookDao getBookDaoInstance(){
        return new BookDaoImp();
    }
    public static IUser getUserDaoInstance(){
        return new UserDaoImp();
    }
}

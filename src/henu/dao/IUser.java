package henu.dao;

/**
 * User: Yangtse
 * Date: 2017/12/19
 * Time: 9:29
 */
public interface IUser {
    boolean userRegister(String userName,String password);
    String userLogin(String userName,String password);
}

package henu.dao.impl;

import com.sun.deploy.net.proxy.WDefaultBrowserProxyConfig;
import henu.dao.IUser;
import henu.util.DBstrs;
import henu.util.DbcpPool;
import henu.util.ParameterName;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Yangtse
 * Date: 2017/12/19
 * Time: 9:31
 */
public class UserDaoImp implements IUser {
    private String sql;
    @Override
    public boolean userRegister(String userName, String password) {
        DbcpPool.initDBConn();
        boolean isSuccess;
        sql="insert into "+ DBstrs.USER+"(" +
                DBstrs.USERNAME+","+
                DBstrs.USERPASSWORD+") values (?,?)";
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setString(1,userName);
            DbcpPool.setString(2,password);
            DbcpPool.executeUpdate();
            isSuccess=true;
        } catch (SQLException e) {
            e.printStackTrace();
            isSuccess=false;
        }
        DbcpPool.close();
        return isSuccess;
    }

    @Override
    public String userLogin(String userName, String password) {
        String loginStatus = null;
        boolean isSuccess=false;
        sql="select * from "+DBstrs.USER+" where "+DBstrs.USERNAME+"=?";
        DbcpPool.initDBConn();
        try {
            DbcpPool.setSql(sql);
            DbcpPool.setString(1,userName);
            ResultSet resultSet=DbcpPool.executeQuery();
            while (resultSet.next()){
                isSuccess=true;
                if(password.equals(resultSet.getString(DBstrs.USERPASSWORD)))
                    loginStatus= ParameterName.LOGINSUCCESS;
                else
                    loginStatus=ParameterName.LOGINPASSWORDWRONG;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbcpPool.close();
        if(!isSuccess) loginStatus=ParameterName.USERNOTEXIST;
        return loginStatus;
    }
}

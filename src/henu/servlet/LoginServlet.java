package henu.servlet;

import henu.dao.IUser;
import henu.factory.DaoFactory;
import henu.util.ParameterName;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Yangtse
 * Date: 2017/12/19
 * Time: 9:56
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUser iUser= DaoFactory.getUserDaoInstance();
        String userName=request.getParameter(ParameterName.USERNAME);
        String password=request.getParameter(ParameterName.PASSWORD);
        String loginStatus=iUser.userLogin(userName,password);
        if(ParameterName.LOGINSUCCESS.equals(loginStatus))
            request.getRequestDispatcher("/views/book.jsp").forward(request,response);
        else
            request.getRequestDispatcher("/views/loginError.jsp?"+ParameterName.loginStatus +"="+loginStatus)
                    .forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}

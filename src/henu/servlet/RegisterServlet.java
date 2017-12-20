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
 * Time: 9:21
 */
@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUser iUser= DaoFactory.getUserDaoInstance();
        String userName=request.getParameter(ParameterName.USERNAME);
        String password=request.getParameter(ParameterName.PASSWORD);
        if(iUser.userRegister(userName,password))
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        else
            request.getRequestDispatcher("views/register.jsp?"+ParameterName.REGISTERSTATUS+"="+ParameterName.REGISTERFAILED)
            .forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

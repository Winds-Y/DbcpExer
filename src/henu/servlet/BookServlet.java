package henu.servlet;

import henu.bean.BookBean;
import henu.dao.IBookDao;
import henu.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * User: Yangtse
 * Date: 2017/11/20
 * Time: 18:48
 */
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String bookName= (String) session.getAttribute(BookBean.BOOKNAME);
        double bookPrice=(double)session.getAttribute(BookBean.BOOKPRICE);
        String bookAuthor=(String)session.getAttribute(BookBean.BOOKAUTHOR);
        String bookPublisher=(String)session.getAttribute(BookBean.BOOKPUBLISHER);
        String strModifyNumber=request.getParameter("modifyNumber");
        String operation=request.getParameter("operation");
        int number=Integer.parseInt(strModifyNumber);
        IBookDao iBookDao=DaoFactory.getBookDaoInstance();
        if(operation!=null && operation.equals("修改")){
            if(iBookDao.findItem(bookName,bookPublisher)){
                iBookDao.update(bookName,bookPublisher,number);
            }
        }else if(operation!=null && operation.equals("删除")){
            if(iBookDao.findItem(bookName,bookPublisher))
                iBookDao.delete(bookName,bookPublisher);
        }
        System.out.println(bookName+" "+bookPrice+" "+bookAuthor+" "+bookPublisher+" "+strModifyNumber+" "+operation);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

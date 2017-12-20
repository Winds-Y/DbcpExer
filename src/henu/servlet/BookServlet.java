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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        IBookDao iBookDao=DaoFactory.getBookDaoInstance();
        String operationModify=request.getParameter("operationModify");
        String operationDelete=request.getParameter("operationDelete");
//        String operationDelete=(String) request.getAttribute("operationDelete");
        String operationAdd=request.getParameter("operationAdd");
        System.out.println("operationModify is :"+operationModify);
        System.out.println("operationDelete is :"+operationDelete);
        System.out.println("operationAdd is :"+operationAdd);
        if("修改".equals(operationModify)){
            String bookName= (String) session.getAttribute(BookBean.BOOKNAME);
            String bookPublisher=(String)session.getAttribute(BookBean.BOOKPUBLISHER);
            String strModifyNumber=request.getParameter("modifyNumber");
            int number=-1;
            try {
                number=Integer.parseInt(strModifyNumber);
            }catch (Exception e){
                System.out.println("Integer parse failed");
                e.printStackTrace();
            }
            if(iBookDao.findItem(bookName,bookPublisher))
                iBookDao.update(bookName,bookPublisher,number);
        }else if("添加".equals(operationAdd)){
            String addBookName=request.getParameter("addBookName");
            String addBookPrice=request.getParameter("addBookPrice");
            String addBookAuthor=request.getParameter("addBookAuthor");
            String addBookPublisher=request.getParameter("addBookPublisher");
            String addBookNumber=request.getParameter("addBookNumber");

            System.out.println(addBookName+" "+addBookPrice+" "+addBookAuthor+" "+addBookPublisher+" "+addBookNumber);

            double C_addBookPrice=Double.parseDouble(addBookPrice);
            int C_addBookNumber=Integer.parseInt(addBookNumber);

            BookBean newBook=new BookBean();
            newBook.setBookName(addBookName);
            newBook.setBookPrice(C_addBookPrice);
            newBook.setBookAuthor(addBookAuthor);
            newBook.setBookPublisher(addBookPublisher);
            newBook.setBookNumber(C_addBookNumber);
            iBookDao.add(newBook);
        }else if("删除".equals(operationDelete)){
            String bookName= (String) session.getAttribute(BookBean.BOOKNAME);
            String bookPublisher=(String)session.getAttribute(BookBean.BOOKPUBLISHER);
            if(iBookDao.findItem(bookName,bookPublisher))
                iBookDao.delete(bookName,bookPublisher);
        }
        try {
            request.getRequestDispatcher("/views/book.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("dispatch is wrong");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}

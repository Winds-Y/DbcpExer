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
import java.util.List;

/**
 * User: Yangtse
 * Date: 2017/11/20
 * Time: 18:48
 */
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        List<BookBean>bookList= (List<BookBean>) session.getAttribute("bookList");
        IBookDao iBookDao=DaoFactory.getBookDaoInstance();
        String operationModify=request.getParameter("operationModify");
        String operationDelete=request.getParameter("operationDelete");
        String operationAdd=request.getParameter("operationAdd");
        System.out.println("operationModify is :"+operationModify);
        System.out.println("operationDelete is :"+operationDelete);
        System.out.println("operationAdd is :"+operationAdd);
        if("修改".equals(operationModify)){
            System.out.println("now execute modify..............");
            int rowIndex=Integer.parseInt(request.getParameter("rowIndex"))-1;
            BookBean bookBean=bookList.get(rowIndex);
            System.out.println(String.format("rowIndex is:%s,bookName is:%s",rowIndex,bookList.get(rowIndex).getBookName()));
            String bookName= bookBean.getBookName();
            String bookPublisher=bookBean.getBookPublisher();
            String strModifyNumber=request.getParameter("modifyTrueNum");
            System.out.println(String.format("strModifyNumber is:%s",strModifyNumber));
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
            System.out.println("now execute add................");

            String addBookName=request.getParameter("addBookName");
            String addBookPrice=request.getParameter("addBookPrice");
            String addBookAuthor=request.getParameter("addBookAuthor");
            String addBookPublisher=request.getParameter("addBookPublisher");
            String addBookNumber=request.getParameter("addBookNumber");

            System.out.println(addBookName+" "+addBookPrice+" "+addBookAuthor+" "+addBookPublisher+" "+addBookNumber);
            double C_addBookPrice = 0;
            int C_addBookNumber = 0;
            try{
                C_addBookPrice=Double.parseDouble(addBookPrice);
                C_addBookNumber=Integer.parseInt(addBookNumber);
            }catch (Exception e){
                System.out.println("parse is wrong");
            }
            BookBean newBook=new BookBean();
            newBook.setBookName(addBookName);
            newBook.setBookPrice(C_addBookPrice);
            newBook.setBookAuthor(addBookAuthor);
            newBook.setBookPublisher(addBookPublisher);
            newBook.setBookNumber(C_addBookNumber);
            iBookDao.add(newBook);
        }else if("删除".equals(operationDelete)){
            System.out.println("now execute delete................");
            int rowIndex=Integer.parseInt(request.getParameter("rowIndex"))-1;
            BookBean bookBean=bookList.get(rowIndex);
            System.out.println(String.format("rowIndex is:%s,bookName is:%s",rowIndex,bookList.get(rowIndex).getBookName()));
            String bookName= bookBean.getBookName();
            String bookPublisher=bookBean.getBookPublisher();
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

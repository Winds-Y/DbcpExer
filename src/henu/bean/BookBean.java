package henu.bean;

/**
 * User: Yangtse
 * Date: 2017/11/20
 * Time: 18:45
 */
public class BookBean {
    public static final String BOOKNAME="name";
    public static final String BOOKPRICE="price";
    public static final String BOOKAUTHOR="author";
    public static final String BOOKPUBLISHER="publisher";
    public static final String BOOKNUMBER="number";
    private String bookName;
    private double bookPrice;
    private String bookAuthor;
    private String bookPublisher;
    private int bookNumber;

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }


    public BookBean(){}
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

}

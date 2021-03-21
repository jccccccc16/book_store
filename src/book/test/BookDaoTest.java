package book.test;

import book.dao.BookDao;
import book.dao.impl.BookDapImpl;
import book.pojo.Book;
import book.pojo.Page;
import book.pojo.User;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\  =  /O
 * ____/`---'\____
 * .'  \\|     |//  `.
 * /  \\|||  :  |||//  \
 * /  _||||| -:- |||||-  \
 * |   | \\\  -  /// |   |
 * | \_|  ''\---/''  |   |
 * \  .-\__  `-`  ___/-. /
 * ___`. .'  /--.--\  `. . __
 * ."" '<  `.___\_<|>_/___.'  >'"".
 * | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * \  \ `-.   \_ __\ /__ _/   .-` /  /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * 佛祖保佑        永无BUG
 *
 * @author ：jccccccc
 * @date ：Created in 2020/4/5 10:42
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDapImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"语文","季羡林",new BigDecimal(18.9),100,20,null));

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(1,"java从入门到放弃","陈家祠",new BigDecimal(18.2),12,6,null));
    }

    @Test
    public void queryBookById() {

       Book book = bookDao.queryBookById(1);
        System.out.println(book.toString());
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book book:books){
            System.out.println(book.toString());
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for(Book book:bookDao.queryForItems(8, Page.getPageSize())){
            System.out.println(book.toString());
        }
    }


    @Test
    public void queryForPageTotalCountByPrice() {

        bookDao.queryForPageTotalCountByPrice(1,3);

    }

    @Test
    public void queryForItemsByPrice() {
        List<Book> books = bookDao.queryForItemsByPrice(0, 4, 1, 10000);
        for(Book book:books){
            System.out.println(book.toString());
        }



    }

}
package book.test;

import book.pojo.Book;
import book.pojo.Page;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
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
 * @date ：Created in 2020/4/5 11:10
 */
public class BookServiceImplTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"数学","陈家祠",new BigDecimal(18),15,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(25,"选学","陈家祠",new BigDecimal(18),18, 18,null));

    }

    @Test
    public void queryBookById() {
        bookService.queryBookById(21);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for(Book book:books){
            System.out.println(book.toString());
        }
    }

    @Test
    public void page(){
        Page<Book> page = bookService.page(1, 4);
        for(Book book:page.getItems()){
            System.out.println(book.toString());
        }
    }
    @Test
    public void pageByPrice(){
        Page<Book> bookPage = bookService.pageByPrice(1, 4, 0, 100);
        for(Book book:bookPage.getItems()){
            System.out.println(book.toString());
        }
    }



}
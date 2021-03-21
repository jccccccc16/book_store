package book.web;

import book.pojo.Book;
import book.pojo.Page;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
 * @date ：Created in 2020/4/8 16:39
 */
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取pageNo,和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.getPageSize());
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        //2调用Page
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder url = new StringBuilder("clientBookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){

            url.append("&min=").append(min);
        }
        if(req.getParameter("max")!=null){
            url.append("&max=").append(max);
        }
        //3保存到request
        for(Book book:page.getItems()){
            System.out.println(book.toString());
        }
        page.setUrl(url.toString());
        req.setAttribute("page",page);
        //4请求转发
        req.getRequestDispatcher("/pages/index/main.jsp").forward(req,resp);


    }


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取pageNo,和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.getPageSize());
        //2调用Page
        Page<Book> page=bookService.page(pageNo,pageSize);
        //3保存到request
        page.setUrl("clientBookServlet?action=page");
        req.setAttribute("page",page);
        //4请求转发
        req.getRequestDispatcher("/pages/index/main.jsp").forward(req,resp);

    }

}
package book.web;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
 * @date ：Created in 2020/3/21 12:00
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        //获取表单中的用户名
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println(req.getRequestURL());
        //判断用户名是否存在
        if(userService.existsUsername(username)){
            String referer = req.getHeader("Referer");
            req.setAttribute("msg","用户名已存在");
            System.out.println("存在");

           req.getRequestDispatcher(referer).forward(req,resp);
        }else{
            //如果不存在，表示可用,那么注册
            String password = String.valueOf(req.getParameter("password"));
            String email = String.valueOf(req.getParameter("email"));
            User user = new User(null,username,password,email);
            userService.registUser(user);
            System.out.println("注册成功");
            resp.sendRedirect("/book/pages/login.jsp");
        }








    }
}

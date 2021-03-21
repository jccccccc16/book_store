package book.web;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * @date ：Created in 2020/4/13 15:05
 */
public class AjaxServlet extends BaseServlet{

    UserService userService = new UserServiceImpl();

    protected void ajax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User(1,"陈家祠","123","617@qq.com");
        Gson gson = new Gson();
        String toJson = gson.toJson(user);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(toJson);


    }


    protected void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("这是getJson方法");

    }


    protected void serialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("username"));


    }


    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        boolean existsUsername = userService.existsUsername(username);
        System.out.println(existsUsername);
        Gson gson = new Gson();
        Map<String ,Object> result = new HashMap<>();
        result.put("existsUsername",existsUsername);
        String s = gson.toJson(result);
        resp.getWriter().write(s);


    }
}

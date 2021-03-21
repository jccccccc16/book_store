package book.web;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;
import book.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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
 * @date ：Created in 2020/4/4 15:05
 */
public class UserServlet extends BaseServlet {




    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
       /* String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        UserService userService = new UserServiceImpl();*/
        //判断验证码是否正确
        String code = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        String inputCode = req.getParameter("code");
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        boolean isChecked = WebUtils.codeCheck(code,inputCode);
        UserService userService = new UserServiceImpl();
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        if(isChecked){

            if(userService.login(user)==null){
                System.out.println("跳转到之前的页面");
                req.setAttribute("msg","密码或账号错误");
                req.setAttribute("username",user.getUsername());
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            }else{
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                Cookie cookie = new Cookie("username",user.getUsername());
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);
                req.getRequestDispatcher("/").forward(req,resp);

            }
        }else{
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }



    }


    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 注册业务
         */

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
            /*
            String password = String.valueOf(req.getParameter("password"));
            String email = String.valueOf(req.getParameter("email"));
            User user = new User(null,username,password,email);*/

            try {
                //自定义一个工具类
                User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
                userService.registUser(user);
                System.out.println(user.toString());
                System.out.println("注册成功");
            } catch (Exception e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath());


    }


}

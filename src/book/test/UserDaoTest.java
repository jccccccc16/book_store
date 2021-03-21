package book.test;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.pojo.User;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Test;

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
 * @date ：Created in 2020/3/19 18:47
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDaoImpl userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("cjc")==null){
            System.out.println("ke yong");
        }else{
            System.out.println("bukeyong");
        }


    }

    @Test
    public void saveUser() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("617028197@qq.com");
        user.setUsername("cjc");
        user.setPassword("cjc123");
        int i = userDao.saveUser(user);
        System.out.println(i);

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsernameAndPassword("cjc1316","123456789");
        if(user==null){
            System.out.println("找不到");

        }else{
            System.out.println("找到了");
        }
    }
}
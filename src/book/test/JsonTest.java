package book.test;

import book.pojo.Book;
import book.pojo.User;
import com.google.gson.Gson;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
 * @date ：Created in 2020/4/13 11:07
 */
public class JsonTest {

    @Test
    public void test1(){
        User user = new User(1,"cjc","123","123");
        Gson gson = new Gson();
        String userString = gson.toJson(user);
        System.out.println(userString);
        User user1 = gson.fromJson(userString, User.class);
        System.out.println(user1.toString());

    }

    @Test
    public void test2() {

        List<User> personList = new ArrayList<>();
        personList.add(new User(1,"cjc","123","123"));
        personList.add(new User(2,"cjc","123","456"));
        Gson gson = new Gson();
        String s = gson.toJson(personList);
        System.out.println(s);


    }



}

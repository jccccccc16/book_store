package book.test;

import book.pojo.Cart;
import book.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

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
 * @date ：Created in 2020/4/11 20:46
 */
public class CartTest {

    @Test
    public void addItem() {

        Cart cart = new Cart();
        CartItem cartItem = new CartItem(1,"算法设计",1,new BigDecimal(16),new BigDecimal(16));
        cart.addItem(cartItem);
        System.out.println(cart.toString());

    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        CartItem cartItem = new CartItem(1,"算法设计",1,new BigDecimal(16),new BigDecimal(16));
        cart.addItem(cartItem);
        cart.deleteItem(1);
        System.out.println(cart.toString());
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        CartItem cartItem = new CartItem(1,"算法设计",1,new BigDecimal(16),new BigDecimal(16));
        cart.addItem(cartItem);
        cart.clear();
        System.out.println(cart.toString());
    }

    @Test
    public void updateCount() {
    }

    @Test
    public void getTotalCount() {
    }

    @Test
    public void getTotalPrice() {
    }

    @Test
    public void getItems() {
    }

    @Test
    public void setItems() {
    }
}
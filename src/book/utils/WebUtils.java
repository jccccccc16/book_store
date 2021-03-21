package book.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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
 * @date ：Created in 2020/4/4 16:22
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean)  {
        try {

            BeanUtils.populate(bean,value);

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }

        return bean;

    }
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        }catch (Exception e){

        }
        return defaultValue;

    }

    public static  boolean codeCheck(String code,String inputCode){
        if(inputCode !=null){
            if(inputCode.equals(code)){
                return true;
            }
        }
        return false;
    }


}

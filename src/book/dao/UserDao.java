package book.dao;

import book.pojo.User;

/**
 * 佛祖保佑        永无BUG
 *
 * @author ：jccccccc
 * @date ：Created in 2020/3/19 18:32
 */
public interface UserDao{

    /*
    * @return if return null,User doesnt exist
    *
    * */

    public User queryUserByUsername(String username);
    public int saveUser(User user);
    public User queryUserByUsernameAndPassword(String username,String password);




}

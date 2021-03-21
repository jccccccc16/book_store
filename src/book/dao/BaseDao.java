package book.dao;

import book.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ：jccccccc
 * @date ：Created in 2020/3/19 16:09
 */
//yongjiucheng
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /*
     * update() use to run insert/update/delete
     *@return if return -1,it means raising error
     * */

    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<>(type), args);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /*
    *
    * @return list that is to say return the many lie
    *
    * */

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {

        Connection connection = JdbcUtils.getConnection();
        try{
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }


    public Object queryForSingleValue(String sql,Object ...args){


        Connection connection = JdbcUtils.getConnection();
        try{
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;




    }




}

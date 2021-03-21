package book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**

 * @author ：jccccccc
 * @date ：Created in 2020/3/19 15:29
 */


public class JdbcUtils {

    private static DruidDataSource dataSource;

   static{

       Properties properties = new Properties();
       InputStream inputStream =JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
       try {
           properties.load(inputStream);
           dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
           System.out.println(dataSource.getConnection());
       } catch (IOException e) {
           e.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }




   }

    public static void main(String[] args) {

    }

   public static Connection getConnection() {
       Connection conn = null;
       try {
           conn = dataSource.getConnection();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return conn;

   }

   public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }



}

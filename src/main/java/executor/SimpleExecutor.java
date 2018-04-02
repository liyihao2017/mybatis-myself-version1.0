package executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Test;

/**
 * @author eason.li
 *
 */
public class SimpleExecutor implements Executor{


    @Override
    public <T> T query(String statement, String pamameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "920905");
            //3.获得statement
            String sql = String.format(statement, Integer.parseInt(pamameters));
            preparedStatement = connection.prepareStatement(sql);
            //4.获得结果集
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setName(rs.getString(2));
                test.setAge(rs.getInt(3));
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭连接
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        
        return (T)test;
    }
    
}

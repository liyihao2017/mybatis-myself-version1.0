package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import config.MyConfiguration;
import session.MySqlsession;

/**
 * @author eason.li
 *
 */
public class MyProxy implements InvocationHandler{
    
    private MySqlsession sqlsession;
    
    public MyProxy(MySqlsession sqlsession) {
        this.sqlsession = sqlsession;
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(MyConfiguration.namespace)) {
            String sql = MyConfiguration.methodSqlMapping.get(method.getName());
            return sqlsession.selectOne(sql,String.valueOf(args[0]));
        }
        
        return method.invoke(this, args);
    }

}

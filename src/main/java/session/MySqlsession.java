package session;


import config.MyConfiguration;
import executor.Executor;

/**
 * @author eason.li
 *
 */
public class MySqlsession {
    private MyConfiguration configuration;
    private Executor executor;
    
    public MySqlsession(MyConfiguration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
    
    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz,this);
    }
    
    public <T> T selectOne(String statement,String pamameters) {
        return executor.query(statement,pamameters);
    }
    
    
}

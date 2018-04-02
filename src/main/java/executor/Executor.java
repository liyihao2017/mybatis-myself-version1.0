package executor;


/**
 * @author eason.li
 *
 */
public interface Executor {
    <T> T query(String statement,String pamameters);
}

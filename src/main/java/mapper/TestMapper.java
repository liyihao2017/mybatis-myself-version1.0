/**
 * The contents of this file are copyright (c) 2017 by medavis GmbH, Karlsruhe, Germany
 */
package mapper;

import entity.Test;

/**
 * @author eason.li
 *
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}

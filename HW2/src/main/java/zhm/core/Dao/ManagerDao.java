package zhm.core.Dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zhm.core.domain.Manager;

@Repository("managerDao")
public interface ManagerDao {

//     只能是1 所有可以直接count(*)
    @Select("select count(*) " +
            "from Manager " +
            "where username=#{username} and password=#{password}")
    boolean existManager(Manager manager);
}

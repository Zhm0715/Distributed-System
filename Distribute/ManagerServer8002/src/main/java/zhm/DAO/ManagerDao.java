package zhm.DAO;

import domain.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface ManagerDao {

    @Select("select count(*) " +
            "from Manager " +
            "where username=#{username} and password=#{password}")
    boolean existManager(Manager manager);

}

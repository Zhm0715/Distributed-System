package zhm.DAO;

import domain.Baggage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Mapper
public interface BaggageDao {

    @Select("select * from Baggage")
    List<Baggage> getAllList();

}

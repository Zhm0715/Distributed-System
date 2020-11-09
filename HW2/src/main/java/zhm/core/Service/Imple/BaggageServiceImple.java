package zhm.core.Service.Imple;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import zhm.core.Dao.BaggageDao;
import zhm.core.Service.BaggageService;
import zhm.core.domain.Baggage;

import java.util.List;

public class BaggageServiceImple implements BaggageService {

    @Qualifier("baggageDao")
    @Autowired
    private BaggageDao baggageDao;

    @Override
    public void AddBaggage(Baggage baggage) {
        this.baggageDao.Add(baggage);
    }

    @Override
    public List<Baggage> FlushBaggage(){
        return this.baggageDao.getAllList();
    }

}

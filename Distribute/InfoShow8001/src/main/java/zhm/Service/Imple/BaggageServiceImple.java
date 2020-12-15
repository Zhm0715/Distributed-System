package zhm.Service.Imple;

import domain.Baggage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zhm.DAO.BaggageDao;
import zhm.Service.BaggageService;

import java.util.List;


@Service
@Component
public class BaggageServiceImple implements BaggageService {

    @Autowired
    private BaggageDao baggageDao;

    @Override
    public List<Baggage> FlushBaggage(){
        return this.baggageDao.getAllList();
    }

}

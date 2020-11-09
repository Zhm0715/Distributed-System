package zhm.core.Service;

import zhm.core.domain.Baggage;

import java.util.List;

public interface BaggageService {
    public void AddBaggage(Baggage baggage);

    List<Baggage> FlushBaggage();
}

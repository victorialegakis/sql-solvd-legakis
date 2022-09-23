package secondblock.dao.interfaces;

public interface IBaggageDao extends IBaseDao<Baggage> {
    List<Baggage> getAllBaggages();

    List<Baggage> getBaggageByColor();

}


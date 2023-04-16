package secondblock.dao.interfaces;

import secondblock.models.TransportationMedium;

public interface ITransportationMediumDao extends IBaseDao<T> {
    List<TransportationMedium> getTransportMediums();

    TransportationMedium getMostUsedMedium();
}

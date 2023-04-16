package secondblock.dao.interfaces;

import secondblock.models.Route;

public interface IRouteDao extends IBaseDao<Route> {
    List<Route> getAllRoutes();

    Route getShortestRoute();
}

package secondblock.dao.interfaces;

import secondblock.models.City;

import java.util.List;

public interface ICityDao extends IBaseDao<City> {
    List<City> getAllCities();

}

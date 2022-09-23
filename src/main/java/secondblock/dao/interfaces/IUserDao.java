package secondblock.dao.interfaces;

import secondblock.models.User;

import java.util.List;

public interface IUserDao extends IBaseDao<User> {
    List<User> getAllUsers();

    List<User> getAllBaggageUsers();

    List<User> getAllPassengers();
}

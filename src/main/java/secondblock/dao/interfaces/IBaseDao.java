package secondblock.dao.interfaces;

public interface IBaseDao<T> {

    //supports basic CRUD operations and serves as generic for all DAOs.

    void create(T t);

    T getById(long id);

    void removeById(long id);

    void update(T t);

}

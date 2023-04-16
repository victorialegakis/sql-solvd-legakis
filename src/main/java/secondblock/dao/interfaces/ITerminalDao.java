package secondblock.dao.interfaces;

import secondblock.models.Terminal;

import java.util.List;

public interface ITerminalDao extends IBaseDao<Terminal> {
    List<Terminal> getAllTerminals();

}

package secondblock.dao.interfaces;

import secondblock.models.Transfer;

import java.util.List;

public interface ITransferDao extends IBaseDao<Transfer> {
    List<Transfer> getAllTransfers();
}

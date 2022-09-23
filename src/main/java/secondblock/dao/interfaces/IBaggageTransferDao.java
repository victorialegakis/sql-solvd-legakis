package secondblock.dao.interfaces;

import secondblock.models.BaggageTransfer;

import java.util.List;

public interface IBaggageTransferDao extends IBaseDao<BaggageTransfer> {
    List<BaggageTransfer> getAllBaggagesTransfers();

    BaggageTransfer getMostExpensiveBaggageTransfer();
}


package secondblock.dao.interfaces;

import secondblock.models.PassengerTransfer;

import java.util.List;

public interface IPassengerTransferDao extends IBaseDao<PassengerTransfer> {
    List<PassengerTransfer> getAllPassengersTransfers();

    PassengerTransfer getMostExpensivePassengerTransfer();
}

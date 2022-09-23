package firstblock.agency.interfaces.functional;

import firstblock.agency.Customer;

@FunctionalInterface
public interface IBookable {
    String bookAppointment(Customer customer);
}

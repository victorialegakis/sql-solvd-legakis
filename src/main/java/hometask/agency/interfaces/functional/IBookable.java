package hometask.agency.interfaces.functional;

import hometask.agency.Customer;

@FunctionalInterface
public interface IBookable {
    String bookAppointment(Customer customer);
}

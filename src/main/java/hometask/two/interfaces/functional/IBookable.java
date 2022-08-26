package hometask.two.interfaces.functional;

import hometask.two.Customer;

@FunctionalInterface
public interface IBookable {
    String bookAppointment(Customer customer);
}

package hometask.two;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String mailAddress;

    public Person(String firstName, String lastName, int phoneNumber, String mailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
        this.mailAddress = mailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setPhoneNumber(int phoneNumber) {
        if (phoneNumber > 0) {
            this.phoneNumber = phoneNumber;
        }
    }
    }

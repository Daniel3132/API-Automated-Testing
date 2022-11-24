package org.globantBank.data;

public class Client {

    private int id;
    private String name;
    private String lastName;
    private float accountNumber;
    private double amount;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private String telephone;

    public Client() {

    }

    public Client(String name, String lastName, float accountNumber, double amount, String transactionType, String email, boolean active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public float getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getCountry() {
        return country;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return " ID: " + id + "\n" +
                " Name: " + name + "\n" +
                " LastName: " + lastName + "\n" +
                " AccountNumber: " + accountNumber + "\n" +
                " Amount: " + amount + "\n" +
                " TransactionType: " + transactionType + "\n" +
                " Email: " + email + "\n" +
                " Active: " + active + "\n" +
                " Country: " + country + "\n" +
                " Telephone: " + telephone + "\n\n";
    }

}

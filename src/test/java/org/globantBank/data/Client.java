package org.globantBank.data;

public class Client {

    private String ID;
    private String Name;
    private String LastName;
    private float AccountNumber;
    private double Amount;
    private String TransactionType;
    private String Email;
    private boolean Active;
    private String Country;
    private float Telephone;

    public Client(String ID, String name, String lastName, float accountNumber, double amount, String transactionType, String email, boolean active, String country, float telephone) {
        this.ID = ID;
        this.Name = name;
        this.LastName = lastName;
        this.AccountNumber = accountNumber;
        this.Amount = amount;
        this.TransactionType = transactionType;
        this.Email = email;
        this.Active = active;
        this.Country = country;
        this.Telephone = telephone;
    }

}

package org.globantBank;

public class Client {

    private int ID;
    private String Name;
    private String LastName;
    private float AccountNumber;
    private double Amount;
    private String TransactionType;
    private String Email;
    private boolean Active;
    private String Country;
    private float Telephone;

    public Client(int ID, String name, String lastName, float accountNumber, double amount, String transactionType, String email, boolean active, String country, float telephone) {
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

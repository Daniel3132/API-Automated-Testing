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

    /**
     * default constructor needed to deserialize object
     */
    public Client() {
    }

    /**
     * Constructor used to generate the random clients
     * don't need to set de id attribute because of the API set it by its own
     *
     * @param name
     * @param lastName
     * @param accountNumber
     * @param amount
     * @param transactionType
     * @param email
     * @param active
     * @param country
     * @param telephone
     */
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

    /**
     * get client ID to make validations and a reference of clients
     * All getters needed to deserialize object
     *
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * used to Assert the Test Put Request
     * All getters needed to deserialize object
     *
     * @return Account number
     */
    public float getAccountNumber() {
        return accountNumber;
    }

    /**
     * used to modify account number on the Test Put Request
     */
    public void setAccountNumber(float accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return Amount of money
     */
    public double getAmount() {
        return amount;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return transaction Type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Used when validate there are not duplicate emails on GET or POST
     * All getters needed to deserialize object
     *
     * @return Amount of money
     */
    public String getEmail() {
        return email;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return boolean for account is Active or not
     */
    public boolean isActive() {
        return active;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return Country for transaction
     */
    public String getCountry() {
        return country;
    }

    /**
     * All getters needed to deserialize object
     *
     * @return client telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * to Have a nicely wrote client body for each client
     *
     * @return a organized String with all client info
     */
    @Override
    public String toString() {
        return "\nId: " + id +
                "\nName: " + name +
                "\nLastName: " + lastName +
                "\nAccountNumber: " + accountNumber +
                "\nAmount: " + amount +
                "\nTransactionType: " + transactionType +
                "\nEmail: " + email +
                "\nActive: " + active +
                "\nCountry: " + country +
                "\nTelephone: " + telephone;
    }

}

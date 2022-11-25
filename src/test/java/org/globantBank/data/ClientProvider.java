package org.globantBank.data;

import com.github.javafaker.Faker;
import org.globantBank.reporting.Reporter;

import java.util.ArrayList;
import java.util.List;

public class ClientProvider {

    public String getTransactionType() {
        List<String> transactionTypes = new ArrayList<>();
        transactionTypes.add("payment");
        transactionTypes.add("deposit");
        transactionTypes.add("withdrawal");
        transactionTypes.add("invoice");

        int randomIndex = (int) (Math.random() * 4);

        return transactionTypes.get(randomIndex);
    }

    public Client createRandomClient(boolean sameEmail) {
        Faker faker = new Faker();
        String emailToRepeat = "danielcorrea@gmail.com";
        String email = (sameEmail) ? emailToRepeat : faker.internet().emailAddress();

        return new Client(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().randomNumber(),
                faker.number().randomNumber(),
                getTransactionType(),
                email,
                faker.random().nextBoolean(),
                faker.country().name(),
                faker.phoneNumber().phoneNumber()
        );
    }

    public List<Client> createRandomClientsList(int listSize) {
        List<Client> clientsToPostList = new ArrayList<>();
        List<String> emailsList = new ArrayList<>();

        for (int i = 0; i <= listSize; i++) {
            boolean sameEmail = listSize - 1 <= i;
            Client newClient = createRandomClient(sameEmail);

            //Check email is not duplicate before add.
            if (!emailsList.contains(newClient.getEmail())) {
                emailsList.add(newClient.getEmail());
                clientsToPostList.add(newClient);
            } else {
                Reporter.warn("Client with email duplicate not added");
            }
        }

        return clientsToPostList;
    }

}

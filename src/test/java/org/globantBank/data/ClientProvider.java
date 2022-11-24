package org.globantBank.data;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientProvider {

    public String getTransactionType(){
        List<String> transactionTypes = new ArrayList<>();
        transactionTypes.add("payment");
        transactionTypes.add("deposit");
        transactionTypes.add("withdrawal");
        transactionTypes.add("invoice");

        int randomIndex = (int) (Math.random()*4);

        return transactionTypes.get(randomIndex);
    }

    public Client createRandomClient(){
        Faker faker = new Faker();

        return new Client(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.number().randomNumber(),
                faker.number().randomNumber(),
                getTransactionType(),
                "danielcorrea@gmail.com",
                faker.random().nextBoolean(),
                faker.country().name(),
                faker.phoneNumber().phoneNumber()
                );
    }

    public List<Client> createRandomClientsList(){




        return null;
    }



}

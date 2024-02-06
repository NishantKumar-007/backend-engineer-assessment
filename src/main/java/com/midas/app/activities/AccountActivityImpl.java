package com.midas.app.activities;

import com.midas.app.models.Account;
import com.midas.app.repositories.AccountRepository;
import com.midas.app.workflows.CreateAccountWorkflow;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import io.temporal.spring.boot.ActivityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = CreateAccountWorkflow.QUEUE_NAME)
public class AccountActivityImpl implements AccountActivity {

  @Autowired private AccountRepository accountRepository;


  // saving updated account to database
  @Override
  public Account saveAccount(Account account) {

    return accountRepository.save(account);
  }


  // Calling customer stripe api to create customer
  @Override
  public Account createPaymentAccount(Account account) {

    CustomerCreateParams params =
        CustomerCreateParams.builder()
            .setName(account.getFirstName())
            .setEmail(account.getEmail())
            .build();

    try {
      Customer customer = Customer.create(params);
      account.setProviderId(customer.getId());
      System.out.println(customer);
    } catch (StripeException e) {

      e.printStackTrace();
    }

    saveAccount(account);
    return account;
  }
}

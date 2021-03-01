package com.junbetterway.serverless.springcloudfunc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junbetterway.serverless.springcloudfunc.functions.CreateAccount;
import com.junbetterway.serverless.springcloudfunc.functions.ReadAccount;
import com.junbetterway.serverless.springcloudfunc.functions.ReadAllAccounts;
import com.junbetterway.serverless.springcloudfunc.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SpringcloudfuncConfig {

	private final AccountRepository repository;
	
	@Bean
	public CreateAccount createAccount() {
		return new CreateAccount(repository);
	}

	@Bean
	public ReadAllAccounts readAllAccounts() {
		return new ReadAllAccounts(repository);
	}

	@Bean
	public ReadAccount readAccount() {
		return new ReadAccount(repository);
	}
	
}

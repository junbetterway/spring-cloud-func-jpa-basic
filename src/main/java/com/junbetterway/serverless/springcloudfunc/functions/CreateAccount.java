package com.junbetterway.serverless.springcloudfunc.functions;

import java.util.function.Function;

import com.junbetterway.serverless.springcloudfunc.dto.CreateAccountRequest;
import com.junbetterway.serverless.springcloudfunc.model.Account;
import com.junbetterway.serverless.springcloudfunc.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class CreateAccount implements Function<CreateAccountRequest, Account> {
	
	private final AccountRepository repository;
	
	@Override
	public Account apply(final CreateAccountRequest request) {
				
		log.info("Processing {}", request);
		
		Account newAccount = Account.builder()
				.name(request.getName())
				.balance(request.getBalance())
				.build();
		
		return repository.save(newAccount);
		
	}

}

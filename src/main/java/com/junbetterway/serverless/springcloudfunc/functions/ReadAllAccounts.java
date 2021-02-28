package com.junbetterway.serverless.springcloudfunc.functions;

import java.util.List;
import java.util.function.Supplier;

import com.junbetterway.serverless.springcloudfunc.model.Account;
import com.junbetterway.serverless.springcloudfunc.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class ReadAllAccounts implements Supplier<List<Account>> {

	private final AccountRepository repository;
	
	@Override	
	public List<Account> get() {
		log.info("Find ALL accounts...");
		return repository.findAll();
	}
	
}

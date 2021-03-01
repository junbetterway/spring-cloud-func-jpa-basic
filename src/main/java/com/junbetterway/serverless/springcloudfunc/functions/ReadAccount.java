package com.junbetterway.serverless.springcloudfunc.functions;

import java.util.Optional;
import java.util.function.Function;

import com.junbetterway.serverless.springcloudfunc.exception.AccountNotFoundException;
import com.junbetterway.serverless.springcloudfunc.model.Account;
import com.junbetterway.serverless.springcloudfunc.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class ReadAccount implements Function<Long, Account> {

	private final AccountRepository repository;

	@Override
	public Account apply(Long id) {
		log.info("Retrieving account ID: {}", id);
		Optional<Account> found = repository.findById(id);
		if(found.isEmpty()) {
			throw new AccountNotFoundException(id);
		}
		return found.get();
	}
	
	
}

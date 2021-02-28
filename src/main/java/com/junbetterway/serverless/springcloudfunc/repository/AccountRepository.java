package com.junbetterway.serverless.springcloudfunc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junbetterway.serverless.springcloudfunc.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

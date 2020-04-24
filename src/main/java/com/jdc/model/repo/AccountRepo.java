package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long>{

}

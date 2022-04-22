package com.manager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.EmailSubscribeDomain;


/**
 * @author Troublem@ker
 */

@Repository
public interface EmailSubscribe extends CrudRepository<EmailSubscribeDomain,String> {


}
 

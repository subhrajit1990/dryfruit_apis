package com.manager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.domain.ContactMeDomain;

/**
 * @author Troublem@ker
 */

@Repository
public interface ContactMe extends CrudRepository<ContactMeDomain,String> {


}
 

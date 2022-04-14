/**
 * 
 */
package com.manager.service;

import org.springframework.stereotype.Component;

import com.manager.model.ContactMeRequest;
import com.manager.model.ContactMeResponse;

/**
 * @author Troublem@ker
 */

@Component
public interface IMiscellaneousService {
	
	public ContactMeResponse contactMeService(ContactMeRequest contactMeRequest, String masterTxnRefNo, String channel);

}

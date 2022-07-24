/**
 * 
 */
package com.manager.service;

import org.springframework.stereotype.Component;

import com.manager.model.ContactMeRequest;
import com.manager.model.ContactMeResponse;
import com.manager.model.EmailSubscribeRequest;
import com.manager.model.EmailSubscribeResponse;

/**
 * @author Troublem@ker
 */

@Component
public interface IMiscellaneousService {
	
	public ContactMeResponse contactMeService(ContactMeRequest contactMeRequest, String masterTxnRefNo, String channel);
	public EmailSubscribeResponse emailSubscribeService(EmailSubscribeRequest emailSubscribe, String masterTxnRefNo, String channel);

}

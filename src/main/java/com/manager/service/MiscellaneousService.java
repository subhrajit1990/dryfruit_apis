/**
 * 
 */
package com.manager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.domain.ContactMeDomain;
import com.manager.model.ContactMeRequest;
import com.manager.model.ContactMeResponse;
import com.manager.repo.ContactMe;
import com.manager.utils.CommonUtils;
import com.manager.utils.ContactMeException;

/**
 * @author subhrajit
 *
 */
@Service
public class MiscellaneousService implements IMiscellaneousService {

	private static final Logger logger = LogManager.getLogger(MiscellaneousService.class);

	@Autowired
	private ContactMe contactMe;

	/**
	 * @param contactMeRequest
	 * @param masterTxnRefNo
	 * @param channel
	 * @return
	 * @throws ContactMeException
	 */
	public ContactMeResponse contactMeService(ContactMeRequest contactMeRequest, String masterTxnRefNo,
			String channel) {
		ContactMeResponse contactMeResponse = new ContactMeResponse();
		try {
			ContactMeDomain contactMeDomain = new ContactMeDomain();
			contactMeDomain.setChannel(channel);
			contactMeDomain.setCreatedDt(CommonUtils.currentTime());
			contactMeDomain.setEmail(contactMeRequest.getEmail());
			contactMeDomain.setMasterTxnNo(masterTxnRefNo);
			contactMeDomain.setSubject(contactMeRequest.getSubject());
			contactMeDomain.setName(contactMeRequest.getName());
			contactMeDomain.setPhoneNumber(contactMeRequest.getPhoneNumber());
			contactMeDomain.setMessage(contactMeRequest.getMessage());
			contactMe.save(contactMeDomain);
			contactMeResponse.setContactMeStatus("0");
		} catch (Exception e) {
			logger.error("Error occurred :: " + e.getStackTrace());
			throw new ContactMeException("CON_ME", "Exception");
		}

		return contactMeResponse;

	}

}

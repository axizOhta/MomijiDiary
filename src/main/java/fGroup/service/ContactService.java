package fGroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fGroup.dao.ContactDao;
import fGroup.dto.Contact;

@Service
@Transactional
public class ContactService {

	@Autowired
	private ContactDao contactDao;

	public int coninsert(Contact contact) {
		return contactDao.coninsert(contact);
	}
}

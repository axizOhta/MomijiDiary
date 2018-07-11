package fGroup.service;

import java.util.List;

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

	public int coninsertUser(Contact contact) {
		return contactDao.coninsertUser(contact);
	}
	public List<Contact> contactall(Contact contact){
		return contactDao.contactall();
	}

	public List<Contact> contactallUser(Integer user_id){
		return contactDao.contactallUser(user_id);
	}
}

package fGroup.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import fGroup.dto.Contact;
import fGroup.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactTest {

	@Autowired
    private JdbcTemplate jT;

	@Autowired
	private ContactService contactService;

	@Before
	public void setUpContact() {
		  jT.update("DELETE FROM contact");
		  jT.update("INSERT INTO contact (user_id,email_address,contact_title,contact_message,contact_date) VALUES(10002,'suzuki@example.com','記事タイトルについて', '記事タイトルをあとからかえることはできますか？', '2018/07/06 (金) 14時40分')");
		  jT.update("INSERT INTO contact (user_id,email_address,contact_title,contact_message,contact_date) VALUES(10002,'suzuki@example.com','退会について', '退会の方法を教えてください', '2018/07/06 (金) 14時40分')");
		  jT.update("INSERT INTO contact (email_address,contact_title,contact_message,contact_date) VALUES('aaa@example.com','テスト', 'テスト', '2018/07/06 (土) 1時50分')");
	}

	//1.ユーザーIDが入らない
    @Test
    public void お問い合わせ送信_会員() throws Exception {
		Contact contact = new Contact();
		contact.setUser_id(110);
		contact.setEmail_address("aaa@aaa.co.jp");
		contact.setContact_title("ブログについて");
		contact.setContact_message("文字を赤くするにはどうしたらいいですか？");

		int id= contactService.coninsert(contact);
		List<Contact> list = jT.query("SELECT * FROM contact WHERE contact_id = ?", new BeanPropertyRowMapper<Contact>(Contact.class), id);


		assertThat(list.size(), is(1));

		Contact con = list.get(0);

		assertThat(con.getUser_id(), is(110));
		assertThat(con.getEmail_address(), is("aaa@aaa.co.jp"));
    	assertThat(con.getContact_title(), is("ブログについて"));
    	assertThat(con.getContact_message(), is("文字を赤くするにはどうしたらいいですか？"));
    }

    @Test
    public void お問い合わせ送信_非会員() throws Exception {
		Contact contact = new Contact();
		contact.setEmail_address("aaa@aaa.co.jp");
		contact.setContact_title("ブログについて");
		contact.setContact_message("文字を赤くするにはどうしたらいいですか？");

		int id= contactService.coninsert(contact);
		List<Contact> list = jT.query("SELECT * FROM contact WHERE contact_id = ?", new BeanPropertyRowMapper<Contact>(Contact.class), id);
		assertThat(list.size(), is(1));

		Contact con = list.get(0);

		assertThat(con.getEmail_address(), is("aaa@aaa.co.jp"));
		assertThat(con.getContact_title(), is("ブログについて"));
		assertThat(con.getContact_message(), is("文字を赤くするにはどうしたらいいですか？"));
	}

  //2.他の会員のお問い合わせ履歴まで表示される
    @Test
    public void 会員お問い合わせ履歴() throws Exception {
    	Contact contact = new Contact();
    	contact.setUser_id(10002);
    	List<Contact> contactList = contactService.contactall(contact);

    	assertThat(contactList.size(), is(2));

    }

    @Test
    public void 管理者お問い合わせ一覧() throws Exception {
		Contact contact = new Contact();

		List<Contact> contactList = contactService.contactall(contact);

		assertThat(contactList.size(), is(3));

    }
}

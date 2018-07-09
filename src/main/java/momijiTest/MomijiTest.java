package momijiTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fGroup.dto.Contact;
import fGroup.form.ContactForm;
import fGroup.service.ContactService;


@SpringBootTest
public class MomijiTest {

	@Autowired
	private ContactService contactService;

	@Before
    public void setUp() {
		contactService = new ContactService();
    }

	@Test
	public void contactNyuryokuAdOk() throws Exception{	//正常パターン
		List <Contact> list = new ArrayList<>();
		Contact result1 = new Contact();
		result1.setEmail_address("q@gmail.com");
		result1.setContact_title("記事投稿について");
		result1. setContact_message("投稿できません。");

		list.add(result1);

		assertThat(contactService.contactall(), is(list));
	}


//
	@Test
	public void contactNyuryokuTit() {	//送信前入力後タイトルエラー
		String result = ContactForm.setContact_title("");
		assertEquals(result,true);
	}

	@Test
	public void contactNyuryokuTitOk() {	//タイトル文字化け環境依存文字、サロゲートペア(絵文字も？)
		String result =ContactForm.setContact_title("㌶Ⅲ⑳㏾☎㈱髙﨑");
		assertEquals(result,true);
	}


	@Test
	public void contactNyuryokuMessa() {	//送信前入力後メッセージ本文エラー
		String result = ContactForm.Contact_message("");
		assertEquals(result,true);
	}
	@Test
	public void contactNyuryokuMessaOk() {	//メッセージ文字化け環境依存文字、サロゲートペア(絵文字も？)
		String result =ContactForm.setEmail_address("㌶Ⅲ⑳㏾☎㈱髙﨑");
		assertEquals(result,false);
	}


	@Test
	public void contactSoushinMae() {	//送信前確認エラー(クロスサイトスクリプティング確認？)
		String result =ContactForm.Contact_message();
		String expected =
		assertEquals(expected, result);
	}
	@Test
	public void contactSoushinAto() {	//送信処理時エラー(サーバーエラー？)
		String result =ContactForm.Contact_message();
		String expected =
		assertEquals(expected, result);
	}

@Test
public void contactSoushinAto() {	//送信後のエラー(SQLインジェクション確認)
	String result =ContactForm.Contact_message();
	String expected =
	assertEquals(expected, result);
}
@Test
public void contactSoushinAto() {	//Max桁数
	String result =ContactForm.Contact_message();
	String expected =
	assertEquals(expected, result);
}
}

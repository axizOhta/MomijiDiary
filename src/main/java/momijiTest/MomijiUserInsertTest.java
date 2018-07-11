package momijiTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fGroup.dto.Users;
import fGroup.service.UserInsertService;

public class MomijiUserInsertTest {

	@Autowired
	private UserInsertService insertService;

	@Before
    public void setUp() {
		insertService = new UserInsertService();
    }

	@Test
	public void insertBake() throws Exception{	//確認画面でのエラー(ID、名前が環境依存文字の場合、絵文字の場合)
		List <Users> list = new ArrayList<>();
		Users result1 = new Users();
		result1.setLogin_id("㌶Ⅲ⑳㏾");
		result1.setName("㌶Ⅲ⑳㏾☎㈱髙﨑𠀋𡈽𡌛");
		result1.setEmail_address("qq@gmail.com");
		result1.setPassword("aaaaa");
		list.add(result1);

		assertThat(insertService.insert(result1), is(list));
	}

	@Test
	public void insertIdKakunin() throws Exception{	//確認画面でのエラー(IDがひらがな、カタカナ、漢字、英数字、記号)
		List <Users> list = new ArrayList<>();
		Users result2 = new Users();
		result2.setLogin_id("あアaA11〇亜");
		result2.setName("佐藤");
		result2.setEmail_address("qq@gmail.com");
		result2.setPassword("aaaaa");
		list.add(result2);

		assertThat(insertService.insert(result2), is(list));
	}
	@Test
	public void insertNameKakunin() throws Exception{	//確認画面でのエラー(名前がひらがな、カタカナ、漢字、英数字、記号)
		List <Users> list = new ArrayList<>();
		Users result3	 = new Users();
		result3.setLogin_id("ガリガリ");
		result3.setName("あアaA11〇亜");
		result3.setEmail_address("qq@gmail.com");
		result3.setPassword("aaaaa");
		list.add(result3);

		assertThat(insertService.insert(result3), is(list));
	}

	@Test
	public void insert() throws Exception{	//確認画面でのエラー(IDがひらがな、カタカナ、漢字、英数字、記号)
		List <Users> list = new ArrayList<>();
		Users result2 = new Users();
		result2.setLogin_id("ガリガリ");
		result2.setName("あアaA11〇亜");
		result2.setEmail_address("qq@gmail.com");
		result2.setPassword("aaaaa");
		list.add(result2);

		assertThat(insertService.insert(result2), is(list));
	}
}

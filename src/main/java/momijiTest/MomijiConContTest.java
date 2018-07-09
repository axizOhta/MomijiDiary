package momijiTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import fGroup.controller.ContactController;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class MomijiConContTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactController contactController;

	@Test
	public void test() {
		fail("まだ実装されていません");
	}

}

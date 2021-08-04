package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ContactApplicationTests {
	
	@Autowired
	private ContactService contactService;
	
	@MockBean
	private ContactRepository conatctRepository;

	@Test
	public void getContactTest() {
		when(conatctRepository.findAll()).thenReturn(Stream
				.of(new Contact("12","Tapan","415178261678"), new Contact("69","Riya","123656760")).collect(Collectors.toList()));
		assertEquals(2,contactService.getContact().size());
	}
		@Test
		public void saveContactTest() {
			Contact contact = new Contact("999", "Pranya", "431516626262");
			when(conatctRepository.save(contact)).thenReturn(contact);
			assertEquals(contact, contactService.addContact(contact));
		
		}

}


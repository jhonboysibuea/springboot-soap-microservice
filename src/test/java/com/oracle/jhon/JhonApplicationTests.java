package com.oracle.jhon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = JhonApplication.class)
@AutoConfigureMockMvc
class JhonApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	protected MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

//	@Test
//	public void testSoapEndpoint() throws Exception {
//		String soapRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:orac=\"http://www.oracle.com\" xmlns:v1=\"http://www.oracle.com/external/services/sampleservice/request/v1.0\">\n" +
//				"    <soapenv:Header>\n" +
//				"        <orac:authenticationheader>\n" +
//				"            <orac:username>xxx</orac:username>\n" +
//				"            <orac:password>xxx</orac:password>\n" +
//				"        </orac:authenticationheader>\n" +
//				"    </soapenv:Header>\n" +
//				"    <soapenv:Body>\n" +
//				"        <v1:sampleservicerq>\n" +
//				"            <v1:service_id>1234567890</v1:service_id>\n" +
//				"            <v1:order_type>CH</v1:order_type>\n" +
//				"            <v1:type>PO</v1:type>\n" +
//				"            <v1:trx_id>c6714ec0-b379-11e9-889b-7f7167f4f72d</v1:trx_id>\n" +
//				"        </v1:sampleservicerq>\n" +
//				"    </soapenv:Body>\n" +
//				"</soapenv:Envelope>";
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/external/services/ws/sample-service")
//						.contentType(MediaType.TEXT_XML)
//						.content(soapRequest))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_XML));
//	}

}

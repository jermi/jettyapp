/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jetty;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

/**
 * Basic integration tests for demo application.
 *
 * @author Dave Syer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleJetty8Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class SampleJetty8ApplicationTests {

	@Value("${local.server.port}")
	private int port;

    private HttpHeaders createHeaders( final String username, final String password ){
        return new HttpHeaders(){
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );
            }
        };
    }
    @Test
    public void emptyTest() throws Exception {

    }

	@Test
	public void testHomeBasicAuth() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().exchange
                ("http://localhost:" + this.port + "/static.html", HttpMethod.GET, new HttpEntity<String>(createHeaders("admin", "admin")), String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals("static", entity.getBody());
	}

    @Test
    public void testHomeBasicAuthNoCredentials403() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/static.html", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, entity.getStatusCode());
    }

    @Test
    public void testHomeBasicAuthWrongCredentials403() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate().exchange
                ("http://localhost:" + this.port + "/static.html", HttpMethod.GET, new HttpEntity<String>(createHeaders("admin", "wrong-password")), String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, entity.getStatusCode());
    }

//    @Test
//    public void userWithWrongCreditials() throws Exception {
//        RestTemplate rest = new TestRestTemplate();
//
//        Credentials credentials = new Credentials();
//        credentials.setName("user");
//        credentials.setPassword("password-wrong");
//
//        ResponseEntity<Object> response =
//                rest.exchange(
//                        LOCALHOST + "/login",
//                        HttpMethod.POST,
//                        new HttpEntity<Credentials>(credentials),
//                        Object.class);
//
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//    }

}

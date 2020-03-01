package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void categoriesEndPointReturnisOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/categoriesView",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
    @Test
    public void categoryEndPointReturnisOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/categoryPage",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
    @Test
    public void indexEndPointReturnsOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/index",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void authorsPageReturnsOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/authorsPage",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void authorPageReturnsOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/authorPage",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void TagPageReturnsOk(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port +"/tagViewTemplate",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);


    }
}

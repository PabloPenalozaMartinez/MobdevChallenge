package com.mobdevchallenge;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
class MobdevChallengeApplicationTests {

	@Test
	public void givenCharacterDoesNotExists_whenCharacterInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	 
	    // Given
	    String idCharacter = RandomStringUtils.randomNumeric(1, 2);
	    HttpUriRequest request = new HttpGet( "https://rickandmortyapi.com/api/character/" + idCharacter );

	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void givenLocationDoesNotExists_whenLocationInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	 
	    // Given
	    String idLocation = RandomStringUtils.randomNumeric(1, 2);
	    HttpUriRequest request = new HttpGet( "https://rickandmortyapi.com/api/character/" + idLocation );

	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

	    // Then
	    assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.OK.value());
	}

}

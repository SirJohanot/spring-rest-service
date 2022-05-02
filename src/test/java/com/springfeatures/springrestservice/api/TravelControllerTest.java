package com.springfeatures.springrestservice.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TravelControllerTest {

    @Autowired
    private TravelController travelController;

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testCalculateTravelTimeShouldReturnTheRightAnswerToPositiveDistanceAndSpeed() {
        //given
        String query = "http://localhost:8080/api/travel?distance=80&speed=10";
        String expectedAnswer = "{\"time\":8,\"responseNumber\":1}";
        //when
        String actualAnswer = testRestTemplate.getForObject(query, String.class);
        //then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testCalculateTravelTimeShouldReturnCorrectErrorMessageToNegativeDistanceAndSpeed() {
        //given
        String query = "http://localhost:8080/api/travel?distance=-56&speed=-7";
        String expectedAnswer = "{\"code\":\"BAD_REQUEST\",\"message\":\"Distance cannot be less than 0\"}";
        //when
        String actualAnswer = testRestTemplate.getForObject(query, String.class);
        //then
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testCalculateTravelTimeShouldReturnCorrectErrorMessageToNegativeSpeedAndPositiveDistance() {
        //given
        String query = "http://localhost:8080/api/travel?distance=56&speed=-7";
        String expectedAnswer = "{\"code\":\"BAD_REQUEST\",\"message\":\"Speed has to be more than 0\"}";
        //when
        String actualAnswer = testRestTemplate.getForObject(query, String.class);
        //then
        assertEquals(expectedAnswer, actualAnswer);
    }
}

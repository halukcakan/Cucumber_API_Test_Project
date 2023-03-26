package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {
    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;
    @Given("Kullanici yeni bir rezervasyonu olusturuyor")
    public void cagriBaslangici (){
         reservationService = new ReservationService();
    }
    @Given("Kullanici rezervasyonu icin gereken bilgileri veriyor")
    public void createAuth(){
        authKey = reservationService.generateToken();
    }
    @When("Kullanici otel rezervasyonu yaratiyor")
    public void createReservation (){
        bookingResponse = reservationService.createBooking();
    }
    @Then("rezervasyonu basarili sekilde olusturuldu")
    public void reservationAssertions (){
        Assertions.assertEquals("Udemy",bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Cucumber",bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(1000,bookingResponse.getBooking().getTotalprice());
        Assertions.assertFalse(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("Kopek yatagi",bookingResponse.getBooking().getAdditionalneeds());
    }
    @Then("Kullanici olusturulan rezervasyonu iptal ediyor")
    public void cancelReservation (){
        reservationService.deleteReservation(authKey,bookingResponse.getBookingid());
    }

}

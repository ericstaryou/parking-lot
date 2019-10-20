package model;

public interface Ticket {
    void issueTicket();

    default void documentRegistrationNo(){

    }

    default void documentCarColour(){

    }
}

package model;

public class Car {
    private String registractionNo;
    private Colour colour;
    private enum Colour {White, Black, Grey, Silver, Red, Green, Blue, Yellow}

    public Car(){

    }

    public void park(Ticket ticket){
        ticket.issueTicket();
    }

}

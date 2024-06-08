package restfulbooker.model;

public class BookingFactory {

    public Booking getBooking() {

        return Booking.builder()
                .firstname("Miro")
                .lastname("Dydko")
                .totalprice(10)
                .depositpaid(false)
                .bookingdates(BookingDates
                        .builder()
                        .checkin("2024-04-18")
                        .checkout("2030-04-18")
                        .build()
                )
                .build();
    }
}

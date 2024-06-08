package restfulbooker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Booking {

    private String firstname;
    private String lastname;
    int totalprice;
    boolean depositpaid;
    BookingDates bookingdates;
}

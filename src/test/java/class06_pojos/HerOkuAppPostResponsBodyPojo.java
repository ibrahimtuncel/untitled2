package class06_pojos;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerOkuAppPostResponsBodyPojo {

    private Integer bookingid;
    private BookingPojo booking;

    public HerOkuAppPostResponsBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }
    public HerOkuAppPostResponsBodyPojo() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerOkuAppPostResponsBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}

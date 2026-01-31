package Sound.Production.Sound.Production;

import jakarta.persistence.*;

@Entity
@Table(name="reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String contact;
    private String price;
    private String data;
    private String timeam;
    private String timepm;
    private boolean photoshooting;
    private String status;
    private String details;
    private String paymentinadvance;
    private String locationam;
    private String locationpm;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimeAM() {
        return timeam;
    }

    public void setTimeAM(String timeAM) {
        this.timeam = timeAM;
    }

    public String getTimepm() {
        return timepm;
    }

    public void setTimepm(String timepm) {
        this.timepm = timepm;
    }

    public boolean getPhotoshooting() {
        return photoshooting;
    }

    public void setPhotoshooting(boolean photoshooting) {
        this.photoshooting = photoshooting;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getPaymentinadvance() {
        return paymentinadvance;
    }

    public void setPaymentinadvance(String paymentinadvance) {
        this.paymentinadvance = paymentinadvance;
    }

    public String getLocationam() {
        return locationam;
    }

    public void setLocationam(String locationam) {
        this.locationam = locationam;
    }

    public String getLocationpm() {
        return locationpm;
    }

    public void setLocationpm(String locationpm) {
        this.locationpm = locationpm;
    }
}

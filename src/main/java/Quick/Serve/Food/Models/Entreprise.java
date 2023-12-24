package Quick.Serve.Food.Models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Entreprise {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phoneNumber")
    private String phonenumber;
    @JsonProperty("secondphoneNumber")
    private String secondphonenumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("adress")
    private String address;
    @JsonProperty("hourlyRate")
    private double hourlyrate;
    @JsonProperty("description")
    private String description;


    public Entreprise() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSecondphonenumber() {
        return secondphonenumber;
    }

    public void setSecondphonenumber(String secondphonenumber) {
        this.secondphonenumber = secondphonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHourlyrate() {
        return hourlyrate;
    }

    public void setHourlyrate(double hourlyrate) {
        this.hourlyrate = hourlyrate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", secondphonenumber='" + secondphonenumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", hourlyrate=" + hourlyrate +
                ", description='" + description + '\'' +
                '}';
    }
}

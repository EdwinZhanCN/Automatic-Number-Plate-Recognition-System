import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class Cars {
    private String plateNumber;
    private String city;
    private String prov;
    private String owner;
    private String brand;
    private String insurance;
    private String status;
    private String year;

    public Cars(String plateNumber, String city, String prov, String owner, String brand, String insurance, String year){
        this.city = city;
        this.prov = prov;
        this.owner = owner;
        this.brand = brand;
        this.year = year;
        this.insurance = insurance;
        Date date = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        String today = (formatter.format(date));
        if(Integer.parseInt(insurance.substring(0,4)) < Integer.parseInt(today.substring(0,4))){
            this.status = "Insurance expire";
        }else if(Integer.parseInt(insurance.substring(0,4)) > Integer.parseInt(today.substring(0,4))) {
            this.status = "Insurance OK";
        }else if(Integer.parseInt(insurance.substring(5,7)) < Integer.parseInt(today.substring(5,7))){
            this.status = "Insurance expire";
        } else if (Integer.parseInt(insurance.substring(8)) < Integer.parseInt(today.substring(8))) {
            this.status = "Insurance expire";
        }else {
            this.status = "Insurance OK";
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getCity() {
        return city;
    }

    public String getInsurance() {
        return insurance;
    }

    public String getOwner() {
        return owner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getProv() {
        return prov;
    }

    public String getStatus() {
        return status;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Plate Number: " + plateNumber;
    }
}

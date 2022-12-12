import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportCSV {
    /** csv import*/
    public static void readFile(ArrayList<Cars> array, String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;


            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(",");
                String plateNumber = lineData[0];
                String city = lineData[1];
                String prov = lineData[2];
                String owner = lineData [3];
                String brand = lineData[4];
                String year = lineData[5];
                String insurance = lineData[6];
                Cars T = new Cars(plateNumber, city, prov, owner, brand, year, insurance);
                array.add(T);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("ERR");
            System.exit(0);
        }
    }

}

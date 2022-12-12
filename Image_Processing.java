import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image_Processing{

    public static String processImage(String FileNameAndLocation) throws IOException {

        BufferedImage img = null;
        File f = null;

        // read image
        try {
            f = new File(FileNameAndLocation);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }


        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {

                // Here (x,y)denotes the coordinate of image
                // for modifying the pixel value.
                int p = img.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // calculate average
                int avg = (r + g + b) / 3;

                // replace RGB value with
                p = (a << 24) | (avg << 16) | (avg << 8)
                        | avg;

                r = (0x00ff0000 & p) >> 16;
                g = (0x0000ff00 & p) >> 8;
                b = (0x000000ff & p);
                int m = (r + g + b);
                if (m >= 383) {
                    img.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    img.setRGB(x, y, 0);
                }

            }
        }

        // write image
        try {
            f = new File("t.jpg");
            FileNameAndLocation = "t.jpg";
            ImageIO.write(img, "jpg", f);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        
        return FileNameAndLocation;
    }
}

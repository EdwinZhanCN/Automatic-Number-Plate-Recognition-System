import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image_Processing{

    public static String processImage(String FileNameAndLocation) throws IOException {
        String newFileLocation = "Photos\\Number Plate Images Processed\\" + "black_white" + FileNameAndLocation.substring(FileNameAndLocation.length()-10,FileNameAndLocation.length()-3 )+ ".jpg";
        BufferedImage img = null;
        File f = null;

        /**
         * Use to read the image from FileNameAndLocation.
         */
        try {
            f = new File(FileNameAndLocation);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }

        //get the height and width of image.
        int width = img.getWidth();
        int height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //get RGB.
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // calculate average to convert it into gray scale.
                int avg = (r + g + b) / 3;

                p = (a << 24) | (avg << 16) | (avg << 8)
                        | avg;
                //convert gray scale into binary image.
                r = (0x00ff0000 & p) >> 16;
                g = (0x0000ff00 & p) >> 8;
                b = (0x000000ff & p);
                int m = (r + g + b);
                if (m >= 450) {
                    //if the sum of rgb > 449, convert it into white
                    img.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    //else go black.
                    img.setRGB(x, y, 0);
                }

            }
        }
        // write image into new location.
        try {
            File newFile = new File(newFileLocation);
            ImageIO.write(img,"jpg",newFile);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return newFileLocation;
    }
}

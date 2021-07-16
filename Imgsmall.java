import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;

public class Imgsmall {
  public static void main(String[] args) throws Exception{
    //get url object
    URL url = new URL(args[0]);
    float small = (100-Integer.parseInt(args[1]))/100;
    //System.out.println(small);

    //get image from url
    BufferedImage img = ImageIO.read(url);
    //resize image into Image object, SCALE_FAST is a random algorithm
    Image tmp = img.getScaledInstance((int)(img.getWidth() * small),
        (int)(img.getHeight() * small),
        BufferedImage.SCALE_FAST);
    //Create resized BufferedImage object -- this is currently empty
    System.out.println(img.getType());
    BufferedImage buffered = new BufferedImage((int)(img.getWidth() * small),
        (int)(img.getHeight() * small),
        img.getType());
    //Use Graphics to draw Image tmp on top of BufferedImage buffered
    //this is because we cannot write an Image to a file -- only BufferedImage
    buffered.getGraphics().drawImage(tmp, 0, 0, null);
    //Create output File
    File out = new File("ocean_50.jpg");
    //Write output to file, using the "jpg" file type
    ImageIO.write(buffered, "jpg", out);
  }
}

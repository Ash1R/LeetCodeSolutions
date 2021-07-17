import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImgSmall {
  public static void main(String[] args) throws IOException {
      resize(args);
  }
  public static void resize(String[] args) throws IOException{
    //get url object
    URL url = null;
    try{
      url = new URL(args[0]);
    } catch (Exception MalformedURLException){
      System.out.println("check the url");
      System.exit(0);
    }
    double resizeBy = (100-Integer.parseInt(args[1]))/100.0;

    //get image from url
    BufferedImage img = ImageIO.read(url);
    //resize image into Image object, SCALE_FAST is a random algorithm
    Image tmpImage = img.getScaledInstance((int)(img.getWidth() * resizeBy),
        (int)(img.getHeight() * resizeBy),
        BufferedImage.SCALE_FAST);
    //Create resized BufferedImage object -- this is currently empty
    BufferedImage buffered = new BufferedImage((int)(img.getWidth() * resizeBy),
        (int)(img.getHeight() * resizeBy),
        img.getType());
    //Use Graphics to draw Image tmpImage on top of BufferedImage buffered
    //this is because we cannot write an Image to a file -- only BufferedImage
    // x & y are coords where the drawing should start, an ImageObserver
    // *would* receive information about the image as it is being drawn
    // asynchronously
    buffered.getGraphics().drawImage(tmpImage, 0, 0, null);
    //Create output File
    String[] name = args[0].split("/");
    String[] extension = name[name.length - 1].split(".");

    File out =
        new File(name[name.length - 1] + "_" + args[1] + extension[extension.length-1]);
    //Write output to file, using the "jpg" file type
    ImageIO.write(buffered, "jpg", out);
  }
}

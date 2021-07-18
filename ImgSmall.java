import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class ImgSmall {
  public static void main(String[] args)  {
      resize(args);
  }
  public static void resize(String[] args) {
    if (args.length != 2){
      System.out.println("please put in a url and a percent");
      System.exit(0);
    }
    //get url object
    URL url = null;
    try{
      url = new URL(args[0]);
    } catch (MalformedURLException mfue){

      System.out.println("check the url");
      System.out.println("-");
      System.out.print(args[0]);
      System.exit(0);
    }
    if (Integer.parseInt(args[1]) > 100){
      System.out.println("Can't reduce by that much");
      System.exit(0);
    }
    double resizeBy = (100 - Integer.parseInt(args[1])) / 100.0;
    BufferedImage img = null;
    //get image from url
    try {
    img = ImageIO.read(url);}
    catch (IOException ioe){
      System.out.println(ioe.getMessage());
    }
    if (img == null){
      System.out.print("The URL you entered does not contain any image, please check");
      System.exit(0);
    }
    //resize image into Image object, SCALE_FAST is a random algorithm
    Image tmpImage = img.getScaledInstance((int)(img.getWidth() * resizeBy),
        (int)(img.getHeight() * resizeBy),
        BufferedImage.SCALE_FAST);
    //Create resized BufferedImage object -- this is currently empty
    BufferedImage bufferedImage = new BufferedImage((int)(img.getWidth() * resizeBy),
        (int)(img.getHeight() * resizeBy),
        img.getType());
    //Use Graphics to draw Image tmpImage on top of BufferedImage bufferedImage
    //this is because we cannot write an Image to a file -- only BufferedImage
    // x & y are coords where the drawing should start, an ImageObserver
    // *would* receive information about the image as it is being drawn
    // asynchronously
    bufferedImage.getGraphics().drawImage(tmpImage, 0, 0, null);
    //Create output File
    String filename =
        Paths.get((url).getPath()).getFileName().toString();
    int lastIndexOf = args[0].lastIndexOf(".");
    String extension = "";
    if (lastIndexOf != -1) {
      extension = args[0].substring(lastIndexOf);
    }

    File out =
        new File(filename + "_" + args[1] + extension);
    //Write output to file
    if (!extension.equals("png")&&!extension.equals("PNG")&&!extension.equals(
        "JPG")&&!extension.equals("jpg")&&!extension.equals("gif")&&!extension.equals("GIF")){
      System.out.println("invalid file type");
    }
    try{
    ImageIO.write(bufferedImage, extension, out);
    } catch (IOException ioe){
      System.out.println(ioe.getMessage());
    }
    System.out.println("Image reduced by " + args[1] + "% and saved to " + out.getName());
  }
}

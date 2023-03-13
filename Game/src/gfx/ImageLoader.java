import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        BufferedImage read = null;
        try {
            read = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }
}
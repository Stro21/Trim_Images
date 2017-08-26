/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trim_images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author eduar
 */
public class Trim_Images {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String baseFileName = "imagename";
        Image largeMap = ImageIO.read(new File(baseFileName + ".png"));

        int smallSize = 360, overlap = 40, smallCount = 3;
        for (int i = 0; i < smallCount; i++) {
            for (int j = 0; i < smallCount; j++) {
                BufferedImage smallMap = new BufferedImage(smallSize, smallSize, BufferedImage.TYPE_INT_ARGB);
                int x = i * (smallSize - overlap);
                int y = j * (smallSize - overlap);
                smallMap.getGraphics().drawImage(largeMap, 0, 0, smallSize, smallSize, 
                       x, y, x + smallSize, y + smallSize, null);
                ImageIO.write(smallMap, "png", new File(baseFileName + "_" + i + j + ".png"));
            }
        }
    }
    
}

package UI;

import Model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    
    private Image current;

    @Override
    public Image current() {
        return current;
    }

    @Override
    public void show(Image image) {
        current = image;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if(current != null){
            g.drawImage(
                    imageOf(current), 
                    0, 
                    0, 
                    this.getWidth(), 
                    this.getHeight(), 
                    null);
        }
    }

    private BufferedImage imageOf(Image image) {
        try{
            return ImageIO.read(image.stream());
        }catch(IOException ex){
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
     
}
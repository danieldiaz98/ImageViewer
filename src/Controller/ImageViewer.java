package Controller;

import Model.Image;
import Persistance.FileImageLoader;
import java.io.File;
import javax.swing.JOptionPane;

public class ImageViewer {

    public static void main(String[] args) {
        File file = new File("./");
        FileImageLoader imageLoader = new FileImageLoader(file);

        Image image = imageLoader.load();
        
        
        if(image != null){
            MainFrame mainFrame = new MainFrame(imageLoader);
            mainFrame.getImageDisplay().show(image);
        }else{
            System.out.println("No se han encontrado imágenes");
            JOptionPane.showMessageDialog(null,"No se han encontrado imagenes");
        }
    }

}
package Persistance;

import Model.Image;
import Model.ProxyImage;
import Model.RealImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileImageLoader implements ImageLoader {
    
    private final File[] file;
    private int current;

    public FileImageLoader(File folder) {
        this.current = 0;
        this.file = folder.listFiles(imageType());
    }
    
    public FileFilter imageType(){
         return (File pathname) -> pathname.getName().endsWith(".jpg"); 
    }

    @Override
    public Image load() {
        
        if(file.length > 0){
            return new ProxyImage(file[current]);
        }else{
            return null;
        }
  
    }
   
    
    @Override
    public Image next() {
        
        if(current == file.length-1){
            current = 0;
        }else{
            this.current++;
        }
        
        return this.load();
        
    }

    @Override
    public Image prev() {
        
        if(current == 0){
            current = file.length-1;
        }else{
            this.current--;
        }
        return this.load();
    }
}
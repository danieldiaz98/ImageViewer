package Model;

import java.io.InputStream;

public class RealImage implements Image {
    
    final private String name;
    final private InputStream stream;

    public RealImage(String name, InputStream stream) {
        this.name = name;
        this.stream = stream;
    }
    

    @Override
    public String name() {
        return name;
    }

    @Override
    public InputStream stream() {
        return stream;
    }
    
}
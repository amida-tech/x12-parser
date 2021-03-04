package com.imsweb.x12.reader;

import org.junit.Test;
import java.net.URL;
import com.imsweb.x12.reader.X12Reader.FileType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.imsweb.x12.Loop;
import static org.junit.Assert.assertTrue;


public class X12834ReaderTest {
    
    @Test
    public void testReader() throws IOException {
        URL url = this.getClass().getResource("/834_Versions/file834.txt");
        File f = new File(url.getFile());
        assertTrue(f.exists());
        X12Reader reader = new X12Reader(FileType.ANSI834_5010_X220, f);

        assertTrue(reader != null);
        //assertTrue(reader.getErrors().size() == 0);
        for(String error: reader.getErrors()){
            System.out.println(error);
        }
        for(String error: reader.getFatalErrors()){
            System.out.println(error);
        }
        List<Loop> loops = reader.getLoops();
        assertTrue(loops.size() > 0);
        
        
        //assertTrue(loops.size() > 0);
    }
}

package com.gzq.others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestBuffer {
    
    public static void main(String[] args) throws IOException {
        Writer writer = 
                new BufferedWriter(new FileWriter(new File("D:\\testdata\\test.txt")),300); 
//                new FileWriter(new File("D:\\testdata\\test.txt"));
        long begin = System.currentTimeMillis();
        for(int i=0; i< 1000000; i++) {
            writer.write(i);
        }
        writer.close();
        System.out.println(System.currentTimeMillis() - begin);
        
    }

}

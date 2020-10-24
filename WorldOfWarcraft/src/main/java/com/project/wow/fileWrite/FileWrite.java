package com.project.wow.fileWrite;

import com.project.wow.payload.Payload;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class FileWrite {

    public static void writeToFileTheResults(Payload payload) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter("logs.txt",true));
        Date localDateTime = new Date();
        writer.write(payload.getSpec() + " " + payload.getClassPick() + ":" + payload.getRole() + ":" + localDateTime.toString());
        writer.newLine();
        writer.close();
    }
}

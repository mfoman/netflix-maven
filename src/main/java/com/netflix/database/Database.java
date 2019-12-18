package com.netflix.database;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Database {
    private Path storagePath;

    public Database(String storagePath) {
        this.storagePath = Paths.get(storagePath);
        //System.out.println(this.storagePath.toString());
    }

    public void set(String key, Object obj) {
        serialize(this.storagePath.toString() + "/" + key + ".ser", obj);
    }

    public Object get(String key) throws IOException {
        Object obj = deSerialize(this.storagePath.toString() + "/" + key + ".ser");
        return obj;
    }

    private void serialize(String filename, Object obj) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object deSerialize(String filename) throws IOException {
        Object obj = new Object();

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            obj = in.readObject();

            in.close();
            file.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }
}

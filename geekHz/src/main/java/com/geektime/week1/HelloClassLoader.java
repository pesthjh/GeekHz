package com.geektime.week1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        Class<?> helloClass = new MyClassLoader().findClass("Hello");
        Method hello = helloClass.getMethod("hello");
        hello.invoke(helloClass.getDeclaredConstructor().newInstance());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = ".\\src\\main\\resources\\Hello.xlass";
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(fileName));
            for(int i=0;i<bytes.length;i++){
                bytes[i] =(byte)(255 - (int)bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,bytes,0,bytes.length);
    }

    //public byte[] decode(String base64) {
    //    return Base64.getDecoder().decode(base64);
    //}

}

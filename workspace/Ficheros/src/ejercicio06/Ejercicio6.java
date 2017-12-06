package ejercicio06;

import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        String ruta = ".\\Dir\\f2.txt",dest1=".\\Dir\\f3.txt",dest2=".\\Dir\\f4.txt",dest3=".\\Dir\\f5.txt",dest4=".\\Dir\\f6.txt";
        char[] str = new char[15];
        int i;
        BufferedReader bf,bf1,bf2,bf3;
        BufferedWriter bw,bw1,bw2,bw3;
        try {
            bf = new BufferedReader(new FileReader(new File(ruta)));
            bw1 = new BufferedWriter(new FileWriter(new File(dest1)));
            bw2 = new BufferedWriter(new FileWriter(new File(dest2)));
            bw3 = new BufferedWriter(new FileWriter(new File(dest3)));

            while ((i=bf.read(str))!=-1){
                if(i>10){
                    bw1.write(str,0,5);
                    bw2.write(str,5,5);
                    bw3.write(str,10,i-10);
                }else if(i>5){
                    bw1.write(str,0,5);
                    bw2.write(str,5,i-5);
                }else {
                    bw1.write(str,0,i);
                }

            }
            bf.close();
            bw1.close();
            bw2.close();
            bw3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bf1 = new BufferedReader(new FileReader(dest1));
            bf2 = new BufferedReader(new FileReader(dest2));
            bf3 = new BufferedReader(new FileReader(dest3));
            bw = new BufferedWriter(new FileWriter(dest4));

            while ((i=bf1.read(str,0,5))!=-1){
                bw.write(str,0,i);
                if((i=bf2.read(str,5,5))!=-1){
                    bw.write(str,5,i);
                    if((i=bf3.read(str,10,5))!=-1){
                        bw.write(str,10,i);
                    }
                }
            }
            bf1.close();
            bf2.close();
            bf3.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

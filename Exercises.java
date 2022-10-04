/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
/**
 *
 * @author yunus
 */
public class Exercises {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        // TODO code application logic here
        /*
        Create a java program that is capable of performing the following operations  (write your own block comments for each logical segment of code implementing the comments shown here):
        1.  Opens an input file called "fahreinheit.txt" and reads the integers into an ArrayList called fahreinheit_list
        2.  Creates a second ArrayList called celsius_list
        3.  Using the farienheit_list ArrayList, calculate each Farheinheit's equivalent Celsius temperature and store the result in the ArrayList called celsius_list
        4.  Open an output file called "temperature_conversion_table.txt"
        5.  Write out the contents of both ArrayLists into a formatted Conversion table like the one below organized into two columns seperated by a tab character into the "temperature_conversion_table.txt" as follows:

                  Fahrenheit           Celsius
                     -4                         -20
                     5                          -15
                     14                        -10
                     23                         -5
                    32                           0
                    41                           5
                    50                          10
                    59                          15
                    68                          20
                    77                          25
        6.  Close both the input file and the output files
        7.  Open the "temperature_conversion_table.txt" file you just created and closed.
        8.  Pull in the data stored within it into a hash_map, where each key will be the fahrenheit temperatures and each value associated with that key will be the celsius temperatures.
        9.  Output the conversion table as formatted above to the screen using the hashmap holding the fahrenheit keys and the celsius values (use the enhanced for loop from the PowerPoint lecture as a reference) 
        10. Once completed, please submit this file to Week 4 Exercises on the Assignment page for the CS 232 course on Canvas.
         */
        
        
        // initiating the variables to read in and out to files
        File filerd = new File("fahreinheit.txt");
        Scanner file = new Scanner(filerd);
        //Scanner in = new Scanner(System.in);
        
        //create the array and add the variables from file to the arry
        ArrayList<Integer> fahreinheit_list = new ArrayList<Integer>();
        while (file.hasNextInt()){
            int degree = file.nextInt();
            fahreinheit_list.add(degree);
       
        }
        
        //createl celcius list, find the celcius values, and add them to the celcius array
        ArrayList<Integer> celcius_list = new ArrayList<Integer>();
        int count=0;
        int i=0;
        int current=0;
        int cel=0;
        //System.out.println(fahreinheit_list.size());
        for(int a=0;a<fahreinheit_list.size();a++){
            current=fahreinheit_list.get(a);
            //System.out.println(current);
            cel= (current-32)*5/9;
            celcius_list.add(cel);
            //System.out.println(cel);
            i++;
            count++;
        }
        /*
        while(fahreinheit_list.size()<count){
            current=fahreinheit_list.get(i);
            System.out.println(current);
            cel= (current-32)*5/9;
            celcius_list.add(cel);
            i++;
            count++;
        }
        */
        //System.out.println(celcius_list);
         
        //print the values as a table to a new file using output variable
        PrintWriter  output = new PrintWriter( "temperature_conversion_table.txt", "UTF-8" );
        output.println( "Fahrenheit     Celcius"  );
        //int countt=0;
        // int j=0;
        
        for(int o=0; o<fahreinheit_list.size();o++){
            output.println(fahreinheit_list.get(o)+"             "+celcius_list.get(o));
        }
        /*
        while(fahreinheit_list.size()<countt){
            output.println(fahreinheit_list.get(j)+"             "+celcius_list.get(j));
            countt++;
            j++;
        }
        */
        // closing the file variables
        output.close();
        file.close();
        
        
        //creating a hash map and adding the values inside it
        HashMap<Integer, Integer> degreelist = new HashMap<Integer, Integer>();
        for(int k=0; k<fahreinheit_list.size();k++){
            degreelist.put(fahreinheit_list.get(k),celcius_list.get(k));
        }
        
        // printing the values out as a table
        for (HashMap.Entry<Integer, Integer> e : degreelist.entrySet()) {
            System.out.println("Fahrenheit   Celcius");
            System.out.println(e.getKey() +"           "+ e.getValue());
        
            }
  
        
        
        
    }
}
    
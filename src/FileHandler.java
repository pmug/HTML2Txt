import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Paths; 
import java.util.Arrays;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muggy
 */
public class FileHandler
{

String pathName = "C:/Users/muggy/Desktop/sandbox";
String fileName = "Anniversaries_2015.html";
String s = "";
String [] lineArray;
String keepLine = "";
Boolean inATag = false;
Boolean outThisTime = true;
String someString = "";

    /**
     *
     * @param s
     */
    public String stripTheLine(String s)
{
    lineArray = s.split("");
    //for(String aChar : lineArray ){
    for (int i = 0; i < lineArray.length; i++) {
        if (inATag==false) 
        {
            outThisTime=true;
        }
        if (lineArray[i].matches(">")) 
        {
            inATag = false;
            //System.out.print( aChar );
            System.out.println( "aaa" + lineArray[i].toString() );
        } else if (lineArray[i].matches("<")||inATag) 
        {    
            inATag = true;
            //System.out.print( aChar + "AA" );
            System.out.println( "***" + lineArray[i].toString() );
        } else if (outThisTime==true) 
        {
            keepLine = keepLine + lineArray[i];
        }
        
      }
    //System.out.println("array" + lineArray[0].toString() + lineArray[1].toString());    
    //System.out.println("Length: " + lineArray.length);
    return keepLine;

}

public void readFile() throws IOException
{    
// reading file line by line in Java 8  
Files.lines(Paths.get(pathName, fileName))
//        .forEach(System.out::println);
          .map(s -> s.trim()) 
          .forEach(s -> stripTheLine(s));
System.out.println("keepline" + keepLine);
}     
}

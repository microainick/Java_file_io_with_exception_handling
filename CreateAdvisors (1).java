/**********************************************************
Developer: Larry Hill and Nicholas Marien
Course and Section: CIT 38800 Section 25901
Assignment Number: Three
Due Date and Time: 11/25/19 at 11:59pm
File Name: CreateAdvisors.java
Description:
This file is going to get the file name and path from the user.  Then use it
to open the input file.  Then it is going to fill an array with the lines
from that file.  Lastly it is going to call the appropriate constructor
from the abstract datatype class based on the number of tokens in each line.
Lastly it is going to use the display method from Larry Hill.
**********************************************************/

import javax.swing.*;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class CreateAdvisors
{
  public
    static final String EOF = null;
    static final int ARRAY_SIZE = 100;
    static final int FULL_TOKEN_SIZE = 5;
    static final int TOKEN_MINUS_SIZE = 4;
    static final int NO_TOKEN_SIZE = 0;
    static File inputFile;
    static BufferedReader inStream;
    static BufferedWriter goodFileOut, errorFileOut;
    static String inputArray[];
    static int lines = 0;

  public static void main(String[] args)
  {
    getFileNameAndPath();
    openInputFile();
    fillInputArray();
    testDisplayAdvisorsObjects(DynamicConstruct());
  }  //end main

  public static void closeInStream()
  {
    try
    {
      inStream.close();
    }
    catch (IOException e3)
    {
      e3.printStackTrace(System.err);
      System.exit(-1);
    }
  } // end close method

  public static void getFileNameAndPath()
  {
    String filePath = null;
    Scanner scanIn = new Scanner(System.in);
    System.out.println("\nEnter the full absolute path and name of file");
    filePath = scanIn.nextLine();
    inputFile = new File(filePath);
    scanIn.close();
  }// end method

  public static void openInputFile()
  {
    try
    {
      FileReader fileReader = new FileReader(inputFile);
      inStream = new BufferedReader(fileReader);
    }
    catch (IOException e1)
      {
      e1.printStackTrace(System.err);
      System.exit(-1);
      }
  } // end method openInputFile()

  public static void fillInputArray()
  {
    inputArray = new String[ARRAY_SIZE];
    String line = "";
    int i = 0;
    try
    {
      line = inStream.readLine();
      //System.out.println(line);
      while (line != EOF)
      {
        inputArray[i] = line;
        lines++;
        line = inStream.readLine();
        i++;
      }
    }
    catch (IOException e2)
    {
      e2.printStackTrace(System.err);
      System.exit(-1);
    }
    finally
    {
      closeInStream();
    }
  }

  public static Advisors[] DynamicConstruct()
  {
    String tmp_fName = "";
    String tmp_lName = "";
    String tmp_id = "";
    String tmp_major = "";
    String advi = "";
    int tmp_advis;
    int tokens = 0;
    String line = "";
    Advisors[] advisorsArray = new Advisors[ARRAY_SIZE];
    for (int i = 0; i < lines; i++)
    {
      StringTokenizer arrayStrT = new StringTokenizer(inputArray[i], "|");
      line = inputArray[i];
      tokens = arrayStrT.countTokens();
      switch(tokens)
      {
        case FULL_TOKEN_SIZE :
          tmp_lName = arrayStrT.nextToken();
          tmp_fName = arrayStrT.nextToken();
          tmp_id = arrayStrT.nextToken();
          tmp_major = arrayStrT.nextToken();
          advi = arrayStrT.nextToken();
          tmp_advis = Integer.parseInt(advi);
          Advisors myObjVar_1 = new Advisors(tmp_fName, tmp_lName, tmp_id,
            tmp_major, tmp_advis);
          advisorsArray[i] = myObjVar_1;
          break;

        case TOKEN_MINUS_SIZE :
          tmp_lName = arrayStrT.nextToken();
          tmp_fName = arrayStrT.nextToken();
          tmp_id = arrayStrT.nextToken();
          tmp_major = arrayStrT.nextToken();
          Advisors my_ObjVar_2 = new Advisors(tmp_fName, tmp_lName, tmp_id,
            tmp_major);
          advisorsArray[i] = my_ObjVar_2;
          break;

        case NO_TOKEN_SIZE :
          Advisors my_ObjVar_3 = new Advisors();
          advisorsArray[i] = my_ObjVar_3;
          break;
      }  //end switch
    } //end for
    return advisorsArray;
  }  //end method dynamicConstruct

  public static void testDisplayAdvisorsObjects(Advisors[] advisorsArray)
  {
    int index = 0;
    String divider = "*******************************************************";
    Font monoSpace = new Font("Courier", Font.BOLD, 20);
    JTextArea outputArea = new JTextArea("TOTAL ADVISOR COUNT: " +
              Advisors.getAdvisorCount() + "\n" + divider + "\n", 18, 30);

    while(advisorsArray[index] != null)
    {
      outputArea.append("Last Name: " + advisorsArray[index].getLastName()+"\n"
        + "First Name: " + advisorsArray[index].getFirstName() + "\n"
          + "Full Name: " + advisorsArray[index].getFullName() + "\n"
            + "ID: " + advisorsArray[index].getAdvisorId() + "\n"
              + "Major: " + advisorsArray[index].getMajor() + "\n"
                + "Assignees: " + advisorsArray[index].getAssignees() + "\n"
                  + divider + "\n");
      index++;
    } // end while loop
    JScrollPane scroller = new JScrollPane(outputArea);
      outputArea.setFont(monoSpace);
    JOptionPane.showMessageDialog(null, scroller,
        "Advisor Application Testing Display", JOptionPane.PLAIN_MESSAGE);
  } // end testDisplayAdvisorsObjects()
} //end class

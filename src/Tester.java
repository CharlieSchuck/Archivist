//CHARLES SCHUCK
//PROGRAM NUMBER WHO KNOWS
//DUE 4/8/2020
//THIS PROGRAM TAKES A TEXT FILE, HASHES IT, SORTS IT, DISPLAYS IT IN ORDER WITH LINE NUMBERS AND SUCH.
//honestly, this program was a good time!

import java.io.*;
import java.util.Scanner;
//im going to use scanner to read because it has a nifty "line by line" reading feature.

public class Tester {
    public static void main(String[] args)throws IOException {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please specify a size for the hash table that is at least greater than the number of unique words in the file, to the best of your ability.");
        int hashsize = sc1.nextInt();

        Archivist a = new Archivist(hashsize);
        int rowcounter = 0;
        String line = " ";

        Scanner sc2 = new Scanner(new FileInputStream("data.txt"));
        while(sc2.hasNextLine()){
            rowcounter++;
            line = sc2.nextLine();

            a = lineProcessing(a, hashsize, line, rowcounter);
        }

        a.sortTable();
        //a.testtable();
    }

    public static Archivist lineProcessing(Archivist a, int hashsize, String line, int rowcounter){
        String temp = "";


        for(int i = 0; i <= line.length() - 1; i++){
            //if the current character is a letter on the ascii table and nothing else.
            //THIS PROGRAM ASSUMES THAT EVERY LINE BEGINS WITH A LETTER, NOT ANY OTHER CHARACTER.
            if((line.charAt(i) >= 65 && line.charAt(i) <= 90) || (line.charAt(i) >= 97 && line.charAt(i) <= 122)){
                if(line.charAt(i) >= 65 && line.charAt(i) <= 90){
                    char temp1 = (char) (line.charAt(i) + 32);
                    temp = temp + temp1;
                }
                else{
                    temp = temp + line.charAt(i);
                }
                //System.out.println(temp);
            }
            else{
                if(temp != "") {
                    a.hashIntoTable(temp, rowcounter);
                }
                temp = "";
            }

        }
        return a;
    }
}

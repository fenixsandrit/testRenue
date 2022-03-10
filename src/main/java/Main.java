import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        AirportDispatcher ad;

        if(args.length != 0)
            ad = new AirportDispatcher(args[0]);
        else
            ad = new AirportDispatcher();


        System.out.println("Enter the string:");
        String str = in.nextLine();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++)
            if(str.charAt(i)!=' '){
                flag = true;
                break;
            }
        if(!flag)str = "";

        ad.execute(str);

    }
}

package com.company;
import java.util.Scanner;


public class Helper {


    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 's' to configure password creation settings or anything else to skip");

        String inputLine = input.next();

        boolean useLower = true;
        boolean useUpper = true;
        boolean useDigits = false;
        boolean useSymbol = false;

        if (inputLine.contains("s")){
            System.out.println("Configuration. Type 'y' if agree ");
            System.out.println("Would you like to use lower case? ");
            String line = input.next();
            if (line.endsWith("y")){
                useLower = true;
            }
            System.out.println("Would you like to use upper case? ");
            line = input.next();
            if (line.endsWith("y")){
                useUpper = true;
            }
            System.out.println("Would you like to use digits? ");
            line = input.next();
            if (line.endsWith("y")){
                useDigits = true;
            }
            System.out.println("Would you like to use '._-' symbols ? ");
            line = input.next();
            if (line.endsWith("y")){
                useSymbol = true;
            }
        }
        System.out.println("Enter password length ");
        int passwordLength = input.nextInt();


        //System.out.println("passwordLength = " +passwordLength);


                PassGen passwordCreate = new PassGen.PassGenBuilder()
                        .useLow(useLower)
                        .useUpp(useUpper)
                        .useNumbers(useDigits)
                        .useSymbols(useSymbol)
                        .build();

                String password = passwordCreate.generate(passwordLength);
                System.out.println("Fresh & cool generated password: " + password);







    }


}

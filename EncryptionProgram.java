import java.io.*;
import java.util.*;
public class EncryptionProgram
{
    public String getCiphertext() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("/Users/cmwalstu/Desktop/Misc/BlueJProjects/FrequencyAnalysis/test.txt"));
        // This isn't working well, consider using Scanner(File("filename"));
        String ciphertext = "";
        boolean done = false;
        while (scan.hasNext())
        {
            ciphertext += scan.nextLine();
        }
        ciphertext = ciphertext.toUpperCase();
        System.out.println("This is what the ciphertext says: " + ciphertext);
        return ciphertext;
    }

    public void analyzeFrequency(String text)
    {
        int length = text.length(), totalchars = 0, increment = 0;
        char character;
        int[] alphaArray = new int[26];        
        for (char i = 'A'; i <= 'Z'; i++)
        {
            int count = 0;
            for (int j = 0; j < length; j++)
            {
                character = text.charAt(j);
                if (character == i)
                {
                    count++;
                    totalchars++;
                }
            }
            alphaArray[increment] = count;
            increment++; 
        }
        character = 'A';
        System.out.println("Total alphabetical characters = " + totalchars);
        System.out.println("Character\t# of\t\t%");
        System.out.println("_________\t____\t\t__\n");
        for (int ind = 0; ind < 26; ind++)
        {
            // float percentage = alphaArray[ind]/totalchars;
            System.out.println((char) (character + ind) + "\t\t" + alphaArray[ind] 
                + "\t\t" + (float) alphaArray[ind]/totalchars);
        }
    }

    public void modOperations()     //This method lets you get the mod of
    {       //a product of integers (a and b)
        boolean done = false;
        while (!done)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input a mod value: ");
            int mod = scan.nextInt();
            System.out.println("Want a*b. \nEnter a: ");
            int a = scan.nextInt();
            System.out.println("Enter b ");
            int b = scan.nextInt();
            int n = a * b;
            System.out.println("" + n + " mod " + mod + " = " + (n % mod));
            System.out.println("Would you like to try again? ('no') will end loop");
            String comparison = scan.next();
            if (comparison.compareTo("no") == 0)
            {
                done = true;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        EncryptionProgram f = new EncryptionProgram();
        // f.modOperations();
        String thingToAnalyze = f.getCiphertext();
        f.analyzeFrequency(thingToAnalyze);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package akena.ugandawordcounter;

/**
 *
 * @author DELL
 */
import java.util.Scanner;  

public class UgandaWordCounter {  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        System.out.println("Enter book description:");  
        String description = input.nextLine();  

        String[] words = description.toLowerCase().split("\\s+");  
        int count = 0;  

        for (String word : words) {  
            if (word.equals("uganda")) {  
                count++;  
            }  
        }  

        System.out.println("The word 'Uganda' appears " + count + " times.");  
    }  
}  
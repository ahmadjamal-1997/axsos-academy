import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
public class  Puzzle{

    public void getTenRolls(){
        Random randMachine =  new Random();
        int[] numbers;
        numbers = new int[10];
        int bound = 20;
        for (int i=0 ; i<10 ; i++){
            int random = randMachine.nextInt(bound);
            numbers[i] = random;
        }
        System.out.println(Arrays.toString(numbers));
        
        }

    public void getRandomLetter(){
        Random randMachine =  new Random();
        char [] letter = new char[26];
        String characters = "abcdefghijklmnopqrstuvwxys";

        for (int i=0 ; i<26; i++){
            int randomInt = randMachine.nextInt(characters.length());
            letter[i] = characters.charAt(randomInt);
        }
        System.out.println(Arrays.toString(letter));


    }
    public String generatePassword(){
        Random randMachine =  new Random();
        String password ="";
        String characters = "abcdefghijklmnopqrstuvwxys";
        for (int i=0 ; i<8; i++){
            int randomInt = randMachine.nextInt(characters.length());
            char letter= characters.charAt(randomInt);
            password +=letter;
        }
        // System.out.println(password);
        return password;
    }
    public void getNewPasswordSet(int length){
        String[] passwords = new String[length];

        for (int j=0 ; j<length ; j++){
            String password = generatePassword();
            passwords[j] = password;
        }
        System.out.println(Arrays.toString(passwords));
    }
    
        
    }

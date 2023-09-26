import java.util.Random;

//this class will work as the backend and generate the password
public class PasswordGenerator  {
    //character pools
    //these strings will hold the character/number/symbols that we are going to randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS = "qwertyuioplkjhgfdsazxcvbnm";
    public static final String UPPERCASE_CHARACTERS = "QWERTYUIOPLKJHGFDSAZXCVBNM";
    public static final String NUMBERS = "1234567890";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_+-=[]{}:;<>,.?/";

    //the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    //constructor
    public PasswordGenerator(){random = new Random();}

    //length of the password to be generated (taken from the user)
    public String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase, boolean includeNumbers, boolean includeSpecialSymbols){
        //we will use string builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        //store  valid characters (toggle states)
        String validCharacters = " ";
        if(includeUpperCase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowerCase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        //build password
        for(int i = 0; i < length; i++){
            //generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);

            //do this until we have reached the length that the user has provided to us
        }

        //return the result
        return passwordBuilder.toString();
    }
}

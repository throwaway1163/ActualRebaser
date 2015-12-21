import java.util.Arrays;

/**
 * Rebaser class converts n from one base to another.
 */
public class Rebaser
{
    //Instance field
    private String number;
    private int[] array = new int[32];
    private int baseNumber;
    int highestChar = 0;

    //Constructor
    /**
     * Constructor for the Rebaser class
     */
    public Rebaser()
    {
        this.number = "0";
    }
    
    /**
     * Constructor for the Rebaser class
     */
    public Rebaser(String value)
    {
        setValue(value);
    }
    
    //Methods
    /**
     * Changes the input to n
     * @param value the integer that the value is being changed to
     */
    public void setValue(String value)
    {
        value = value.toUpperCase();
        this.number = value;
        int length = value.length();
        char digit;
        for (int position = 1; position <= length; position++)
        {
            digit = value.charAt(length - position);
            if (!((digit >= 'A' && digit <= 'F') || (digit >= '0' && digit <= '9')))
            {
                this.number = "0";
                break;
            }
        }
        makeArray();
    }
    
    /**
     * Returns the current stored value
     * @return the stored value
     */
    public String getValue()
    {
        return this.number;
    }
    
    public String convertToBaseN(int n)
    {
        if (highestChar < 10)
        {
            baseNumber = 10;
            changeBase(n);
            return number;
        }
        else return "-1";
    }
    
    public String convertToBaseTen(int n)
    {
        if (highestChar < n)
        {
            baseNumber = n;
            changeBase(10);
            return number;
        }
        else return "-1";
    }
    
    private void makeArray()
    {
        int length = number.length();
        int stringPosition = 0;
        for(int arrayPosition = 32 - length; arrayPosition < 32; arrayPosition++)
        {
            char digit = number.charAt(stringPosition);
            stringPosition++;
            
            if(digit == '0'){
                array[arrayPosition] = 0;
            }
            else if(digit == '1'){
                array[arrayPosition] = 1;
                if(highestChar < 1)
                    highestChar = 1;
            }
            else if(digit == '2'){
                array[arrayPosition] = 2;
                if(highestChar < 2)
                    highestChar = 2;
            }
            else if(digit == '3'){
                array[arrayPosition] = 3;
                if(highestChar < 3)
                    highestChar = 3;
            }
            else if(digit == '4'){
                array[arrayPosition] = 4;
                if(highestChar < 4)
                    highestChar = 4;
            }
            else if(digit == '5'){
                array[arrayPosition] = 5;
                if(highestChar < 5)
                    highestChar = 5;
            }
            else if(digit == '6'){
                array[arrayPosition] = 6;
                if(highestChar < 6)
                    highestChar = 6;
            }
            else if(digit == '7'){
                array[arrayPosition] = 7;
                if(highestChar < 7)
                    highestChar = 7;
            }
            else if(digit == '8'){
                array[arrayPosition] = 8;
                if(highestChar < 8)
                    highestChar = 8;
            }
            else if(digit == '9'){
                array[arrayPosition] = 9;
                if(highestChar < 9)
                    highestChar = 9;
            }
            else if(digit == 'A'){
                array[arrayPosition] = 10;
                if(highestChar < 10)
                    highestChar = 10;
            }
            else if(digit == 'B'){
                array[arrayPosition] = 11;
                if(highestChar < 11)
                    highestChar = 11;
            }
            else if(digit == 'C'){
                array[arrayPosition] = 12;
                if(highestChar < 12)
                    highestChar = 12;
            }
            else if(digit == 'D'){
                array[arrayPosition] = 13;
                if(highestChar < 13)
                    highestChar = 13;
            }
            else if(digit == 'E'){
                array[arrayPosition] = 14;
                if(highestChar < 14)
                    highestChar = 14;
            }
            else if(digit == 'F'){
                array[arrayPosition] = 15;
                if(highestChar < 15)
                    highestChar = 15;
            }
            else
            {
                System.out.println("Error, invalid input");
                break;
            }
        }
    }
    
    private String arrayToString()
    {
        String outputString = "";
        int digit = 0;
        boolean firstDigitPassed = false;
        while (digit >= 0 && !firstDigitPassed)
        {
            if (array[digit] != 0)
            {
                firstDigitPassed = true;
            }
            else
            {
                digit++;
            }
            if (digit > 31) break;
        }
        while (digit < 32)
        {
            if (array[digit] > 15)
            {
                return "digit exceed bounds of hexadecimal notation";
            }
            else if (array[digit] == 10)
                outputString += "A";
            else if (array[digit] == 11)
                outputString += "B";
            else if (array[digit] == 12)
                outputString += "C";
            else if (array[digit] == 13)
                outputString += "D";
            else if (array[digit] == 14)
                outputString += "E";
            else if (array[digit] == 15)
                outputString += "F";
            else
                outputString += Integer.toString(array[digit]);
            digit++;
        }
        return outputString;
    }
    
    private void changeBase(int newBase)
    {
        int tempInt = 0;
        for(int digit = 31; digit >= 0; digit--)
        {
            tempInt += array[digit] * (int)Math.pow(baseNumber, 31 - digit);
        }
        Arrays.fill(array, 0);
        for(int digit = 0; digit < 32; digit++)
        {
            int digitPower = (int)Math.pow(newBase, 31 - digit);
            if((tempInt / digitPower) >= 1)
            {
                array[digit] = tempInt / digitPower;
                tempInt = tempInt % digitPower;
            }
        }
        baseNumber = newBase;
        number = arrayToString();
    }

}
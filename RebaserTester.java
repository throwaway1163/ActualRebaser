public class RebaserTester {

    public static void main(String[] args) {
        Rebaser test = new Rebaser();
        int min = 0;
        int max = Integer.MAX_VALUE;
        
        for(int base = 2; base < 17; base++)
        {
            for(int input = min; input <= max; input++)
            {
                String inputString = Integer.toString(input);
                test.setValue(inputString);
                inputString = Integer.toString(Integer.parseInt(inputString, base));
                String compare = test.convertToBaseTen(base);
                inputString = Integer.toString(input);
                if (!(inputString == compare))
                {
                    System.out.println("convertToBaseTen error:");
                    System.out.println("on base " + base);
                    System.out.println("and input " + input);
//                    break;
                }
                else System.out.println("Victory");
            }
            
            for(int input = min; input <= max; input++)
            {
                String inputString = Integer.toString(input);
                test.setValue(inputString);
                inputString = Integer.toString(Integer.parseInt(inputString, base));
                String compare = test.convertToBaseN(base);
                if (!(inputString == compare))
                {
                    System.out.println("convertToBaseN error:");
                    System.out.println("Error on base " + base);
                    System.out.println("and input " + input);
//                    break;
                }
                else System.out.println("Victory");
            }
            
            System.out.println("Checked for base: " + base);
        }
    }

}
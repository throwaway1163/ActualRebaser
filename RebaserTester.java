public class RebaserTester {

    public static void main(String[] args) {
        Rebaser test = new Rebaser();
        int input = 0;
        int max = Integer.MAX_VALUE;
        
        for(int base = 2; base < 17; base++)
        {
            for(input = 0; input <= max && input > -1; input += 100000)
            {
                String inputString = Integer.toString(input, base);
                test.setValue(inputString);
                inputString = Integer.toString(Integer.parseInt(inputString, base));
                String compare = test.convertToBaseTen(base);
                inputString = Integer.toString(input);
                if (!(compare.equals(inputString)))
                {
                    System.out.println("convertToBaseTen error:");
                    System.out.println("on base " + base);
                    System.out.println("and input " + input);
                    System.out.println(compare + " " + inputString);
                    break;
                }
                if (input % 1000000 == 0) System.out.println(input);
            }
            for(input = 0; input <= max && input > -1; input += 100000)
            {
                String inputString = Integer.toString(input);
                inputString = Integer.toString(input);
                test.setValue(inputString);
                inputString = Integer.toString(input, base);
                String compare = test.convertToBaseN(base);
                if (!(compare.equals(inputString)))
                {
                    System.out.println("convertToBaseN error:");
                    System.out.println("Error on base " + base);
                    System.out.println("and input " + input);
                    System.out.println("Comparison " + inputString + " " + compare);
//                    break;
                }
            }
            
            System.out.println("Checked for base: " + base);
        }
    }

}
public class RebaserTester {

    public static void main(String[] args) {
        Rebaser test = new Rebaser();
        test.setValue("100000000000000000");
        System.out.println(test.convertToBaseTen(2));
    }

}

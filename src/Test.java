
public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        boolean productsAreDisplayed = true;
        long startTime = System.currentTimeMillis();

        while (productsAreDisplayed) {
            System.out.println("it works");

            if ((System.currentTimeMillis() - startTime) > 10000) {
                break;
            }
        }
    }

}

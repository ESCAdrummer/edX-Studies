public class Main {

    public int gcd(int x, int y) {

        if (y == 0) {return x;}
        else {
           int remainder = x%y;
            return gcd(y,remainder);
        }

    }

    public int factorial (int x){

        if (x ==1) {return x;}
        else{
            System.out.println(x);
            return x*factorial(x-1);
        }

    }

    public int mario (int x) {

        if (x==1){
            System.out.print("x");
            return 1;
        }
        else {
        for (int i = 1; i <= x ; i++){
            System.out.print("x");
        }
        System.out.println();
        return mario(x-1);
        }
    }

    public static void main(String[] args) {
/*
        Main test = new Main();
        System.out.println(test.gcd(60,24));
        System.out.println(test.factorial(10));
        int result = test.mario(5);
*/

/*
        ArrayList<Integer> test = new ArrayList<>();

        test.addToFront(3);
        test.addToBack(1250);

        test.removeFromBack();
        test.removeFromFront();
        //if needed to test: import java.util.Arrays;
        //System.out.println(Arrays.toString(backingArray) + " and size is: " + size + " and dimension is " + backingArray.length);
*/

        SinglyLinkedList<Integer> test2 = new SinglyLinkedList<>();

        test2.addToFront(23);
        test2.addToFront(24);
        test2.addToFront(25);
        test2.addToBack(12);
        System.out.println(test2.getHead().getData());
        System.out.println(test2.getHead().getNext().getData());
        System.out.println(test2.getTail().getData());
        test2.removeFromFront();
        test2.removeFromBack();

    }
}
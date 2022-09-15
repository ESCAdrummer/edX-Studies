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
        test.print();
        test.addToBack(1250);
        test.print();

        test.removeFromBack();
        test.print();
        test.removeFromFront();
        test.print();
*/

/*
        SinglyLinkedList<Integer> test2 = new SinglyLinkedList<>();

        test2.print();
        test2.addToFront(23);
        test2.print();
        test2.addToFront(24);
        test2.print();
        test2.addToFront(25);
        test2.print();
        test2.addToBack(12);
        test2.print();
        test2.removeFromFront();
        test2.print();
        test2.removeFromBack();
        test2.print();
 */
 /*
        ArrayQueue<Integer> test3 = new ArrayQueue<>();
        test3.print();
        test3.enqueue(1);
        test3.print();
        test3.enqueue(2);
        test3.print();
        test3.enqueue(3);
        test3.print();
        test3.dequeue();
        test3.print();
        test3.dequeue();
        test3.print();
        test3.dequeue();
        test3.print();
        test3.enqueue(1);
        test3.print();
*/
/*
        SinglyLinkedList<String> exam = new SinglyLinkedList<>();

        exam.addToBack("Mary");
        exam.addToBack("Andrew");
        exam.addToBack("Stephanie");
        exam.addToBack("Ivan");
        exam.addToBack("Miguel");
        exam.addToBack("Adrianna");

        exam.print();

        exam.mystery(exam.getHead());
*/

    }
}
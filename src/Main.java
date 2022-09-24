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
        //EDX Studies on Data Structures and Algorithms.
        //Implementations of these Data Structures.

/*
        //Part I Java basics in recursion.
        Main test = new Main();
        System.out.println(test.gcd(60,24));
        System.out.println(test.factorial(10));
        int result = test.mario(5);
*/

/*
        //Part I ArrayList
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
        //Part I LinkedList
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
        //Part I Queue
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
        //Part I Final Exam
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

        //Part II Binary Trees Traversals

/*
        TreeNode<Integer> addition1 = new TreeNode<>(50);
        TreeNode<Integer> addition2 = new TreeNode<>(25);
        TreeNode<Integer> addition3 = new TreeNode<>(10);
        TreeNode<Integer> addition4 = new TreeNode<>(100);
        TreeNode<Integer> addition5 = new TreeNode<>(75);
        TreeNode<Integer> addition6 = new TreeNode<>(125);
        TreeNode<Integer> addition7 = new TreeNode<>(110);

        addition1.setLeft(addition2);
        addition2.setLeft(addition3);
        addition1.setRight(addition4);
        addition4.setLeft(addition5);
        addition4.setRight(addition6);
        addition6.setLeft(addition7);

        Traversals<Integer> test4 = new Traversals<>();

        System.out.println(test4.preorder(addition1));
        System.out.println(test4.inorder(addition1));
        System.out.println(test4.postorder(addition1));
*/



//int x =~ 0x7ffffff | 0x2;
//System.out.println(Integer.toHexString(x));

//String a = "test";
//a.concat("B");

//System.out.println(a.concat("B"));

//
/*
int a=0, b=0;
while (a<3)
{
    switch (a+b) {
        case 0: a++;
        case 1:
        case 2: b++; break;
        case 3: a++; break;
        default: b=0; break;
    }
    System.out.println(b);
}
*/
/*
        stringShifter test = new stringShifter();

        String s = "Stringshift test";
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftLeft(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
        s = test.shiftRight(s);
        System.out.println(s);
*/


        //Part II BST Operations

    }
}
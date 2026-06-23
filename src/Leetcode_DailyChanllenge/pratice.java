package Leetcode_DailyChanllenge;



class A {

    {
        System.out.println("Init Block");
    }
    A() {
        System.out.println("Parent Constructor");
    }
}

class B extends A {



    B() {
        System.out.println("Child Constructor");
    }
}
class Test {





    Test() {
        System.out.println("Constructor");
    }

    static {
        System.out.println("Static Block");
    }
}
public class pratice {
    public static void main(String[] args) {
//        Test t1 = new Test();
//        Test t2 = new Test();

        B b=new B();
    }
}

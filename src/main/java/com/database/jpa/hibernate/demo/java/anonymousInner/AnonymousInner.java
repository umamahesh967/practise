package com.database.jpa.hibernate.demo.java.anonymousInner;

/**
 * This way of final or effective final is applicable only from java 8. Before that we have
 * to explicitly set variable as final.
 *
 * AnonymousInner:- It is an inner class without a name and for which only a single object is created.
 * Since they have no name, we can't use them in order to create instances of anonymous classes.
 * As a result, we have to declare and instantiate anonymous classes in a single expression at the point of use.
 *
 * https://www.geeksforgeeks.org/anonymous-inner-class-java/
 * https://www.baeldung.com/java-anonymous-classes
 * Java 9 Anonymous inner class minor enhancement https://www.javatpoint.com/java-9-anonymous-classes.
 */
public class AnonymousInner
{
    static int ab =10;
    int bb =10;
    public static void main(String[] args) throws InterruptedException {
        ab=20;
        int a = 10;
//        a =40;
        AnonymousInner anonymousInner = new AnonymousInner();
        Thread t = new Thread()
        {
            //This variable is declared to explain point 4 in diff of below image.
            int xyz = 10; //We can declare class level variable in anonymous variables. But not in lambda function.
            public void run()
            {
                /**
                 * If line 22 is uncommented(i.e a=40) then we will get CE in below line(42).
                 * CE: local variables referenced from an inner class must be final or effectively final.
                 * We will get above CE only with Method scope variables, not with class level variables.
                 *
                 *
                 * Local variables(Method scope variables) which are referenced from anonymous inner class must be final or effectively final.
                 * Hence with in the anonymous inner class or outside the anonymous inner class we can't change
                 * the value of the local variables which are referenced from anonymous inner class.
                 *
                 * If you are not using local variable in anonymous inner class we can change the value in method scope.
                 */
                 System.out.println("Child Thread: "+a);

                 int a =10;
                System.out.println("Child Thread: "+ab);
                System.out.println("Child Thread: "+anonymousInner.bb);
                anonymousInner.bb=30;
                System.out.println("Child Thread: "+anonymousInner.bb);
                ab=50;
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println("Main Thread: "+ab);
        System.out.println("Main Thread");
    }

}

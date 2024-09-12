package com.database.jpa.hibernate.demo.java.exceptionClass;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * For all type of exceptions Throwable is super class. It has two main subclasses.
 * 1.Error
 * 2.Exception
 *
 * @Error
 * Error type exceptions are thrown due to problems occur inside JVM logic,
 * Ex:- StackOverFlowError or OutOfMemoryError
 *
 * @SubClassesOfRunTimeExceptions
 * RunTimeException subclasses represent the logical mistakes occurred due to operator execution failure.
 * It means these exceptions are prepared and thrown by JVM at runtime when operator execution is failed.
 * Ex:- ArithmeticException
 *
 * @DirectSubClassesOfException
 * Exception class direct subclasses represent the logical mistake occurred due to condition failure because of
 * the wrong input. These exception are prepared and thrown by developer by using throw keyword.
 * Ex:- ClassNotFoundException,
 * let say if we are retrieving amount from bank(no balance) then we should
 * throw InSufficientFundsException which extends Exception which needs to handled by user.
 *
 *
 * All exceptions hierarchy every Throwable exception is class, so all subclasses are classes only.
 *
 * Exception are divided into two categories.
 * 1.Checked Exception
 * 2.Unchecked Exception
 *
 * When an exception is thrown by developer using throws keyword if that exception handling is checked
 * by compiler then that exception is called checked exception, else that exception is called unchecked exception.
 *
 * Error and it's subclasses, RuntimeException & it's subclasses are called Unchecked Exception because
 * these exception handling is not checked by compiler when they are thrown by using throws keyword.
 * It means these exception objects catching or reporting is optional.
 *
 * Throwable, Exception and it's direct subclasses are called checked exceptions because if they are thrown
 * by using throw keyword compiler checks their handling and if they are not caught by using "try/catch" or
 * not reported by using "throws" keyword, compiler throws.
 * CE: "unreported exception must be caught or declared to be thrown".
 *
 * Custom Exception
 * If a client can reasonably be expected to recover from an exception, make it a checked exception.
 * If a client cannot do anything to recover from the exception, make it an unchecked exception.
 *
 */
public class AboutExceptionHierarchy
{
    public static void main(String[] args) throws Exception {
//        try {
//            throw new Exception();
//        }
//        catch (FileNotFoundException exception)
//        {
//
//        }
//        catch (EOFException exception)
//        {
//
//        }
        throw new RuntimeException();
    }
}

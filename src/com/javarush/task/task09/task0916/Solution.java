package com.javarush.task.task09.task0916;
import java.io.IOException;
import java.rmi.RemoteException;
/**
 * Created by KorobovAV on 05.09.2017.
 */
public class Solution {
    public static void main(String[] args) {
        try {
            processExceptions(new Solution());
        }
        catch (Exception e) {

        }

    }

    public static void processExceptions(Solution obj) throws IOException, NoSuchFieldException, RemoteException {
        try {

            obj.method1();
            obj.method2();
            obj.method3();

        }

        catch (NoSuchFieldException e) {
            System.out.println(e.getClass());
        }
        catch (RemoteException e) {
            System.out.println(e.getClass());
        }
        catch (IOException e) {
            System.out.println(e.getClass());
        }

    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}

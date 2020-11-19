/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labfourn;

import javafx.scene.text.Text;
import java.lang.ClassCastException;

/**
 *
 * @author User
 */
public class Operations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operations operations = new Operations();
        System.out.println(operations.isEven(6));
        try {
            int[] operation = null;
            System.out.println(operations.bitNumber(operation));
            if (operation == null) {
                throw new CalculationException();
            }
        } catch (CalculationException | NullPointerException e) {
            System.out.println("Array can not be null");
        }
        try {
            Object[] arrayReplace = null;
            System.out.println(operations.replaceRefences(arrayReplace));
        } catch (CalculationException | NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(operations.replaceChar('\''));

    }

    public boolean isEven(int number) {
        return ((number & 1) == 0);
    }

    public int bitNumber(int[] array) throws CalculationException {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[i] > 0) {
                count += array[i] + 1;
            }
            array[i] >>= 1;
        }
        return count;
    }

    public int replaceRefences(Object[] array) throws CalculationException, NullPointerException {
        int replaces = 0;
        for (int i = 0; i < array.length; i++) {
            if (!(array instanceof Text)) {
                array[i] = new Text();
                replaces++;
            }
        }

        return replaces;
    }

    public char replaceChar(char c) {
        switch (c) {
            case ' ':
                c = '\n';
            case '\t':
                c = '\n';
            case '\\':
                c = '/';
            case '\'':
                c = '\"';
        }

        return c;
    }
}

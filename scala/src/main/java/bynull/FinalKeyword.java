package bynull;

import java.lang.reflect.Field;

/**
 * Created by null on 4/27/16.
 */
public class FinalKeyword {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        FinalClass obj = new FinalClass();

        System.out.println(obj.variable);

        Field f = obj.getClass().getDeclaredField("variable"); //NoSuchFieldException
        f.setAccessible(true);
        f.set(obj, 456);

        System.out.println(obj.variable);
    }

    public static class FinalClass {
        public final Integer variable = 123;
    }
}

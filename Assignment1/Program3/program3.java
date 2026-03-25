//Problem Statement:
// Write a Java program demonstrating of Wrapper Classes and String vs StringBuffer

public class WrapperDemo {
    public static void main(String[] args) {
        
        //  Wrapper Classes Example 
        int primitiveInt = 10;
        // Boxing: converting primitive to object
        Integer wrappedInt = Integer.valueOf(primitiveInt);
        // Unboxing: converting object back to primitive
        int unboxedInt = wrappedInt.intValue();
        
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapped Integer: " + wrappedInt);
        System.out.println("Unboxed int: " + unboxedInt);

        // Other wrapper classes
        Double wrappedDouble = Double.valueOf(12.34);
        Character wrappedChar = Character.valueOf('A');
        Boolean wrappedBool = Boolean.valueOf(true);

        System.out.println("Wrapped Double: " + wrappedDouble);
        System.out.println("Wrapped Character: " + wrappedChar);
        System.out.println("Wrapped Boolean: " + wrappedBool);

        // Difference String vs StringBuffer 
        // String is immutable
        String str = "Hello";
        str.concat(" World"); // does not change original string
        System.out.println("String after concat: " + str); // still "Hello"

        // StringBuffer is mutable
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World"); // modifies the original object
        System.out.println("StringBuffer after append: " + sb); // "Hello World"
    }
}

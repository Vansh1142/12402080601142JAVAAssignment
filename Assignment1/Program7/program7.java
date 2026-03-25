// Problem Statement:
// Inner classes - member, local, anonymous

class Outer {

    String msg = "Hi from Outer Class"; // Instance variable accessible by inner classes

    // Member Inner Class (defined inside Outer class, but outside methods)
    class MemberInner {
        void show() {
            // Can directly access Outer class members
            System.out.println("Member Inner Class: " + msg);
        }
    }

    // Local Inner Class (defined inside a method)
    void localInnerDemo() {
        // Local inner class exists only within this method
        class LocalInner {
            void show() {
                System.out.println("Local Inner Class: " + msg);
            }
        }
        // Create object of local inner class and call method
        LocalInner li = new LocalInner();
        li.show();
    }

    // Anonymous Inner Class (class without a name, usually used for overriding methods)
    void anonDemo() {
        // Runnable interface implemented using anonymous inner class
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Anonymous Inner Class: " + msg);
            }
        };
        r.run(); // Execute run method
    }
}

class InnerClasses {

    public static void main(String[] args) {
        Outer o = new Outer();

        // Member Inner Class usage
        Outer.MemberInner mi = o.new MemberInner(); // Create object of inner class
        mi.show();

        // Local Inner Class usage
        o.localInnerDemo();

        // Anonymous Inner Class usage
        o.anonDemo();
    }
}

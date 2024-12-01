package com.coding.jvm03.stack;

/**
 * 体会invokedynamic指令
 */
public class Lambda {
    public void lambda(Func func) {
        return;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();

        Func func = new Func() {
            @Override
            public boolean func(String s) { // invokedynamic
                return true;
            }
        };
        lambda.lambda(func);

        lambda.lambda(new Func() {
            @Override
            public boolean func(String s) {
                return true; // invokedynamic
            }
        });
    }

}

interface Func {
    boolean func(String str);
}

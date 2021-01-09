/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/20
 */
public interface BaseI {

    void method();
}

class BaseC {

    public void method() {
        System.out.println("Inside BaseC::method");
    }
}

class ImplC extends BaseC implements BaseI {

    public static void main(String[] args) {
        (new ImplC()).method();
    }
}

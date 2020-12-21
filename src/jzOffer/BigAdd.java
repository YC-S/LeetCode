/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

import java.math.BigInteger;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/21
 */
public class BigAdd {
    public String solve (String s, String t) {
        // write code here
        BigInteger a = new BigInteger(s).add(new BigInteger(t));
        return a.toString();
    }
}

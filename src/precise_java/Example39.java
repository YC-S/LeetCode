/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class Example39 {

    static class TLC {

        static int sf;
        int nf;

        void nm() {
            class NLC {

                int m(int p) {
                    return sf + nf + p;
                }
            }
        }

        static class SMC {

            static int ssf = sf + TLC.sf;
            int snf = sf + TLC.sf;
        }

        class NMC {

            int nnf1 = sf + nf;
            int nnf2 = TLC.sf + TLC.this.nf;
        }
    }

}

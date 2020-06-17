package org.moyae.copado2;

import org.junit.Assert;
import org.junit.Test;

public class MixingTest {

    @Test
    public void test() {
        System.out.println("Mix Fixed Tests");
        Assert.assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));
        Assert.assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                        Mixing.mix("looping is fun but dangerous", "less dangerous than coding"));
        Assert.assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                                        Mixing.mix(" In many languages", " there's a pair of functions"));
        Assert.assertEquals("1:ee/1:ll/1:oo", Mixing.mix("Lords of the Fallen", "gamekult"));
        Assert.assertEquals("", Mixing.mix("codewars", "codewars"));
        Assert.assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
                Mixing.mix("A generation must confront the looming ","codewarrs"));
    }

}
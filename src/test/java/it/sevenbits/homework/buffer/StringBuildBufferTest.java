package it.sevenbits.homework.buffer;

import org.junit.Assert;
import org.junit.Test;

public class StringBuildBufferTest {
    @Test
    public void testWorkStringBuildBuffer(){
        String trueOutBuffer = "true";
        StringBuilderBuffer buffer = new StringBuilderBuffer();
        for (int i = 0; i < trueOutBuffer.length(); i++) {
            buffer.addChar(trueOutBuffer.charAt(i));
        }
        Assert.assertEquals(trueOutBuffer, buffer.toString());
        buffer.clear();
        Assert.assertEquals("",buffer.toString());

    }
}

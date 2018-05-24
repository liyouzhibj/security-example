package com.liyouzhi.securityexample.sha;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SHA256Test {

    @Test
    public void sha256Test() {
        String sourceStr = "aaabbbcccdddeeefff";
        String result = SHA256.INSTANCE.getSHA256Str(sourceStr);
        Assert.assertEquals("5662CF7AB1070E448A9D28B4D39C188EEBCC91B66F309F9C415C24A815C82A04",result);
    }
}

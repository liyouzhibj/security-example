package com.liyouzhi.securityexample.des;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DES_3Test {
    @Test
    public void des_3Test() {
        String data = "aaabbbcccdddeeefff";
        byte[] key = DES_3.INSTANCE.generateKey();
        byte[] encrypted = DES_3.INSTANCE.encrypt(key, data.getBytes());
        byte[] decrypted = DES_3.INSTANCE.decrypt(key, encrypted);

        String decryptedStr = new String(decrypted);
        Assert.assertEquals(decryptedStr, data);
    }
}

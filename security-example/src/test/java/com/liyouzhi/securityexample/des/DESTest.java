package com.liyouzhi.securityexample.des;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DESTest {

    @Test
    public void desTest(){
        String data = "aaabbbcccdddeeefff";
        byte[] key = DES.INSTANCE.generateKey();
        byte[] encrypted = DES.INSTANCE.encrypt(key, data.getBytes());
        byte[] decrypted = DES.INSTANCE.decrypt(key, encrypted);

        String decryptedStr = new String(decrypted);
        Assert.assertEquals(decryptedStr, data);
    }
}

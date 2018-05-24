package com.liyouzhi.securityexample.des;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DES（Data Encryption Standard，数据加密标准），是对称加密算法领域中的典型算法。
 * 特点：算法公开、计算量小、加密速度快、加密效率高。
 * 弱点：双方都使用同样密钥，安全性得不到保证。
 * */
public enum DES {
    INSTANCE;

    /**
     * 生成密钥
     * */
    public byte[] generateKey() {
        KeyGenerator keyGen = null;//密钥生成器
        try {
            keyGen = KeyGenerator.getInstance("DES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGen.init(56);//初始化密钥生成器
        SecretKey secretKey = keyGen.generateKey();//生成密钥
        byte[] key = secretKey.getEncoded();//密钥字节数组
        return key;
    }


    /**
     * 加密
     * */
    public byte[] encrypt(byte[] key, byte[] data){
        SecretKey secretKey = new SecretKeySpec(key, "DES");//恢复密钥
        Cipher cipher = null;//Cipher完成加密或解密工作类
        byte[] cipherByte = null;

        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);//对Cipher初始化，加密模式
            cipherByte = cipher.doFinal(data);//加密data
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return cipherByte;
    }

    /**
     * 解密
     * */
    public byte[] decrypt(byte[] key, byte[] data){
        SecretKey secretKey = new SecretKeySpec(key, "DES");//恢复密钥
        byte[] cipherByte = null;//解密data
        try {
            Cipher cipher = Cipher.getInstance("DES");//Cipher完成加密或解密工作类
            cipher.init(Cipher.DECRYPT_MODE, secretKey);//对Cipher初始化，解密模式
            cipherByte = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return cipherByte;
    }
}

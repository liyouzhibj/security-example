package com.liyouzhi.securityexample.des;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 3DES（Triple DES、DESede，进行了三重DES加密的算法）。
 * 具有DES算法相同的特点及弱点。
 * DES、3DES对比如下：
 * 3DES：将密钥长度增至112位或168位，通过增加迭代次数提高安全性
 * 缺点：处理速度较慢、密钥计算时间较长、加密效率不高
 * DES：数据加密标准，是对称加密算法领域中的典型算法
 * 特点：密钥偏短（56位）、生命周期短（避免被破解）
 * */
public enum DES_3 {
    INSTANCE;

    /**
     * 生成密钥
     * */
    public byte[] generateKey() {
        KeyGenerator keyGen = null;//密钥生成器
        try {
            keyGen = KeyGenerator.getInstance("DESede");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyGen.init(168); //可指定密钥长度为112或168，默认为168
        SecretKey secretKey = keyGen.generateKey();//生成密钥
        byte[] key = secretKey.getEncoded();//密钥字节数组
        return key;
    }


    /**
     * 加密
     * */
    public byte[] encrypt(byte[] key, byte[] data){
        SecretKey secretKey = new SecretKeySpec(key, "DESede");//恢复密钥
        Cipher cipher = null;//Cipher完成加密或解密工作类
        byte[] cipherByte = null;

        try {
            cipher = Cipher.getInstance("DESede");
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
        SecretKey secretKey = new SecretKeySpec(key, "DESede");//恢复密钥
        byte[] cipherByte = null;//解密data
        try {
            Cipher cipher = Cipher.getInstance("DESede");//Cipher完成加密或解密工作类
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

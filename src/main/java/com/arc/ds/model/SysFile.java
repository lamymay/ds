package com.arc.ds.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

/**
 * 系统文件记录
 */
@Getter
@Setter
@ToString
public class SysFile {

    private static final long serialVersionUID = 1L;

    private Long id;//
    private String name;// 显示名称
    private String suffix;// 后缀
    private Integer version;// 版本信息id
    private String code;// 版本号
    private String key;// 文件标识
    private Long size;// 文件大小
    private String url;// 文件存放url
    private String note;// 描述
    private String checkType;// 校验方式
    private String checkCode;// 校验码
    private Integer state;// 逻辑删除用的标识
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        keygen.initialize(512);
        KeyPair kp = keygen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) kp.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();
        System.out.println("KEY:\n" + bytesToHexString(publicKey.getEncoded()) + "\n");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        System.out.println("RESULT:\n" + bytesToHexString(cipher.doFinal("ilanyu".getBytes())) + "\n");
    }

    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }


}

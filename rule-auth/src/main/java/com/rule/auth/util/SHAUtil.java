package com.rule.auth.util;

import java.security.MessageDigest;

/**
 * SHAUtil
 */
public class SHAUtil {

    /**
     * SHA-1消息摘要
     *
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception java.lang.Exception
     */
    public static byte[] encodeSHA(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA");
        return md.digest(data);
    }

    /**
     * SHA-256消息摘要
     *
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception java.lang.Exception
     */
    public static byte[] encodeSHA256(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data);
    }

    /**
     * SHA-384消息摘要
     *
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception java.lang.Exception
     */
    public static byte[] encodeSHA384(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        return md.digest(data);
    }

    /**
     * SHA-512消息摘要
     *
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception java.lang.Exception
     */
    public static byte[] encodeSHA512(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return md.digest(data);
    }

    /** 
     * 传入文本内容，返回 SHA 串 
     *  
     * @param strText 
     * @return 
     */
    public static String SHA(final String strText) {
        return SHA(strText, "SHA");
    }
    
    /** 
     * 传入文本内容，返回 SHA-256 串 
     *  
     * @param strText 
     * @return 
     */
    public static String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }

    /** 
     * 传入文本内容，返回 SHA-512 串 
     *  
     * @param strText 
     * @return 
     */
    public static String SHA512(final String strText) {
        return SHA(strText, "SHA-512");
    }

    /**
     * 字符串 SHA 加密
     * @param strText
     * @param strType
     * @return
     */
    private static String SHA(final String strText, final String strType) {
        
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes("utf-8"));
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();
                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    public static void main(String args[]) {
        System.out.println(SHA("zaq12wsx"));
        System.out.println(SHA256("hello"));
        System.out.println(SHA512("hello"));
    }
}

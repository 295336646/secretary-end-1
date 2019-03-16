package usts.cl.utils;


import java.security.SecureRandom;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordHash {
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    //盐长
    public static final int SALT_BYTE_SIZE = 24;
    //生成密文长度
    public static final int HASH_BYTE_SIZE = 24;
    //迭代次数
    public static final int PBKDF2_ITERATIONS = 1000;
    //盐和hash值存储在string中，用冒号分隔的位置
    public static final int SALT_INDEX = 0;
    public static final int PBKDF2_INDEX = 1;

    /**
     * 返回密码的加盐哈希值
     */
    public static String createHash(String password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        return createHash(password.toCharArray());
    }

    /**
     * 返回密码的加盐哈希值
     */
    public static String createHash(char[] password)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 生成随机盐值
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTE_SIZE];
        random.nextBytes(salt);

        // 生成哈希值
        byte[] hash = pbkdf2(password, salt, PBKDF2_ITERATIONS, HASH_BYTE_SIZE);
        //迭代:盐:哈希值
        return toHex(salt) + ":" + toHex(hash);
    }

    /**
     * 用哈希盐值验证密码
     */
    public static boolean validatePassword(String password, String correctHash, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        return validatePassword(password.toCharArray(), correctHash, salt);
    }

    /**
     * 用哈希盐值验证密码
     */
    public static boolean validatePassword(char[] password, String correctHash, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        //将16进制字符串形式的salt转换成byte数组
        byte[] salts = fromHex(salt);
        byte[] hash = fromHex(correctHash);
        //使用相同的迭代数和哈希长度还有相同的盐，计算所提供密码的哈希值
        byte[] testHash = pbkdf2(password, salts, PBKDF2_ITERATIONS, hash.length);
        //如果哈希值完全匹配，则密码正确
        return slowEquals(hash, testHash);
    }

    /**
     * 比较同长度的字符数组，如果完全一致则返回true
     */
    private static boolean slowEquals(byte[] a, byte[] b) {
        int diff = a.length ^ b.length;//异或，长度相等diff=0
        for (int i = 0; i < a.length && i < b.length; i++)
            //位或，即如果有一位不同，则diff为1，只要有1，后面的位或后diff始终=1，即匹配不一致
            diff |= a[i] ^ b[i];
        return diff == 0;
    }

    /**
     * 计算密码的哈希值
     */
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        /*
        password-密码。
        salt-盐
        iterationCount-迭代计数
        keyLength-要派生的密钥长度。
         */
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        return skf.generateSecret(spec).getEncoded();
    }

    /**
     * 十六进制转成byte数组
     */
    private static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

    /**
     * byte数组转十六进制
     */
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}

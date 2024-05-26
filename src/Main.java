import java.io.*;
import java.security.*;
import java.util.*;

public class Main{

    public static void main(String[] args) {
        String[] messageDigestAlgorithms = {"MD5", "SHA-1", "SHA-256"};
        String[] secureRandomAlgorithms = {"SHA1PRNG", "DRBG", "Windows-PRNG"};
        String str = "Hello, World!";
        String filename = "Hashed values.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            printAndWrite("TASK 1: MESSAGE DIGEST:", writer);
            for(String algorithm : messageDigestAlgorithms)
                getMessageDigest(algorithm, str, writer);

            printAndWrite("\nTASK 2: SECURE RANDOM", writer);
            for(String algorithm: secureRandomAlgorithms)
                getSecureRandom(algorithm, str, writer);



        printAndWrite("\nTASK 3: CORRECT AND INCORRECT HASH MAPS:", writer);

        GoodCat[] goodCats = {
                new GoodCat("Mira", "Scottish Fold", 6, "Evelina", "Healthy"),
                new GoodCat("Shadow", "Siamese", 2, "John", "Chronic kidney disease"),
                new GoodCat("Vestra", "Street cat", 4, "Lilia", "Healthy"),
                new GoodCat("Hurrem", "Sphynx", 7, "Lilia", "Dental issues"),
                new GoodCat("Mira", "Scottish Fold", 6, "Evelina", "Healthy")
        };

        BadCat[] badCats = {
                new BadCat("Mira", "Scottish Fold", 6, "Evelina", "Healthy"),
                new BadCat("Shadow", "Siamese", 2, "John", "Chronic kidney disease"),
                new BadCat("Vestra", "Street cat", 4, "Lilia", "Healthy"),
                new BadCat("Hurrem", "Sphynx", 7, "Lilia", "Dental issues"),
                new BadCat("Mira", "Scottish Fold", 6, "Evelina", "Healthy")
        };

        System.out.println("TESTING GoodCat BEHAVIOR: ");
        HashMap<GoodCat, Integer> goodHashMap = new HashMap<>();
        for(int i = 0; i < goodCats.length; i++) {
            GoodCat gc = goodCats[i];
            goodHashMap.put(gc, i);
            String goodCatHash = gc + " hash is " + gc.hashCode();
            printAndWrite(goodCatHash, writer);
        }

        System.out.println("Identical GoodCats considered equal: "+goodCats[0].equals(goodCats[4]));
        System.out.println("Different GoodCats considered equal: "+goodCats[0].equals(goodCats[1]));
        System.out.println("Identical GoodCats hashes are equal: "+(goodCats[0].hashCode() == goodCats[4].hashCode()));
        System.out.println("Different GoodCats hashes are equal: "+(goodCats[0].hashCode() == goodCats[1].hashCode()));


        System.out.println("GoodCat HashMap size: "+goodHashMap.size());
        System.out.println("GoodCat HashMap:");
        for (GoodCat key : goodHashMap.keySet())
            System.out.println("Key: " + key + ", Value: " + goodHashMap.get(key));

        System.out.println("TESTING BadCat BEHAVIOR: ");
        HashMap<BadCat, Integer> badHashMap = new HashMap<>();
        for(int i = 0; i < badCats.length; i++) {
            BadCat bc = badCats[i];
            badHashMap.put(bc, i);
            String badCatHash = bc + " hash is " + bc.hashCode();
            printAndWrite(badCatHash, writer);
        }

        System.out.println("Identical BadCats considered equal: "+badCats[0].equals(badCats[4]));
        System.out.println("Different BadCats considered equal: "+badCats[0].equals(badCats[1]));
        System.out.println("Identical BadCats hashes are equal: "+(badCats[0].hashCode() == badCats[4].hashCode()));
        System.out.println("Different BadCats hashes are equal: "+(badCats[0].hashCode() == badCats[1].hashCode()));

        System.out.println("BadCat HashMap size: "+badHashMap.size());
        System.out.println("BadCat HashMap:");
        for (BadCat key : badHashMap.keySet())
            System.out.println("Key: " + key + ", Value: " + badHashMap.get(key));

        }catch(java.io.IOException ex){
            ex.printStackTrace();
        }
    }

    public static void getMessageDigest(String algorithm, String input, BufferedWriter writer){
        try{
            String hexHash = bytesToHex(getMessageDigest(algorithm, input));
            String output = (new StringBuilder("\"").append(input).append("\" HASHED WITH ")
                    .append(algorithm).append(" IS: ").append(hexHash)).toString();
            printAndWrite(output, writer);

        }catch(NoSuchAlgorithmException ex){
            System.out.println(algorithm+" is invalid hashing algorithm");
        }catch(java.io.IOException ex){
            ex.printStackTrace();
        }
    }

    public static void getSecureRandom(String algorithm, String input, BufferedWriter writer){
        try{
            String hexHash = bytesToHex(getSecureRandom(algorithm, input));
            String output = (new StringBuilder("\"").append(input).append("\" HASHED WITH ")
                    .append(algorithm).append(" IS: ").append(hexHash)).toString();
            printAndWrite(output, writer);

        }catch(NoSuchAlgorithmException ex){
            System.out.println(algorithm+" is invalid RNG algorithm");
        }catch(java.io.IOException ex){
            ex.printStackTrace();
        }
    }

    private static byte[] getMessageDigest(String algorithm, String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(input.getBytes());
        return md.digest();
    }

    private static byte[] getSecureRandom(String algorithm, String input) throws NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance(algorithm);
        byte[] randomBytes = new byte[16];
        sr.setSeed(input.getBytes());
        sr.nextBytes(randomBytes);
        return randomBytes;
    }

    private static String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder();

        for(byte b: hash){
            String hex = Integer.toHexString(0xFF & b);
            if(hex.length() == 1)
                hexString.append(0);
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static void printAndWrite(String str, BufferedWriter writer) throws IOException{
        System.out.println(str);
        writer.write(str+"\n");
        writer.flush();
    }
}
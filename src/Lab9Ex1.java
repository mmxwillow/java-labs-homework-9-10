public class Lab9Ex1 {
    public static void main(String[] args) {
        try{
            ExceptionGenerator.generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Found exception: NullPointerException!");
            e.printStackTrace();
            System.out.println("Exception description: " + e);
        }
    }
}

class ExceptionGenerator {
    public static void generateNullPointerException() {
        String str = null;
        int length = str.length();
    }
}

import java.util.Scanner;

public class Main {
    // cipher message jebac pis into text with uppercased warriance
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        startingSequence();
        int selectMode = 0;
        try {
            String temp = getInputFromUser("Write input as numbers: ");
            selectMode = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            System.err.println("Unable to convert input string to Integer");
            main(null);
        }


        switch (selectMode) {
            case 1: {
                ciphering();

                break;
            }

            case 2: {

                deciphering();
                break;
            }

            case 3: {
                System.exit(1);
                break;
            }
        }

        main(null);

    }

    private static void deciphering() {
        String sentence = getInputFromUser("Write sentence to decipher: ");
        char[] chars = sentence.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {


            if (Character.isUpperCase(chars[i]) || (chars[i] == ' ' && chars[i + 1] == ' ')) {
                builder.append(chars[i]);
                System.out.println(builder.toString());
            }
        }

        System.out.println(builder.toString());

    }

    private static void ciphering() {
        char[] message = getInputFromUser("Write message to cipher: ").toLowerCase().toCharArray();
        char[] sentence = getInputFromUser("Write sentence to cipher into: ").toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder();
        int messageIterator = 0;
        boolean temp = true;
        for (char c : sentence) {


            if (c == message[messageIterator] && temp) {
                builder.append(Character.toUpperCase(message[messageIterator]));
                if (c == ' ') {
                    builder.append(Character.toUpperCase(message[messageIterator]));
                }
                if(messageIterator != message.length-1) {
                    messageIterator++;
                }
                else{
                    temp = false;
                }


            } else {
                builder.append(c);
            }


        }

        messageIterator++;

        while (messageIterator < message.length) {
            builder.append(Character.toUpperCase(message[messageIterator]));
            messageIterator++;
        }
        System.out.println(builder.toString());
    }


    public static void startingSequence() {
        System.out.println(" ");
        System.out.println("Hello in message into Sentence ciphering");
        System.out.println(" ");
        System.out.println("Select mode:");
        System.out.println(" ");
        System.out.println("1. Ciphering");
        System.out.println("2. Deciphering");
        System.out.println("3. Exit");
        System.out.println(" ");

    }


    public static String getInputFromUser(String message) {
        // Using Scanner for Getting Input from User
        System.out.println(message);
        String output = in.nextLine();
        System.out.println(" ");
        return output;

    }


}


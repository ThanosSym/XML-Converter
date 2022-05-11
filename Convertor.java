import java.util.Scanner;

public class Convertor {
    private static boolean personExists = false;
    private static boolean start = true;
    private static boolean family = false;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                if (personExists){
                    System.out.println("  "+"</person>" + "\n"+"</people>");
                }
                break;
            }

            switch(input.charAt(0)) {
                case 'P':
                    if (start){
                        System.out.print("\n" + "<people>");
                        start= false;
                    }
                    if (personExists == true) {
                        System.out.println( "  "+ "\n"+"</person>");
                    }
                    printPerson(input);
                    personExists = true;
                    break;
                case 'T':
                    printTelephone(input);
                    break;
                case 'A':
                    printAddress(input);
                    break;
                case 'F':
                    if (family) {
                        System.out.print( "\n"+"</family>");
                    }
                    printFamily(input);
                    family = true;
                    break;
                default:
            }
        }

    }

    public static void printPerson(String person){
        if (personExists == false) {
            System.out.print("\n");
        }
        System.out.print(" "+ "<person>" + "\n" + " " +  "<firstname>" + person.substring(2,countLetters(person) + 2)
                + "</firstname>" + "\n" +  " " + "<lastname>" + person.substring(countLetters(person)+3,person.length()) + "<lastname>");

    }

    public static void printTelephone(String phone){
        System.out.print( "\n"  + " "  + " " + "<phone>" + "\n" + "  " + "  " +  "<mobile>" +phone.substring(2,countLetters(phone) + 2)
                + "</mobile>" + "\n"  + "  " + "  " + "<fastnätsnummer>" + phone.substring(countLetters(phone)+3,phone.length())
                + "</fastnätsnummer>" + "\n" + " " + " " +"</phone>");
    }

    public static void printFamily(String family){

        System.out.print("\n" + "<family>" + "\n" + " " + "<name>"+ separateCityFromAddress(family)
                + "</name>" + "\n" +  " " + " " + "<born>" + family.substring(countLetters(family)+3,family.length())
                + "</born>");

    }
    public static void printAddress(String address){

        System.out.print("\n"+ " " +  "<address>" + "\n" + " " + " " +  "<street>" +address.substring(2,countLetters(address) + 2)
                + "</street>" + "\n" + "  " + "<city>" + separateCityFromAddress(address.substring(countLetters(address) + 1,address.length()))
                + "</city>" +  "\n" + " " + " " + "<postnummer>" + getPostNumber(address.substring(countLetters(address)+3,address.length()))
                + "</postnummer" + "\n"  + " "+  "</address>");
    }

    public static int countLetters(String word) {
        int counter = 0;
        for (int i = 2; i<word.length(); i ++){
            if (word.charAt(i) == '|') {
                break;
            }
            counter++;
        }
        return counter;
    }

    public static String separateCityFromAddress(String address){
        int counter = 0;

        for (int i = 2; i<address.length(); i ++){
            if (address.charAt(i) == '|') {
                break;
            }
            counter++;
        }
        return address.substring(2,counter + 2);
    }

    public static String getPostNumber(String postNumber){
        int counter = 0;
        for (int i = 2; i<postNumber.length(); i ++){
            if (postNumber.charAt(i) == '|') {
                break;
            }
            counter++;
        }
        return postNumber.substring(counter + 3,postNumber.length());
    }
}



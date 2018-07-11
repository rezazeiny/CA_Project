import CPU.CPU;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Main {
    private static CPU cpu;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        cpu = CPU.getInstance();
        cpu.start();
        keyListen();
    }
    private static void keyListen(){
//        try {
            if (cpu.getState().isEndProgramme()){
                System.out.println("The End");
                return;
            } else {
                System.out.println("=============================================");
                System.out.println("Press ENTER to next clock...");
                System.out.println("For Reading Memory type MEM");
            }
            String temp = scanner.nextLine();
            if (temp.equals("MEM")){
                cpu.getMemory().readAll();
            }
            else {
                cpu.pulse();
            }
        keyListen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

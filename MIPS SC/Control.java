import java.io.*;
import java.util.*;

class Control {
    public String[][] codes;
    public int[] register = new int[8];
    Hashtable<String, Integer> Registers = new Hashtable<>();

    Control()
    {
        for(int i = 0; i < 8; i++)
        {  
            register[i] = 0;
        }
        Registers.put("10000001",0);
        Registers.put("10000010",1);
        Registers.put("10000011",2);
        Registers.put("10000100",3);
        Registers.put("10000101",4);
        Registers.put("10000110",5);
        Registers.put("10000111",6);
        Registers.put("10001000",7);
    }
    public static void main(String[] args) {
        File file = new File("Inst.txt");
        Control m = new Control();
        try {
            
            m.fileRead(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // int a = Registers.get("10000001");
        System.out.println(m.Registers.get("10000001"));
    }
    
    public String[][] fileRead(File file) throws FileNotFoundException
    {
        int lines = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            sc.nextLine();
            lines++;
        }
        System.out.println(lines);
        codes = new String[lines][4];
        sc = new Scanner(file);

        for(int i = 0; i<lines; i++)
        {
            String temp[] = sc.nextLine().split(" ", 4);
            // System.out.println(temp[2]);
            // if(temp.length<=3){
            //     codes[i][2] = "0";
            //     codes[i][3] = "0";  JMP label null null 
                                        // JMP function(arr[1])
            // }
            for(int j = 0; j < 4; j++)
            {
                if(temp.length>=j+1){
                    codes[i][j] = temp[j];
                }
            }
        }

        for(int i = 0; i < lines; i++)
        {
            for (int j = 0; j < 4; j++) {
                System.out.print(" "+codes[i][j]);
            }
            System.out.println();
        }

        return codes;
    }
}

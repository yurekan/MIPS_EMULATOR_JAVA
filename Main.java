import java.io.*;
import java.util.*;

class Main{
    public String[][] codes;
    public int[] register = new int[8];
    Hashtable<Integer, String> ht1 = new Hashtable<>();
 
    // put() method
    geek.put("123", "Code");
    geek.put("456", "Program");
    // dict.put("add", 00000001);
    // dict.put("SUB", 00000010);
    // dict.put("sub", 00000010);
    // dict.put("")
    Main()
    {
        for(int i = 0; i < 8; i++)
        {  
            register[i] = 0;
        }
        ht1.put(1,"Jaa");
    }
    public static void main(String[] args){

        File file = new File("myfile.txt");
        Main m = new Main();
        try {
            
            m.fileRead(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // m.register[m.binToRegister(m.codes[0][0])] = 45;
        // System.out.println(m.register[0]);

        // System.out.println(m.decToBinary(12));
    }

    public String[][] fileRead(File file) throws FileNotFoundException
    {
        int lines = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
            {sc.nextLine();
            lines++;}
        codes = new String[lines][4];
        sc = new Scanner(file);

        for(int i = 0; i<lines; i++)
        {
            String temp[] = sc.nextLine().split(" ", 4);
            for(int j = 0; j < 4; j++)
            {
                codes[i][j] = temp[j];
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

    // public int binToRegister(String s)
    // {
    //     switch(s)
    //     {
    //         case "10000001":
    //             return 0;
    //         case "10000010":
    //             return 1;
    //         case "10000011":
    //             return 2;
    //         case "10000100":
    //             return 3;
    //         case "10000101":
    //             return 4;
    //         case "10000110":
    //             return 5;
    //         case "10000111":
    //             return 6;
    //         case "10001000":
    //             return 7;
    //         default:
    //             return -1;
    //     }
    // }

    public int binToRegister(String s)
    {
        String opcode;
        if(s == "ADD" || s == "add")
        {
            opcode = "00000001";
        }

        else if(s == "ADDI" || s == "addi")
        {
            opcode = "00000010";
        }

        else if(s == "SUB" || s == "sub")
        {
            opcode = "00000011";
        }

        else if(s == "SUBI" || s == "subi")
        {
            opcode = "00000100";
        }

        else if(s == "JMP" || s == "jmp")
        {
            opcode = "00000101";
        }
    }

    // public void binToInstruction(String s)
    // {
    //     switch(s)
    //     {
    //         case "00000001":
    //             return 0;
    //         case "00000010":
    //             return 1;
    //         case "00000011":
    //             return 2;
    //         case "00000100":
    //             return 3;
    //         case "00000101":
    //             return 4;
    //         case "00000110":
    //             return 5;
    //         case "00000111":
    //             return 6;
    //         default:
    //             return -1;
    //     }
    // }

    public String decToBinary(int num)
    {
        String result = "";
        int  k = num;
        while(k != 0)
        {
            if(k%2 == 1)
            {
                result = "1"+result;
            }
            else if(k%2==0)
            {
                result = "0"+result;
            }
            k = k/2;
        }
        return result;
    }

}

class Adder{
    public int[] A = new int[8];
    public int[] B = new int[8];
    public int[] sum = new int[8];
    public int C_in = 0, C_Out, Sum;

    public int Addtion(int x, int y, int z)
    {
        Sum = z ^ (x ^ y);
        C_Out = (x & y) || (y & z) || (x & z);
    }

    for(int i=0; i<8; i++)
    {
        if(i == 0)
        {
            Addition(A[i], B[i], C_in);
            sum[i] = Sum;
        }
        else
        {
            Addition(A[i], B[i], C_Out);
            sum[i] = Sum;
        }
    }
}

class Subractor{
    public int[] A = new int[8];
    public int[] B = new int[8];
    public int[] diff = new int[8];
    public int Bin = 0, B_Out, Difference;

    public int Subraction(int x, int y, int z)
    {
        Difference = (x ^ y) ^ z;
        int x1 = !(x);
        B_Out = x1 & Bin | x1 & y | y & Bin;
    }

    for(int i=0; i<8; i++)
    {
        if(i == 0)
        {
            Subraction(A[i], B[i], Bin);
            diff[i] = Difference;
        }
        else
        {
            Subraction(A[i], B[i], C_Out);
            sum[i] = Sum;
        }
    }
}
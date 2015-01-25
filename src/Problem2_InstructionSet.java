import java.util.Scanner;


public class Problem2_InstructionSet {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opCode = input.nextLine();
        
        while (!opCode.equals("END")) {
            String[] codeArgs = opCode.split(" ");
            
         // changed every "int" to "long" so the program can work with bigger numbers with no casting and problems
            long result = 0;
            switch (codeArgs[0]) {
                case "INC": {
                	long operandOne = Long.parseLong(codeArgs[1]); 
                    result = ++operandOne; // if we put "++" after the variable its current value won't be saved into "result"
                    break;
                }
                case "DEC": {
                	long operandOne = Long.parseLong(codeArgs[1]);
                    result = --operandOne;  // same as the above
                    break;
                }
                case "ADD": {
                	long operandOne = Long.parseLong(codeArgs[1]);
                	long operandTwo = Long.parseLong(codeArgs[2]);
                    result = operandOne + operandTwo;
                    break;
                }
                case "MLA": {
                	long operandOne = Long.parseLong(codeArgs[1]);
                	long operandTwo = Long.parseLong(codeArgs[2]);
                    result = operandOne * operandTwo; // information is already lost even if we cast the int product into long
                    break;								
                }
                default:
                    break;
            }
            System.out.println(result);
            opCode = input.nextLine(); // if we don't get new value for "opCode" the while-loop will be infinite :)
        }
        input.close(); // just for completeness :D
    }
}

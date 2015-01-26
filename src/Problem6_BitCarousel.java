import java.util.Scanner;


public class Problem6_BitCarousel {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = Integer.parseInt(input.nextLine()); // int is safer, shift operations could create bigger numbers
        int rotations = Integer.parseInt(input.nextLine());
        //System.out.println(Integer.toBinaryString(number));

        for (int i = 0; i < rotations; i++) {
            String direction = input.nextLine();

            if (direction.equals("right")) {  // ".equals" checks for value equality and should be used here
                int rightMostBit = number & 1;
                number >>= 1;
        		//System.out.println(Integer.toBinaryString(number));
        		number |= rightMostBit << 5; // 5 times instead of 6, counting starts from "0" index
        		//System.out.println(Integer.toBinaryString(number));
            } else if (direction.equals("left")) { 
                int leftMostBit = (number >> 5) & 1;
                number <<= 1;
                //System.out.println(Integer.toBinaryString(number));
                number |= leftMostBit;
                int eraserMask = leftMostBit << 6; // mask to remove the new leftmost bit
                number ^= eraserMask; // erasing the new leftmost bit with XOR
                //System.out.println(Integer.toBinaryString(number));
            }
        }

        System.out.println(number);
        input.close();
    }
}

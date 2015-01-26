import java.util.Scanner;


public class Problem4_Substring {
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        int jump = Integer.parseInt(input.nextLine());

        //char search = 'ð';	// not working
        char search = (char)112;	// initializing the searched char by its ascii code
        boolean hasMatch = false;

        for (int i = 0; i < text.length(); i++) {
        	
            if (text.charAt(i) == search) {
                hasMatch = true;
                
                int endIndex = i+jump+1;	// current index + the jump + 1
                
                if (endIndex > text.length()) {
                    endIndex = text.length();
                }
                
                for (int j = i; j < endIndex; j++){			// loops and prints only valid letters until the end index
                	if (text.charAt(j)!=' '){
                		System.out.print(text.charAt(j));
                	}
                }
                System.out.println();	// new line

                //String matchedString = text.substring(i, endIndex);	// includes whitespaces , so it is not working
                // 
                //System.out.println(matchedString);	
                i += jump; 
            }
        }

        if (!hasMatch) {
            System.out.println("no");
        }
    }
}

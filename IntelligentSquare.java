import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class IntelligentSquare {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int root = scanner.nextInt();
		for (int index = 0; index < root; index++) {
			double percentage=scanner.nextDouble();
			double changeValue=(1+(percentage/100));
			String format=".##";
			DecimalFormat df=new DecimalFormat(format);
			double changeData=Double.parseDouble(df.format(((changeValue*changeValue)-1)));
			System.out.println("Case_"+(index+1)+":"+(int)(changeData*100)+"%");
		}
		if(scanner!=null) {
			scanner.close();
		}
	}

}

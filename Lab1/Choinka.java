public class Choinka {
	public static void main(String[] args) {
		for (int i=0; i<=Integer.parseInt(args[0]); i++)
		{
			for (int j=i; j>=0;j--)
			{
				System.out.print("*");
			}
			System.out.println("\n");
		}
	
	}
}
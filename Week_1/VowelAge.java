import java.util.Scanner;

public class VowelAge
{
 public static void main(String[] args)
 {
  Scanner input = new Scanner(System.in);
  String name = input.nextLine();
  char[] name_char = name.toCharArray();
  int age = input.nextInt();
  int count = 0;
  String adult;

  for(int i = 0;i < name_char.length;i++)
   {
    if (name_char[i] == 'a' || name_char[i] == 'e' || name_char[i] == 'i' || name_char[i] == 'o' || name_char[i] == 'u' || name_char[i] == 'A' || name_char[i] == 'E' || name_char[i] == 'I' || name_char[i] == 'O' || name_char[i] == 'U')
     {
      count++;
     }
   }
 if (age >= 18)
  {
   adult = "an adult";
  }
 else
  {
   adult = "a minor";
  }
  System.out.println("Hello "+name+", you have "+ count+ " vowels, and you are " + adult);
 }
}


/*Problem: Given four n-digit positive integers, generate an n-digit pin.
Then encrypt a message using the generated pin.*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class NegativeNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	String s;

	NegativeNumberException(String s) {
		this.s = s;
	}

	public String toString() {
		return (s);
	}
}

class MessageValueException extends Exception {
	private static final long serialVersionUID = 1L;
	String s;

	MessageValueException(String s) {
		this.s = s;
	}

	public String toString() {
		return (s);
	}
}

public class EncryptByPin {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Value Of 'n', i.e., A Positive Integer.");
		int n = sc.nextInt();
		try {
			if (n <= 0)
				throw new NegativeNumberException(
						"NegativeNumberException: The Value Of N Cannot Be A Non Positive Number.");
			else {
				System.out.println("Enter Four " + n + "-Digits Numbers.");
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				int num3 = sc.nextInt();
				int num4 = sc.nextInt();
				int c = n;
				String pin = "";
				while (c > 0) {
					pin = (Math.min(num1 % 10, Math.min(num2 % 10, Math.min(num3 % 10, num4 % 10)))) + pin;
					num1 = num1 / 10;
					num2 = num2 / 10;
					num3 = num3 / 10;
					num4 = num4 / 10;
					c = c - 1;
				}
				System.out.println("Pin: " + pin);
				sc.nextLine();
				System.out.println("Enter A Message That Should Only Contain Alphabets And White Spaces.");
				String message = sc.nextLine();
				message = message.replaceAll(" ", "");
				try {
					if (Pattern.matches("^[a-zA-Z]*$", message)) {
						message = message.toLowerCase();
						System.out.print("Message After Removing Space And Converting To Lower Case: " + message);
						int length = message.length();
						ArrayList<String> msg = new ArrayList<String>();
						for (int i = 0; i < length; i = i + n) {
							if (i + n < length)
								msg.add(message.substring(i, i + n));
							else
								msg.add(message.substring(i));
						}
						System.out.print("\nBreaking Message String: ");
						for (int i = 0; i < msg.size(); i++)
							System.out.print(msg.get(i) + " ");
						System.out.print("\nNew String After Updation: ");
						ArrayList<String> E = new ArrayList<String>();
						String tmp = "";
						for (int i = 0; i < msg.size(); i++) {
							for (int j = 0; j < msg.get(i).length(); j++) {
								c = (int) (msg.get(i).charAt(j)) + (int) (pin.charAt(j)) - 48;
								if (c > 122)
									tmp = tmp + (char) (c - 58);
								else
									tmp = tmp + (char) (c - 32);
							}
							E.add(tmp);
							System.out.print(tmp + " ");
							tmp = "";
						}
						for (int i = 0; i < E.size(); i++)
							tmp = tmp + E.get(i);
						tmp = tmp.toUpperCase();
						System.out.println("\nEncrypted Pin: " + tmp);
					} else
						throw new MessageValueException(
								"MessageValueException: Message Should Only Contain Alphabets And White Spaces.");
				} catch (MessageValueException me) {
					System.out.println(me);
				}
			}
		} catch (NegativeNumberException e) {
			System.out.println(e);
		}
	}
}
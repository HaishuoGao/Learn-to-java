public class Substring {
	public static void main(String[] args) {
		String string = args[0];
        int index = Integer.parseInt(args[1]);  //String to integer
        int length = Integer.parseInt(args[2]);
        int endIndex = index + length;
        String subString = string.substring(index, endIndex);
        System.out.println(subString);int i = 0;
	}
}
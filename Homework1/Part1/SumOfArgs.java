public class SumOfArgs {
    public static boolean isNumeric(String str){
        for (int i = str.length(); --i >= 0; ){
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int sum = 0;
        if (args.length == 0)
            sum = 0;
        else{
            for (int i = 0; i < args.length; i++){
                if (isNumeric(args[i]))
                     sum = sum + Integer.parseInt(args[i]);
                else
                    continue;
            }        
        }
        System.out.println(sum);      
    }
}

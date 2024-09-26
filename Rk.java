public class Rk {

    public int cricketer(int a, int b){
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        int a = 45;
        int b = 657;

       
        Rk obj = new Rk();
        int result = obj.cricketer(a, b); 

        
        System.out.println("Sum: " + result);
    }
}

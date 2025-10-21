public class CodingBat {
    static void main() {
        CodingBat cb = new CodingBat();

        cb.countEvens(new int[]{2, 1, 2, 3, 4});


    }
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if(!weekday || vacation){
            return true;
        }else{
            return false;
        }
    }

    public int diff21(int n) {
        if(n<=21){
            return 21-n;
        }else{
            return 2*(n-21);
        }
    }

    public int countEvens(int[] nums) {
        int evens = 0;
        for (int i=0; i<nums.length;i++){
            if (nums[i]%2==0){
                evens+=1;
            }
        }
        return evens;
    }

    public String helloName(String name) {
        String message= "Hello "+name+"!";
        return message;
    }

}


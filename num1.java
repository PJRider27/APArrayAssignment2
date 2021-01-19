import java.util.ArrayList;

public class num1 {

//    Question1:

   public static ArrayList<Integer> primes(int n){
       ArrayList<Integer> nums= new ArrayList();
       for(int i=2;i<=n;i++){
           nums.add(i);
       }
       int rNum=2;
       int index=nums.size()-1;
       while(nums.indexOf(rNum)!=nums.size()-1){
           if(index>=rNum){
               if(nums.get(index)>rNum && nums.get(index)%rNum==0){
                   nums.remove(index);
               }
               index--;
           }else{
               if(nums.indexOf(rNum)!=nums.size()-1) {
                   index = nums.size() - 1;
                   rNum = nums.get(nums.indexOf(rNum) + 1);
               }
           }
       }
//       for(int i=0;i<nums.size();i++){
//           System.out.println(nums.get(i));
//       }

    return nums;
   }

//   Question2:

   public static void addPrimes(int num){
       boolean printed=false;
       ArrayList<Integer> primeList=primes(num);
       for(int i=0;i<primeList.size();i++){
           if(printed){
               break;
           }
           for(int j=0;j<i;j++){
               if(primeList.get(i)+primeList.get(j)==num){
                   System.out.println(num + "=" + primeList.get(i) + "+" + primeList.get(j));
                   printed=true;
                   break;
               }
           }
       }
   }


//   Question3:

   public static ArrayList<Integer> addArrays(ArrayList<Integer> a, ArrayList<Integer> b){
       if(a.size()>b.size()){
           return calculate(a,b);
       }else{
           return calculate(b,a);
       }
   }

    public static ArrayList<Integer> calculate(ArrayList<Integer> big, ArrayList<Integer> small){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<big.size();i++){
            result.add(0);
        }
       for(int i=small.size()-1;i>=0;i--){
           if((small.get(i) + big.get(result.size()-small.size()+i)+result.get(result.size()-small.size()+i))<10){
               result.set(result.size()-small.size()+i, small.get(i) + big.get(result.size()-small.size()+i)+result.get(result.size()-small.size()+i));
           }
           else{
               result.set(result.size()-small.size()+i, (small.get(i) + big.get(result.size()-small.size()+i))%10+result.get(i));
               result.set(result.size()-small.size()-1+i,1);
           }
       }


       if(small.size()!=big.size()) {
           for (int i = small.size(); i < big.size(); i++) {
               result.set(big.size() - small.size() - (i - small.size()) - 1, big.get(big.size() - small.size() - (i - small.size()) - 1) + result.get(big.size() - small.size() - (i - small.size()) - 1));
           }
       }


       if(result.get(0)==0){
           result.remove(0);
       }
       for(int i=0;i<result.size();i++){
           System.out.print(result.get(i));
       }
       return result;
    }




    public static void main(String[] args) {

//Q1:
//    primes(100);

//Q2:
//    addPrimes(16);

//Q3:
//        ArrayList<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(3);
//        a.add(4);
//        ArrayList<Integer> b = new ArrayList<Integer>();
//        b.add(1);
//        b.add(9);
//        b.add(6);
//        b.add(4);
//        b.add(9);
//        b.add(6);
//        addArrays(a,b);

    }
}

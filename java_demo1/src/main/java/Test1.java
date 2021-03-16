public class Test1 {
    public static void main(String[] args) {
        int[] list = new int[10];
        boolean flag = false;
        for (int i = 0; i < list.length; i++) {
            do {
                list[i] = (int)(Math.random()*10+1);
                for(int j=i-1;j>=0;j--){
                    if(list[i] == list[j]){
                        flag = true;
                        break;
                    }
                    if(list[i] != list[j]&&j==0){
                        flag = false;
                    }
                }
            }
            while (flag);
        }
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }

        int[] list1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("位置为："+search(list1,11));
    }



    public static int search(int[] list,int a){
        int low=0,high=list.length-1,mid;
        while (low <= high){
            mid = (low+high)/2;
            if(a<list[mid]){
                high = mid-1;
            }
            else if(a>list[mid]){
                low = mid+1;
            }
            else if(a==list[mid]) return mid;
        }
        return -1;
    }
}

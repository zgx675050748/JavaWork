public class Sort {

    public static void main(String[] args) {
        int[] list = new int[]{9,8,7,6,5,4,3,2,1,0};
        int temp;
        for (int i=0;i<list.length-1;i++){
            for (int j=0;j<list.length-i-1;j++){
                if(list[j]>list[j+1]){
                    temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        for (int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}

/**o
 * i=0  j=0,1,2,3,4,5,6,7,8   [9]
 * i=1  j=0,1,2,3,4,5,6,7     [8][9]
 *
 * i=8  j=0                   [1][2]...[8][9]
 */
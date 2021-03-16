public class Test {

    public static void main(String[] args) {
//        搭建一个链表
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        Node link = null;

        for (int i=0;i<arr.length;i++){
            Node node = new Node();
            node.value = arr[i];
            node.next = link;
            link = node;
        }

        while(link != null){
            System.out.println(link.value);
            link = link.next;
        }
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FamilyAccount {
    public static void main(String[] args){
        ArrayList list = new ArrayList<String>();
        boolean isFlag = true;
        String shuoming="";
        int mount=10000,change,method;
        System.out.println("——————————————————家庭收支软件——————————————————");
        while(isFlag){
            Scanner sc = new Scanner(System.in);
            System.out.println("————————————————请输入要进行的操操作——————————————");
            System.out.println("————————————————  1-查看收支详情 ————————————————");
            System.out.println("————————————————  2-添加一笔收入 ————————————————");
            System.out.println("————————————————  3-添加一笔支出 ————————————————");
            System.out.println("————————————————  4-退出记账软件 ————————————————");
            System.out.print("请输入操作对应的数字（1-4）：");
            method = sc.nextInt();
            switch (method){
                case 1:
                    System.out.println("——————————————————家庭收支软件——————————————————");
                    System.out.println("——————————————————  账单明细 ——————————————————");
                    System.out.println(
                            "收支类型——————当前资金——————本次收支——————收支说明——");
                    for (int i=0;i<list.size();i++){
                        System.out.println(list.get(i));
                    }
                    System.out.println("\n\n\n");
                    break;
                case 2:
                    System.out.print("请输入收支金额：");
                    change = sc.nextInt();
                    mount += change;
                    System.out.print("请输入收支说明：");
                    sc.nextLine();
                    shuoming = sc.nextLine();
                    list.add("收入         "+mount+"        "+change+"         " +
                            " " +shuoming);
                    System.out.println("\n\n\n");
                    break;
                case 3:
                    System.out.print("请输入收支金额：");
                    change = sc.nextInt();
                    mount -= change;
                    System.out.print("请输入收支说明：");
                    sc.nextLine();
                    shuoming = sc.nextLine();
                    list.add("支出         "+mount+"        "+change+"         " +
                            " "+shuoming);
                    System.out.println("\n\n\n");
                    break;
                case 4:
                    System.out.print("确定要退出软件<y/n>：");
                    sc.nextLine();
                    String out = sc.nextLine();
                    System.out.println("");
                    if (out.equals("y")) {
                        System.out.println("已退出");
                        System.out.println("\n\n\n");
                        isFlag = false;
                    }
                    break;

                default:
                    System.out.println("输入不符合规则：请重新输入");
                    break;
            }
        }
    }
}

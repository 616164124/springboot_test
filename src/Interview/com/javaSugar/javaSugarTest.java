package com.javaSugar;

public class javaSugarTest {
    public static void main(String[] args) {
        // first
        //switch 中使用string 且是用的string中的 equals() 和 hashcode（）方法来判断是否相同
        String str = "abc";
        System.out.println(str.hashCode());
        System.out.println("abc".hashCode());
        switch ("abc") {
            case "abc":
                System.out.println("进入 abc");
                break;
            case "tesr":
                System.out.println("进入 tesr");
                break;
            case "aa":
                System.out.println("进入 aa");
                break;
            case "ert":
                System.out.println("进入 ert");
                break;
            default:
                System.out.println("进入 default");
                break;
        }
        // hashcode()相同 equals() 不相同用 Ma 和 NB 两个字符串来做实验
        // hashcode 是通过element.hashCode方法 获得的int 值
        //因为hashcode相同，所以它们的bucket位置相同，‘碰撞’会发生。因为HashMap使用链表存储对象，这个Entry(包含有键值对的Map.Entry对象)会存储在链表中。这个时候要理解根据hashcode来划分的数组，如果数组的坐标相同，则进入链表这个数据结构中了，一般的添加都在最前面，也就是和数组下标直接相连的地方，链表长度到达8的时候，jdk1.8上升为红黑树
        String a = "Ma", b = "NB";
        System.out.println(a.hashCode() == b.hashCode()); //"hashcode() 相同"  返回 true
        System.out.println(a.equals(b));                  // 返回 false
        System.out.println(str.equals("abc"));   // 返回 true


        // second



    }


}

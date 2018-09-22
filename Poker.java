package mystudy;

import java.util.Arrays;

public class Poker {

    private static int[] cards;//定义类中的牌堆变量

    public static void main(String[] args){
        //牌堆初始化
        cards = inIt();

        //为玩家手牌声明并发牌

        int []player1Cards=deal(17);
        int []player2Cards=deal(17);
        int []player3Cards=deal(17);

        //输出玩家手牌
        System.out.println("玩家一手牌"+cardInfo(player1Cards));
        System.out.println("玩家二手牌"+cardInfo(player2Cards));
        System.out.println("玩家三手牌"+cardInfo(player3Cards));

        //输出底牌
        System.out.println("三张底牌为" +
                "；");
        for(int i=0;i<cards.length;i++){
            if (cards[i] > 0)
                System.out.print(cardInfo(cards[i])+" ");
        }

    }

    public static int[] deal(int count) {//为玩家发牌
        int[] resultCard=new int[count];//定义结果数组
        for(int i=0;i<resultCard.length;){
            int ram=(int)(Math.random()*54);//强制转换为整型，范围为0到53
            int card=cards[ram];
            if(cards[ram]>=0){//判断抽到了未被标记的牌
                cards[ram]=-1;//标记已经被抽出的牌
                resultCard[i]=card;//输出
                i++;//若被抽出则继续
        }
        }return resultCard;//返回值为一个数组
    }

    public static int[] inIt() {//初始化方法
        //定义牌堆数值
        cards=new int [54];
        //为扑克牌赋值
        for(int i=0;i<cards.length;i++){
            cards[i]=i+1;
        }
        return cards;
    }

    public static String cardInfo(int[] cards){//将数组内数字转化为花色和点数方法
        String result="";
        for(int i=0;i<cards.length;i++){//遍历每张手牌
            int currenCard=cards[i];
            String currenCardInfo=cardInfo(currenCard);//调用单张手牌信息的方法
            result += currenCardInfo;//结果追加到字符串
            if(i !=cards.length-1) {//如果不等于最后一张
                result += "，";
            }
        }
        return result;
    }
    public static String cardInfo(int card) {//转化单张牌
        String result;
        if(card==53){
            result="小王";
        }else if(card==54){
            result="大王";
        }else{
            int color = (card - 1) / 13;//对手牌花色进行判断

            switch (color) {
                case 0:
                    result = "红桃";
                    break;
                case 1:
                    result = "黑桃";
                    break;
                case 2:
                    result = "梅花";
                    break;
                case 3:
                    result = "方片";
                    break;
                default:
                    result = "错误手牌点数";
                    break;
            }

            int point = card % 13;//判断手牌点数
            switch (point) {
                case 0:
                    result += "K";
                    break;//若手牌为13时应该为K
                case 1:
                    result += "A";
                    break;
                case 11:
                    result += "J";
                    break;
                case 12:
                    result += "Q";
                    break;

                default:
                    result += point + "";
            }
        }

        return result;
    }
}

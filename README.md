# poker
随机发牌代码
package mystudy;

import java.util.Arrays;

public class Poker {
    public static void main(String[] args){
        //扑克牌声明
        int [] cards=new int [54];
        //为扑克牌赋值
        for(int i=0;i<cards.length;i++){
            cards[i]=i+1;
        }
        //为玩家手牌声明
        int [][] players=new int[3][17];

         //为玩家发牌
        for(int j=0;j<players.length;j++){
            for(int i=0;i<players[j].length;){
                int ram=(int)(Math.random()*54);//强制转换为整型，范围为0到53
                int card=cards[ram];
                if(cards[ram]>=0){//判断抽到了未被标记的牌
                    cards[ram]=-1;//标记已经被抽出的牌
                    players[j][i]=card;//输出
                    i++;//若被抽出则继续
                }
            }System.out.println("玩家player"+(j+1)+"的手牌为："+cardInfo(players[j]));
        }

        //输出底牌
        System.out.println("三张底牌为" +
                "；");
        for(int i=0;i<cards.length;i++){
            if (cards[i] > 0)
                System.out.print(cardInfo(cards[i]));
        }


    }

    public static String cardInfo(int[] cards){
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
    public static String cardInfo(int card) {
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

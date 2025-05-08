/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Controller;

import test.Poker.Poker;
import test.View.PokerView;
import test.Utils.Utils;

/**
 *
 * @author shaos
 */
public class PokerController {
    public static void main(String[] args) {
        //创建变量
        String[] p = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] c = {"♠", "♥", "♣", "♦"};
        int[] n = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Poker[] poker = new Poker[52];
        Poker[] player1 = new Poker[3];
        Poker[] player2 = new Poker[3];
        //创建扑克牌
        int k = 0;
        for (int i = 0; i < 4; i++)//控制花色
        {
            for (int j = 0; j < 13; j++)//控制大小
            {
                poker[k] = new Poker();
                poker[k].setPoint(p[j]);
                poker[k].setColor(c[i]); 
                poker[k].setNum(n[j]); 
                k++;
            }
        }
        //洗牌操作
        for (int i = 0; i < p.length; i++) {
            int j = (int) (Math.random() * 52);
            if (i != j) {
                Poker temp = poker[i];
                poker[i] = poker[j];
                poker[j] = temp;
            }
        }
        //发牌操作
        for (int i = 0; i < 3; i++) {
            player1[i] = poker[i];
        }
        player1=Utils.sort(player1);
        System.out.println();
        for (int i = 0; i < 3; i++) {
            player2[i] = poker[i + 3];
        }
        player2=Utils.sort(player2);
        //亮牌操作
        PokerView.showPoker1(player1);
        PokerView.showPoker2(player2);
        //显示赢家
        PokerView.Winner(player1, player2);
    }
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Utils;

import test.Poker.Poker;

/**
 *
 * @author shaos
 */
public class Utils {
     //排序
    public static Poker[] sort(Poker[] poker) {
        int min;
        for (int i = 0; i < poker.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < poker.length; j++) {
                if (poker[j].num > poker[min].num) {
                    min = j;
                }
            }
            Poker temp = poker[min];
            poker[min] = poker[i];
            poker[i] = temp;
            
        }
        return poker;
    }
    
    //判断是否为对子
    public static boolean isPair(Poker[] poker) {
        if (!(poker[0].num == poker[1].num && poker[1].num == poker[2].num)) {
            for (int i = 0; i < 2; i++) {
                if (poker[i].num == poker[i + 1].num) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //判断是否为三张相同
    public static boolean isTri(Poker[] poker) {
        return poker[0].num == poker[1].num && poker[1].num == poker[2].num;
    }
    
    //判断是否为顺子
    public static boolean isCom(Poker[] poker) {
        return poker[0].num == poker[1].num + 1 && poker[1].num == poker[2].num + 1;
    }
    
    //判断是否为同花
    public static boolean isColor(Poker[] poker) {
        return poker[0].color.equals(poker[1].color) && poker[1].color.equals(poker[2].color);
    }
    
    //判断是否为同花顺
    public static boolean isColorCom(Poker[] poker) {
        return (poker[0].num == poker[1].num + 1 && poker[1].num == poker[2].num + 1)
                && (poker[0].color.equals(poker[1].color) && poker[1].color.equals(poker[2].color));
    }
    
    //比较顺子
   public static void Winner_isCom(Poker []player1,Poker []player2){
       if(player1[0].num>player2[0].num){
           System.out.println("玩家1获胜！");
       }
       else if(player2[0].num>player1[0].num){
           System.out.println("玩家2获胜！");
       }
       else{
           System.out.println("——平局——");
       }
   }
   
   //比较单张
   public static void Winner_isSingle(Poker []player1,Poker []player2){
       if(player1[0].num>player2[0].num){
           System.out.println("玩家1获胜！");
       }
       else if(player2[0].num>player1[0].num){
           System.out.println("玩家2获胜！");
       }
       else if(player1[1].num>player2[1].num){
           System.out.println("玩家1获胜！");
       }
       else if(player2[1].num>player1[1].num){
           System.out.println("玩家2获胜！");
       }
       else if(player1[2].num>player2[2].num){
           System.out.println("玩家1获胜！");
       }
       else if(player2[2].num>player1[2].num){
           System.out.println("玩家2获胜！");
       }
       else{
           System.out.println("——平局——");
       }
   }
   
   //比较对子
   public static void Winner_isPair(Poker []player1,Poker []player2){
       if(player1[1].num>player2[1].num){
           System.out.println("玩家1获胜！");
       }
       else if(player2[1].num>player1[1].num){
           System.out.println("玩家2获胜！");
       }
       else{
           System.out.println("——平局——");
       }
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.View;

import test.Poker.Poker;
import static test.Utils.Utils.*;



/**
 *
 * @author shaos
 */
public class PokerView {

    /**
     *
     * @param poker
     */
    //显示一号玩家的牌
    public static void showPoker1(Poker[] poker){
        System.out.print("玩家1：");
        for (int i = 0; i < 3; i++) {
            System.out.print(poker[i] + "  ");
        }
        System.out.println();
    }
    //显示二号玩家的牌
     public static void showPoker2(Poker[] poker){
        System.out.print("玩家2：");
        for (int i = 0; i < 3; i++) {
            System.out.print(poker[i] + "  ");
        }
        System.out.println();
        System.out.println();
    }
     //显示赢家
   public static void Winner(Poker []player1,Poker []player2){
       if(isColorCom(player1)&&isColorCom(player2)){
           Winner_isCom(player1,player2);
              }
       else if(isColorCom(player1)&&!isColorCom(player2)){
           System.out.println("玩家1获胜！");
       }
       else if(!isColorCom(player1)&&isColorCom(player2)){
           System.out.println("玩家2获胜！");
       }
       else if(isTri(player1)&&isTri(player2)){
           Winner_isTri(player1,player2);
       }
       else if(isTri(player1)&&!isTri(player2)){
           System.out.println("玩家1获胜！");
       }
       else if(!isTri(player1)&&isTri(player2)){
           System.out.println("玩家2获胜！");
       }
       else if(isCom(player1)&&isCom(player2)){
           Winner_isCom(player1,player2);
       }
       else if(isCom(player1)&&!isCom(player2)){
           System.out.println("玩家1获胜！");
       }
       else if(!isCom(player1)&&isCom(player2)){
           System.out.println("玩家2获胜！");
       }
       else if(isColor(player1)&&isColor(player2)){
           Winner_isSingle(player1,player2);
       }
       else if(isColor(player1)&&!isColor(player2)){
           System.out.println("玩家1获胜！");
       }
       else if(!isColor(player1)&&isColor(player2)){
           System.out.println("玩家2获胜！");
       }
       else if(isPair(player1)&&isPair(player2)){
           Winner_isPair(player1,player2);
       }
       else if(isPair(player1)&&!isPair(player2)){
           System.out.println("玩家1获胜！");
       }
       else if(!isPair(player1)&&isPair(player2)){
           System.out.println("玩家2获胜！");
       }
       else{
           Winner_isSingle(player1,player2);
       }
   }

    private static void Winner_isTri(Poker[] player1, Poker[] player2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

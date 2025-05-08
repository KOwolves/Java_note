/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Poker;

/**
 *
 * @author shaos
 */
public class Poker {

    public String point = null;//扑克牌点数
    public String color = null;//扑克牌花色
    public int num = 1;//实际大小
    
    public Poker(){}

    public String getPoint() {
        return this.point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return color + point;
    }
}
   
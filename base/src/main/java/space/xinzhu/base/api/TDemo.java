package space.xinzhu.base.api;

import sun.net.www.content.text.Generic;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class TDemo<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <T> void show(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        TDemo<String> g1 = new TDemo<String>();
        g1.setT("杨幂");
        System.out.println(g1.getT());

        TDemo<Integer> g2 = new TDemo<Integer>();
        g2.setT(30);
        System.out.println(g2.getT());

        TDemo<Boolean> g3 = new TDemo<Boolean>();
        g3.setT(true);
        System.out.println(g3.getT());

        TDemo g = new TDemo();
        g.show("柳岩");
        g.show(30);
        g.show(true);
        g.show(12.34);
    }
}

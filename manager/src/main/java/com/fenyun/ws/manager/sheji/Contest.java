package com.fenyun.ws.manager.sheji;

import com.fenyun.ws.manager.sheji.bean.ABCBean;
import com.fenyun.ws.manager.sheji.bean.BaseBean;

public class Contest {
    public static void main(String[] args) {

        ABCBean abcBean=new ABCBean();
        abcBean.setPp("11");
        abcBean.setId(2);
        System.out.println();
        System.out.println(AbstractFactoryBuilder.getAbstractFactoryABC().getBoMa("11").insertBoma(abcBean));
    }
}

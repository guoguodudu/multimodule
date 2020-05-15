package com.fenyun.ws.manager.sheji;

import com.fenyun.ws.manager.sheji.bean.ABCBean;
import com.fenyun.ws.manager.sheji.bean.BaseBean;

public class ABC implements IBoMa{
    @Override
    public int insertBoma(BaseBean baseBean) {

        ABCBean abcBean= (ABCBean) baseBean;
        System.out.println("---------");
        System.out.println(abcBean);
        System.out.println("---------");
        return 0;
    }
}

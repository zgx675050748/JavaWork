package com.laoliu.spring5.User;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy  {

    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDao userDao = new UserDaoImpl();
        UserDao userDaoPlus =
                (UserDao)Proxy.newProxyInstance(JdkProxy.class.getClassLoader(),
                interfaces, new UserDaoProxy(userDao));
        int result = userDaoPlus.add(1,2);
        System.out.println(result);
        System.out.println("-------------------------------");
        String id = userDaoPlus.update("zgx123456");
        System.out.println(id);

    }
}


class UserDaoProxy implements InvocationHandler {


    //把被代理对象传递过来,有参构造传递

    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName()=="add") {
            //方法之前执行
            System.out.println("方法之前执行....." + method.getName() + ":传递的参数" + Arrays.toString(args));


            //被执行的方法
            Object res = method.invoke(obj, args);

            //方法之后执行
            System.out.println("方法之后执行....." + obj);
            return res;
        }
        else {
            //方法之前执行
            System.out.println("啥也没做....." + method.getName() + ":传递的参数" + Arrays.toString(args));

            //被执行的方法
            Object res = method.invoke(obj, args);

            //方法之后执行
            System.out.println("啥也没做....." + obj);
            return res;
        }
    }
}

package com.xxx;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author hbj
 * @date 2021/1/21 3:20 下午
 */
public class Main {
    public static void main(String[] args) {
        // 在 ServiceLoader.load() 方法中，首先会尝试获取当前使用的 ClassLoader（获取当前线程绑定的 ClassLoader，
        // 查找失败后使用 SystemClassLoader），然后调用 reload() 方法
        // ServiceLoader.providers 缓存，用来缓存 ServiceLoader创建的实现对象
        ServiceLoader<Log> serviceLoader =
                ServiceLoader.load(Log.class);
        Iterator<Log> iterator = serviceLoader.iterator();
        // LazyIterator.nextService() 方法，该方法负责实例化 hasNextService() 方法读取到的实现类，
        // 其中会将实例化的对象放到 providers 集合中缓存起来
        // 这个迭代器是依赖 LazyIterator 实现的一个匿名内部类
        while (iterator.hasNext()) {
            Log log = iterator.next();
            log.logging("JDK SPI");
        }
    }
}

package space.xinzhu.base.io;

import java.util.Properties;
import java.util.Set;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class PropertiesDemo {
/*    Properties介绍

- 是一个Map体系的集合类
- Properties可以保存到流中或从流中加载
- 属性列表中的每个键及其对应的值都是一个字符串*/

    public void method(){
        //创建集合对象
//        Properties<String,String> prop = new Properties<String,String>(); //错误
        Properties prop = new Properties();

        //存储元素
        prop.put("itheima001", "佟丽娅");
        prop.put("itheima002", "赵丽颖");
        prop.put("itheima003", "刘诗诗");

        //遍历集合
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key + "," + value);
        }
    }

    public static void main(String[] args) {
        //创建集合对象
        Properties prop = new Properties();

        //Object setProperty(String key, String value)：设置集合的键和值，都是String类型
        prop.setProperty("itheima001", "佟丽娅");
        prop.setProperty("itheima002", "赵丽颖");
        prop.setProperty("itheima003", "刘诗诗");

        //String getProperty(String key)：使用此属性列表中指定的键搜索属性
//        System.out.println(prop.getProperty("itheima001"));
//        System.out.println(prop.getProperty("itheima0011"));

//        System.out.println(prop);

        //Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
        Set<String> names = prop.stringPropertyNames();
        for (String key : names) {
//            System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }
    }
}

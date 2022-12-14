package space.xinzhu.base.api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/06
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class StreamDemo {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        //把集合中所有以"张"开头的元素存储到一个新的集合
        ArrayList<String> zhangList = new ArrayList<String>();

        for (String s : list) {
            if (s.startsWith("张")) {
                zhangList.add(s);
            }
        }

//        System.out.println(zhangList);

        //把"张"开头的集合中的长度为3的元素存储到一个新的集合
        ArrayList<String> threeList = new ArrayList<String>();

        for (String s : zhangList) {
            if (s.length() == 3) {
                threeList.add(s);
            }
        }

//        System.out.println(threeList);

        //遍历上一步得到的集合
        for (String s : threeList) {
            System.out.println(s);
        }
        System.out.println("--------");

        //Stream流来改进
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);

        collectStream();
    }

/*    Stream流的三类方法
+ 获取Stream流
  + 创建一条流水线,并把数据放到流水线上准备进行操作
+ 中间方法
  + 流水线上的操作
  + 一次操作完毕之后,还可以继续进行其他操作
+ 终结方法
  + 一个Stream流只能有一个终结方法
  + 是流水线上的最后一个操作*/

/*    生成Stream流的方式
- Collection体系集合
    使用默认方法stream()生成流， default Stream<E> stream()
- Map体系集合
    把Map转成Set集合，间接的生成流
- 数组
    通过Arrays中的静态方法stream生成流
- 同种数据类型的多个数据
    通过Stream接口的静态方法of(T... values)生成流*/

    void createStream() {
        //Collection体系的集合可以使用默认方法stream()生成流
        List<String> list = new ArrayList<String>();
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<String>();
        Stream<String> setStream = set.stream();

        //Map体系的集合间接的生成流
        Map<String, Integer> map = new HashMap<String, Integer>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        //数组可以通过Arrays中的静态方法stream生成流
        String[] strArray = {"hello", "world", "java"};
        Stream<String> strArrayStream = Arrays.stream(strArray);

        //同种数据类型的多个数据可以通过Stream接口的静态方法of(T... values)生成流
        Stream<String> strArrayStream2 = Stream.of("hello", "world", "java");
        Stream<Integer> intStream = Stream.of(10, 20, 30);
    }

    /*
    Stream<T> filter(Predicate predicate) | 用于对流中的数据进行过滤
    Stream<T> limit(long maxSize) | 返回此流中的元素组成的流，截取前指定参数个数的数据
    Stream<T> skip(long n)  | 跳过指定参数个数的数据，返回由该流的剩余元素组成的流
    static <T> Stream<T> concat(Stream a, Stream b) | 合并a和b两个流为一个流
    stream<T> distinct() 返回由该流的不同元素（根据Object.equals(Object) ）组成流
    */
    void operaStream() {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");


        Stream<String> s1 = list.stream().limit(4);
        Stream<String> s2 = list.stream().limit(4);
        Stream.concat(s1, s2).count();


        //需求1：把list集合中以张开头的元素在控制台输出
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
        System.out.println("--------");

        //需求2：把list集合中长度为3的元素在控制台输出
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);
        System.out.println("--------");

        list.stream().distinct().limit(5).skip(4).count();
    }

    /*
    流的终结方法count(),forEach()
    */
        /*
    流的收集方法toList(),toSet(),toMap()
    */
    public static void collectStream() {
        //创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        /*
        //需求1：得到名字为3个字的流
        Stream<String> listStream = list.stream().filter(s -> s.length() == 3);
        //需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历
        List<String> names = listStream.collect(Collectors.toList());
        for(String name : names) {
            System.out.println(name);
        }
        */
        //创建Set集合对象
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);
        /*
        //需求3：得到年龄大于25的流
        Stream<Integer> setStream = set.stream().filter(age -> age > 25);
        //需求4：把使用Stream流操作完毕的数据收集到Set集合中并遍历
        Set<Integer> ages = setStream.collect(Collectors.toSet());
        for(Integer age : ages) {
            System.out.println(age);
        }
        */
        //定义一个字符串数组，每一个字符串数据由姓名数据和年龄数据组合而成
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33", "柳岩,25"};
        //需求5：得到字符串中年龄数据大于28的流
        Stream<String> arrayStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28);
        //需求6：把使用Stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名作键，年龄作值
        Map<String, Integer> map = arrayStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Integer value = map.get(key);
            System.out.println(key + "," + value);
        }
    }
}

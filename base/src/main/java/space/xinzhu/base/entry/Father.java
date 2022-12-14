package space.xinzhu.base.entry;

import lombok.*;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Father {

    private int age;

    int sex;

    protected int money;

    public String name;


    private int privateTest(Father father){
        return father.getAge();
    };

    int defaultTest(Father father){
        return father.getSex();
    };

    protected int protectTest(Father father){
        return father.money;
    };

    public String publicTest(Father father){
        return father.name;
    };

    void Test(){
        Father father = new Father(30 ,1 , 500 , "papa" );
        father.privateTest(father);
        father.defaultTest(father);
        father.protectTest(father);
        father.publicTest(father);
    }

    class Son2{
        void Test2(){
            Father father = new Father(30 ,1 , 500 , "papa" );
            father.privateTest(father);
            father.defaultTest(father);
            father.protectTest(father);
            father.publicTest(father);
        }
    }

    void sayHello(){
        System.out.println("hello");
    }

    private Father(int age){
        this.age=age;
    }
    public Father(int age,String name){
        this.name=name;
        this.age=age;
    }

}

package space.xinzhu.base.entry;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
public class Someone {

    void Test(){
        Father father = new Father(30 ,1 , 500 , "papa" );
        //father.privateTest(father);
        father.defaultTest(father);
        father.protectTest(father);
        father.publicTest(father);
    }
}

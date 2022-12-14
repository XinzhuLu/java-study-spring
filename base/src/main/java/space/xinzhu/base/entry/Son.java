package space.xinzhu.base.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/05
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@Data
public class Son extends Father{

    void sonTest(){
        Father father = new Father(30 ,1 , 500 , "papa" );
        //father.privateTest(father);
        father.defaultTest(father);
        father.protectTest(father);
        father.publicTest(father);
    }
}

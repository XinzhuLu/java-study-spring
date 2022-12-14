package space.xinzhu.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: ???
 * Created by 馨竹 on 2022/12/14
 * --------------------------------------------
 * Update for ??? on ???? / ?? / ?? by ???
 **/
@ConfigurationProperties(prefix = "user")
@Component//必须要添加到Spring容器中才能封装
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;
    private String username;
    private String password;

    public Person(int id, String username) {
        this.id = id;
        this.username = username;
    }
}

// REVU в имени пакета заглавные буквы не разрешены
package com.akrauze.buscompany.dtoRequest;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
// лучше указать, что делается. CreateAdminDtoRequest, например.
public class AdminDtoRequest {
    // REVU а зачем тут id ? Нет никакого id при создании
    int id;
    // REVU посмотрите ТЗ. Там просто набор полей в json. У Вас же получится вложенный json
    // сделайте UserDtoRequest не полем, а класс - наследником UserDtoRequest
    UserDtoRequest userDtoRequest;
    String position;
}

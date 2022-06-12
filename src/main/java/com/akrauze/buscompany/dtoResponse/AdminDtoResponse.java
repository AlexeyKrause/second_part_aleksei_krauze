package com.akrauze.buscompany.dtoResponse;

import com.akrauze.buscompany.model.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminDtoResponse {
    int id;
    // REVU нет, не должен класс DTO содержать внутри себя класс модели
    // у Вас же есть UserDtoResponse, вот и поместите тут его
    // а лучше сделайте AdminDtoResponse его наследником
    // чтоы не получились вложенные структуры
    User user;
    String position;
}

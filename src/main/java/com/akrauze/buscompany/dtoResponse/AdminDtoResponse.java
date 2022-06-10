package com.akrauze.buscompany.dtoResponse;

import com.akrauze.buscompany.model.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminDtoResponse {
    int id;
    User user;
    String position;
}

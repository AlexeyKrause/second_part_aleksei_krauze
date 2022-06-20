package com.akrauze.buscompany.dtoresponse;

import lombok.Data;
import lombok.ToString;
// REVU уберите
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class AdminDtoResponse extends UserDtoResponse {
    int id;
    String position;
    String userType;
}

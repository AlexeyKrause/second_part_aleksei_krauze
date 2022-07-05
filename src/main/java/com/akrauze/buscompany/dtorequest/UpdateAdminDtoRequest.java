package com.akrauze.buscompany.dtorequest;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateAdminDtoRequest extends UpdateUserDtoRequest{
    String position;
}
package com.akrauze.buscompany.model;


import lombok.*;

@Data
@ToString
public class Admin extends User{
       int id;
       String position;
}

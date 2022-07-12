package com.akrauze.buscompany.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TripDtoRequest {
    String busName;
    String fromStation;
    String toStation;
    Date start;
    Date duration;
    Double price;
    Schedule schedule;
    Date[] dates;
}
//"busName": "марка автобуса",
//"fromStation": "начальная станция",
//"toStation": "конечная станция",
//"start": "время отправления",
//"duration": "время в пути",
//"price": цена билета,
//"schedule": {
//"fromDate": "дата начала выполнения маршрута",
//"toDate": "дата окончания выполнения маршрута", // включительно
//"period": "дни рейсов",
//}
//"dates": [
//"день1”, “день2”,..”деньN" // дни выполнения маршрута",
//]

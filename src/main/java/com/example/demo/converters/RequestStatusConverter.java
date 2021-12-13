//package com.example.demo.converters;
//
//import com.example.demo.enums.RequestStatus;
//import com.example.demo.enums.UserType;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.stream.Stream;
//
//
//@Converter
//public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {
//
//    @Override
//    public String convertToDatabaseColumn(RequestStatus requestStatus) {
//        return requestStatus.getStatus();
//    }
//
//    @Override
//    public RequestStatus convertToEntityAttribute(String dbData) {
//        if (dbData == null) {
//            return null;
//        }
//
//        return Stream.of(RequestStatus.values())
//                .filter(c -> c.getStatus().equals(dbData))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }
//
//}

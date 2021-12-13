//package com.example.demo.converters;
//
//import com.example.demo.enums.UserType;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.stream.Stream;
//
//
//@Converter(autoApply = true)
//    public class UserTypeConverter implements AttributeConverter<UserType, String> {
//
//    @Override
//    public String convertToDatabaseColumn(UserType userType) {
//        return userType.getType();
//    }
//
//    @Override
//    public UserType convertToEntityAttribute(String dbData) {
//        if (dbData == null) {
//            return null;
//        }
//
//        return Stream.of(UserType.values())
//                .filter(c -> c.getType().equals(dbData))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }
//}

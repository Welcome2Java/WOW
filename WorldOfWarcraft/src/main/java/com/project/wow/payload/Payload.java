package com.project.wow.payload;

import java.time.LocalDateTime;

public class Payload {

    String role;
    String classPick;
    String month;
    String day;
    String year;
    LocalDateTime localDateTime;

    public Payload(String role, String classPick) {
        this.role=role;
        this.classPick=classPick;
    }

    public String getRole() {
        return role;
    }

    public String getClassPick() {
        return classPick;
    }
    
}

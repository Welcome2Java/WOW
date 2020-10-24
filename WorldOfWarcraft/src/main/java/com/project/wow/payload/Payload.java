package com.project.wow.payload;

import java.time.LocalDateTime;

public class Payload {

    String role;
    String classPick;
    String spec;

    public Payload(String role, String classPick, String spec) {
        this.role=role;
        this.classPick=classPick;
        this.spec = spec;
    }

    public String getRole() {
        return role;
    }

    public String getClassPick() {
        return classPick;
    }

    public String getSpec(){
        return spec;
    }
    
}

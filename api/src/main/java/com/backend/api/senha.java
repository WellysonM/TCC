package com.backend.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class senha {
    public static void main(String[] args) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("->\n");
        System.out.println(passwordEncoder.encode("123"));
    }

}

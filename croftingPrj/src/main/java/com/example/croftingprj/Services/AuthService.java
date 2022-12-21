package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.Client;

public interface AuthService {
    boolean clientLogin(String email, String password);

    boolean stockLogin(String email, String password);
}



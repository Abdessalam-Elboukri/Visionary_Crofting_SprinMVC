package com.example.croftingprj.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Services.AuthService;
import com.example.croftingprj.Services.ClientService;
import com.example.croftingprj.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    StockService stockService;

    @Autowired
    ClientService clientService;

    @GetMapping("/client/login")
    public String clientLogin(){
        return "login";
    }

    @PostMapping("/client/login")
    public String login(@ModelAttribute("client") Client client,HttpServletRequest request){
        if(authService.clientLogin(client.getEmail(),client.getPassword())){
            Client client1 = clientService.findByEmail(client.getEmail());
            if(client1!=null)
                request.getSession().setAttribute("CLIENT_ID", client1.getId());

            return "redirect:/product/all";
        }else{
            return "redirect:/client/login";
        }

    }

    @GetMapping("/stock/login")
    public String stockLogin(){
        return "login";
    }

    @PostMapping("/stock/login")
    public String login(@ModelAttribute("stock") Stock stock,HttpServletRequest request,HttpSession session){
        if(authService.stockLogin(stock.getEmail(),stock.getPassword())){
            Stock stock1 = stockService.findByEmail(stock.getEmail());
            request.getSession().setAttribute("STOCK" , stock1);
            return "redirect:/profile";
        }else{
            return "redirect:/stock/login";
        }

    }






}

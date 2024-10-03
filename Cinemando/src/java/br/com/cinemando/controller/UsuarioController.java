package br.com.cinemando.controller;

import br.com.cinemando.daos.*;
import br.com.cinemando.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    
    @RequestMapping(value = "/inserirUsuario", method = RequestMethod.GET) 
    public ModelAndView usuario() {
        return new ModelAndView("inseriUsuario", "command", new Usuario()); 
    } 
    
    @RequestMapping(value = "/consultarUsuario", method = RequestMethod.GET) 
    public ModelAndView usuario2() {
        return new ModelAndView("consultarUsuario", "command", new Usuario()); 
    }
    
    @ModelAttribute("usuario") 
    public Usuario criarUsuarioModelo() { 
        return new Usuario(); 
    }

    @ModelAttribute("usuario2") 
    public Usuario criarUsuarioModelo2() { 
        return new Usuario(); 
    }
    
    @RequestMapping(value = "/inserirUsuario", method = RequestMethod.POST) 
    public String inserirUsuario(@ModelAttribute("usuario")@Validated Usuario usu, BindingResult bindingResult, Model modelo) { 
        if (bindingResult.hasErrors()) { 
            return "inserirUsuario";
        } 
        modelo.addAttribute("usuNome", usu.getUsuNome());
        modelo.addAttribute("usuLogin", usu.getUsuLogin());
        modelo.addAttribute("usuSenha", usu.getUsuSenha());
        modelo.addAttribute("usuDataN", usu.getUsuDataN());
        modelo.addAttribute("usuEmail", usu.getUsuEmail());
        modelo.addAttribute("usuTel", usu.getUsuTel());
        
        inserirUsuarioBanco(usu);
        return "resultadoCliente"; 
    }
    
    @RequestMapping(value = "/consultarUsuario", method = RequestMethod.POST) 
    public String consultarUsuario(@ModelAttribute("usuario2")Usuario usu, Model modelo) { 
       
        UsuarioModel um= new UsuarioModel();
        Usuario dadosUsuario = um.ConsultarUsuario(usu);
        
        modelo.addAttribute("usuNome", dadosUsuario.getUsuNome()); 
        modelo.addAttribute("usuLogin", dadosUsuario.getUsuCod());
        modelo.addAttribute("usuSenha", dadosUsuario.getUsuSenha());
        modelo.addAttribute("usuDataN", dadosUsuario.getUsuDataN());
        modelo.addAttribute("usuEmail", dadosUsuario.getUsuEmail());
        modelo.addAttribute("usuTel", dadosUsuario.getUsuTel());
        
        return "consultarUsuario"; 
    }
    
    public ArrayList<Usuario> consultarUsuarioBanco(){
        UsuarioModel con = new UsuarioModel();
        ArrayList<Usuario> lista = con.ConsultarUsuarios();
        return lista;
    }
    
    public String inserirUsuarioBanco(Usuario usu){
        UsuarioModel con = new UsuarioModel();
        String res = con.InserirUsuario(usu);
        return res;
    }
    
    public Usuario consultarUsuarioBancoLogin(Usuario login){
        UsuarioModel con = new UsuarioModel(); 
        return con.ConsultarUsuario(login);
    }
    
    
    
        
    @ModelAttribute("webConsultausuario") 
    public Map<Integer, String> webConsultaUsuario() { 
        ArrayList<Usuario>  con = consultarUsuarioBanco();
        
        Map<Integer, String> consultarUsuarios = new HashMap<>();
        for(int i = 0; i < con.size(); i++)
            consultarUsuarios.put(con.get(i).getUsuCod(), con.get(i).getUsuNome());
        return ordenarMap(consultarUsuarios);
    }

    public Map<Integer, String> ordenarMap(Map<Integer, String> consultarUsuario){
         Map<Integer, String> listaOrdenada = consultarUsuario.entrySet()
        .stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
         return listaOrdenada;
    }

}
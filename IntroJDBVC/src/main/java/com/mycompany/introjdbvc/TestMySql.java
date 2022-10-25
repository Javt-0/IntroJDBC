/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.introjdbvc;

import dominio.Persona;
import dominio.PersonaDao;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jonat
 */
public class TestMySql {
    
    
    public static void main(String[]args){
        PersonaDao personaDao = new PersonaDao();
    
        try {
            List<Persona> personas = personaDao.selecionar();
            personas.forEach(persona ->{
                System.out.println("persona = " + persona);
            });
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    
}

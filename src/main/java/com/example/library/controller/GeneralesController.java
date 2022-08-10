package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Libreria;

@RestController  //esta clase va a exponer cosas afuera
@RequestMapping({"generales"}) //forma que se diferencia los demas

public class GeneralesController {

   private Libreria libreria; // Generamos una variable libreria tipo libreria model
   public GeneralesController() //genero control a la clase
   {
      libreria = new Libreria();
      libreria.setNombre("Libreria Central"); //set libreria.setNombre(nombre);del campo aparecen por el @Data de la clase del model
      libreria.setDireccion("Cerca del centro");
      libreria.setTelefono("3005765448");
      libreria.setHorario("9-18");
   }

      @GetMapping("/")    //voy a exponer objeto completo
      public Libreria info()  //crear metodo para traer todo el objeto todos los datos de la  libreria
      {
         return libreria;  //Lo retorna en formato JSON http://localhost:7000/generales/  {"nombre":"Libreria Central","direccion":"Cerca del centro","telefono":"3005765448","horario":"9-18"}
      }

      @GetMapping("/nombre")    //voy a exponer
      public String nombre()  //crear metodo para traer el nombre de la libreria
      {
         return libreria.getNombre();
         //return "Libreria Central";
      }
    
      @GetMapping("/direccion")    
      public String direccion()  //crear metodo para traer la dirección de la libreria
      {
         return "Cerca del parque";
      }
   }

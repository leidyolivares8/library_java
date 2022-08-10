package com.example.library.model;

import lombok.Data;

public @Data class Libreria {  //anotacion @data lombok para que me traiga los get y set
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;

    
}

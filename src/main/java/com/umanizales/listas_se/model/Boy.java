package com.umanizales.listas_se.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * @author JUAN MANUEL
 * metodo que define la clase Boy con sus respectivos parametros para la interaccion con la aplicacion *
 */
public class Boy {

    private String identification;              /** definicion del atributo identificacion */
    private String name;               /** definicion del atributo nombre */
    private Byte age;                /** definicion del atributo edad*/
    private String gender;           /** definicion del atributo genero*/
    private String location;     /** definicion del atributo locacion por codigo*/
    private Boolean orphan; /**definicion para saber si es huerfano */
    private Byte grade;/** definicion del atributo grado */
}

package com.umanizales.listas_se.model;

import lombok.Data;

@Data
/** @author JUAN MANUEL
 * Metodo Node doblemente enlazado con sus respectivoa atributos, que permite crear la lista doblemente enlazada*/
public class NodeDE {
    public Object getData;
    /** Definicion del metodo */
    private Boy data; /** (costal donde se mete el niño) */
    private NodeDE next; /**enlace con el siguiente nodo */
    private NodeDE previous; /**  union con nodo anterior*/

    public NodeDE(Boy data) { /** @param  contructor que se encarga asignacion del paramatreo boy*/
        this.data = data;
    }
}

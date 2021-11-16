package com.umanizales.listas_se.model;

import lombok.Data;

@Data
/** @author JUAN MANUEL
 * Metodo Node doblemente enlazado con sus respectivoa atributos, que permite crear la lista simplemente enlazada*/
public class Node { /** Definicion del metodo */
    private Boy data;/** (costal donde se mete el niño) */
    private Node next;/**enlace con el siguiente nodo */

    public Node(Boy data) { /** @param  contructor que se encarga asignacion del paramatreo boy*/
        this.data = data;
    }
}

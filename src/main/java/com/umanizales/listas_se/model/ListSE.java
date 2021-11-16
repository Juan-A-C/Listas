package com.umanizales.listas_se.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
/**
 *
 */
public class ListSE {
    private Node head;
    private int count;

    public void add(Boy boy) {

        if (head == null) {
            head = new Node(boy);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            ///El quedo parado en el ultimo
            temp.setNext(new Node(boy));
        }
        count++;
    }

    public void addToStar(Boy boy) {
        if (this.head == null) {
            this.head = new Node(boy);
        } else {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            this.head = temp;
        }
        count++;
    }

    public void invert() {
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listTemp.addToStar(temp.getData());
                temp = temp.getNext();

            }
            this.head = listTemp.getHead();
        }


    }

    public int count() {
        int count = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                count++;
                temp = temp.getNext();
            }
        }
        return count;
    }

    public List<Boy> list() {
        if (this.head != null) {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
        return null;
    }

    public void changeXtremes() {
        if (this.head != null && this.head.getNext() != null) {
            Boy start = this.head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            this.head.setData(temp.getData());
            temp.setData(start);

        }
    }

    public void eliminate(String identification) {

        Node anterior = head;
        if (anterior.getData().getIdentification() == identification) {
            head = anterior.getNext();
        } else {

            while (anterior.getNext().getData().getIdentification() != identification) {
                anterior = anterior.getNext();
            }

            if (anterior.getNext().getNext() == null) {
                anterior.setNext(null);
            } else {
                anterior.setNext(anterior.getNext().getNext());

            }
        }

    }


    public void filtrarGenero(String gender) {
        Node temp = head;
        ListSE nuevaLista = new ListSE();
        ListSE hombresLista = new ListSE();
        ListSE mujerLista = new ListSE();
        ListSE hombreMujerLista = new ListSE();
        if (gender.equalsIgnoreCase("Hombre")) {
            while (temp.getNext() != null) {
                if (temp.getData().getGender().equalsIgnoreCase("Hombre")) {
                    nuevaLista.addToStar(temp.getData());
                } else if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                    nuevaLista.add(temp.getData());
                }
                temp = temp.getNext();
            }
            if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                nuevaLista.addToStar(temp.getData());
            } else if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                nuevaLista.add(temp.getData());
            }
            head = nuevaLista.getHead();
        } else if (gender.equalsIgnoreCase("Mujer")) {
            while (temp.getNext() != null) {
                if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                    nuevaLista.addToStar(temp.getData());
                } else if (temp.getData().getGender().equalsIgnoreCase("Hombre")) {
                    nuevaLista.add(temp.getData());
                }
                temp = temp.getNext();
            }
            if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                nuevaLista.addToStar(temp.getData());
            } else if (temp.getData().getGender().equalsIgnoreCase("Hombre")) {
                nuevaLista.addToStar(temp.getData());
            }
            head = nuevaLista.getHead();
        } else if (gender.equalsIgnoreCase("Mujer")) {
            while (temp.getNext() != null) {
                if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                    mujerLista.addToStar(temp.getData());
                } else if (temp.getData().getGender().equalsIgnoreCase("Hombre")) {
                    hombresLista.add(temp.getData());
                }
                temp = temp.getNext();
            }
        } else if (gender.equalsIgnoreCase("Mujer")) {
            while (temp.getNext() != null) {
                if (temp.getData().getGender().equalsIgnoreCase("Mujer")) {
                    hombreMujerLista.add(temp.getData());
                } else if (temp.getData().getGender().equalsIgnoreCase("Hombre")) {
                    hombreMujerLista.addToStar(temp.getData());
                }
                temp = temp.getNext();
            }
        }


    }










}



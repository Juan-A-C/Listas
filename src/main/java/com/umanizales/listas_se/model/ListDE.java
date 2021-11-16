package com.umanizales.listas_se.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** @autor JUAN MANUEL
 * lis doblemente enlazada con sus respectivos metodos para interactuar en toda la lista */
@Data
public class ListDE {  /**@declacion de la lista */


        private NodeDE head; /** asigancion de la cabeza como nodo head */

        public void adicionarNodeDE(Boy boy) { /** @param metodo para adicionar nodo al final */
            if (head == null) { /** se hace la verificacion que la lista este llena o vacia si esta llena se asigna
             el nuevo nodo como cabeza*/

                head = new NodeDE(boy);
            } else {

                NodeDE temp = head; /** se llama el temporal para que sostenga la cabeza */
                while (temp.getNext()    != null) { /** temporal se para en el brazo siguiente */
                    temp = temp.getNext();
                }
                //Ubicado o parado en el último
                temp.setNext(new NodeDE(boy)); /** mete al niño en el costal */
                temp.getNext().setPrevious(temp); /**enlaza el siguiente con el anterior del temporal */

            }
        }

        public void adicionarAlInicio(Boy boy) { /**@param metodo que permite adicionar un nodo al inicio de la lista*/
            if (head != null) { /** verifica si la lista esta vacia*/
                //SI hay datos
                NodeDE temp = new NodeDE(boy); /** agrega el nuevo nodo */
                temp.setNext(head);/** el temporal agarra el brazo del siguinte */
                head.setPrevious(temp); /** la cabeza toma el brazo anterior del temporal */
                head = temp; /** la cabeza es el temporal*/
            } else {
                head = new NodeDE(boy); /** si la lista esta vacia el nuevo niño es la cabeza*/
            }
        }

        public int contarNodosDE() { /**@param metodo para contar los nodos de la lista  */

            if (head != null) { /**pregunta si la lista esta vacia */
                NodeDE temp = head; /** el nodo temporal se para en cabeza */
                int cont = 1; /** el contador es igual a 1*/

                while (temp.getNext() != null) { /**temporal recorre la lista y si el siguiente del temporal
                 esta lleno el contador se aumenta*/
                    temp = temp.getNext();
                    cont++;
                }
                return cont; /**@return se muestra en cuanto queda el contador */
            } else {
                return 0; /**si el contador no aunemta se muestra 0 */
            }
        }



        public void eliminar(String identification) { /** @param metodo para eliminar un nodo por identificacion */

            NodeDE anterior = head; /** nos paramos en la cabeza */
            if (anterior.getData().getIdentification() == identification) { /** pregunta si la identificicacion del nodo
             es igual a la que se quiere eliminar*/
            }
                        else
                    {

                        while (anterior.getNext().getData().getIdentification() != identification) {
                            /** si la identificacion no es la necesitada pasa al siguiente nodo */
                            anterior = anterior.getNext();
                        }

                        if (anterior.getNext().getNext() == null) { /** cuando se encuentra el necesitado el brazo
                         anterior del nodo siguiente toma al nodo*/
                            anterior.setNext(null);/** el nodo se suelta */
                        } else {
                            anterior.setNext(anterior.getNext().getNext()); /** se enlazan el siguiente del eliminado
                             con el anterior al aliminado*/

                        }
                    }

            }


        public void eliminarPosicionDE(byte posicion) { /** @param metodo para eliminar un nodo en una posicicon especifica*/

            if (head != null) { /** se verifica que la lista tenga mas de un elemento */
                if (head.getNext() == null) { /** si la lista solo tiene un elemto se elimina la cabeza*/
                    head = null;

                } else {

                    NodeDE temp = head;
                    int cont = 1;

                    if (cont == posicion) { /** si la posicion es la encontrada se elimina el nodo*/
                        //Eliminar cabeza

                        head = temp.getNext();

                        head.setPrevious(null);

                    } else {
                        while (posicion != cont) { /** si la posicon no es la deseada se aunmenta el contador
                                                    y se pasa el siguiente*/
                            temp = temp.getNext(); /** temporal se para en el siguiente*/
                            cont++;/**contador aumenta */
                        }
                        if (temp.getNext() == null) { /**si el siguiente del temporal es nulo significa que esta parado en el ultimo */
                            temp.getPrevious().setNext(null);

                        } else {
                            temp.getNext().setPrevious(temp.getPrevious());
                            temp.getPrevious().setNext(temp.getNext());
                        }
                    }
                }
            }
        }



        public void intercambiarPosiciones(int pos1, int pos2) { /** @param metodo que intercambia dos posiciones */
            byte cont1 = 1; /** ses ponendos contadores para verificar las posiciones */
            byte cont2 = 1;
            NodeDE temp1 = head;
            NodeDE temp2 = head;

            //Ubicar el temporal 1 en la posicion 1 buscada
            while (cont1 != pos1) {  /**  */
                temp1 = temp1.getNext();
                cont1++;
            }
            //Ubicar el temporal 1 en la posicion 2 buscada
            while (cont2 != pos2) {
                temp2 = temp2.getNext();
                cont2++;
            }

            //Tomar los datos (lo que hay dentro de los nodos) e intercambiarlos, los nodos no se mueven
            Boy temp = temp1.getData();
            temp1.setData(temp2.getData());
            temp2.setData(temp);
        }

        //Pedir la posición en donde va a ir el nodo
        //Preguntar si la lista esta vacía
        //  Si está vacía, ubicar el nodo en la cabeza
        //Si la posicion dada es igual a 1 agregar el nodo en la primera posición, con cabeza.setAnterior nodo nuevo
        //nodo nuevo.set siguiente cabeza
        // Hacer cabeza igual a nodo nuevo
        //Agragar un contador que inicie en 0 y un temporal para recorrer la  lista
        //Recorrer la lista
        //En caso que el contador sea igual a la psoición menos 1, ubicase ahí
        //al siguiente del temporal cambiar el lazo anterior y unirlo con el nodo nuevo
        // y el nodo nuevo cambiar el lazo siguiente por el seiguiente a temporal
        //Al nodo nuevo cambiar el lazo anterior por el temporal
        //A temporal cambiar el seguiente por el nodo nuevo

        public void agregarNodo(int pos, Boy boy) { /**@param metodo para ingresar un nodo en una posicion dada */
            if (head != null) {  /**validacion de la lista */
                int cont = 1;
                NodeDE temp = head; /** nodo temporal se pone en la cabeza */
                if (pos == cont) { /** se la valida si la posicion en la que estamos es la deseada*/
                    adicionarAlInicio(boy); /** si si es se adiciona*/
                } else {
                    while (cont != pos && temp.getNext() != null) temp = temp.getNext();
                    cont++; /** si no es el contador se aunmenta y se pasa al siguiente nodo */
                }
                if (cont < pos) { /** si el contador es menor a la posicion requerida se agraga el nuvo nodo */
                    adicionarNodeDE(boy);
                } else {
                    temp = temp.getPrevious();   /** se para en el anterior*/
                    temp.setPrevious(new NodeDE(boy));
                    temp.getPrevious().setPrevious(temp);
                    temp.setNext(temp.getPrevious());
                    temp.getPrevious().setNext(temp);

                }
            } else {
                adicionarNodeDE(boy);

            }
        }

        public void invertirDE() { /** @param metodo para invertir la lista*/
            if (head != null) { /** valida si la lista esta llena*/
                ListDE listaTemporalDE = new ListDE();/** se crea una lista temporal*/
                NodeDE temp = head; /** nodo temporal se para en cabeza*/
                while (temp != null)/** recorre la lista hasta llegar al ultimo */
                {
                    listaTemporalDE.adicionarAlInicio(temp.getData()); /**se coje el data del ultimo y se adiciona al inicio */
                    temp = temp.getNext();/** ayudante pasa al siguiente*/
                }
                head = listaTemporalDE.getHead(); /** cabeza es el temporal*/
            }
        }

        public Boy encontrarPosicion(byte numeroNodo) { /**@param metodo para encontrar un nodo por posicion */

            if (head!= null) {  /** peregunta si la cabeza esta vacia */
                NodeDE temp = head;/** el temporal se para en la cabeza */
                int cont = 1;/** contador aumenta 1 */
                while (numeroNodo != cont) { /**hace la validacion si es la posicion buscada */
                    temp = temp.getNext();
                    cont++;
                }
                return temp.getData(); /** @return el dato encontrado*/
            }
            return null;/** si no lo encuentra returna nulo*/
        }

        public void contarCiudad() {
            if (head != null) { /** se verifica que la lista tenga mas de un elemento */
                int contManizales = 0;/**se crean los contadores de cada ciudad */
                int contNeira = 0;
                int contPereira = 0;
                int contChinchina = 0;
                NodeDE temp = head;/** el temporal se para e la cabeza*/
                while (temp != null) { /** se recorre la lista mientras se va preguntado de que ciudad es */
                    temp = temp.getNext();
                    /** hace la pregunta si la locacion
                     es igual a chinchina si si lo es aunmenta el contador chinchina y pasa al siguiente*/
                    if (equals(temp.getData().getLocation() == "Chinchina"))
                        contChinchina++;
                    else {
                        if (equals(temp.getData().getLocation() == "Manizales")) {/** hace la pregunta si la locacion
                         es igual a MAnizales si si lo es aunmenta el contador manizales y pasa al siguiente*/
                            contManizales++;
                        } else {
                            if (equals(temp.getData().getLocation() == "Neira")) {/** hace la pregunta si la locacion
                             es igual a neira si si lo es aunmenta el contador neira y pasa al siguiente*/
                                contNeira++;
                            } else {
                                if (equals(temp.getData().getLocation() == "Pereira")) { /** hace la pregunta si la locacion
                                 es igual a Pereira si si lo es aunmenta el contador pereira y pasa al siguiente*/
                                    contPereira++;
                                }
                                temp = temp.getNext();
                                return;
                            }

                        }
                    }
                }
            }
        }


        public void listarPorEdad(){ /** @param se crea el metodo listar por edad de mayor a menor*/
            if (head!=null) { /**validacion de la lista */

            int edadMayor =1; /** se crea el contador inicial para hacer la comparacion*/

                NodeDE temp = head; /** el temporal se posiciona en cabeza*/
                while (temp != null) { /** se recorre la lista*/
                    temp = temp.getNext();
                    if (temp.getData().getAge() == edadMayor)/** si la edad del nodo en el que estoy es mayor al contador
                     ese dato se convierte en el edadMayor y pasa al principio de la lista*/
                        temp=head;
                    temp = temp.getNext();
                    return;
                }
            }
        }
        public void EliminarNiños () { /**@param metodo para eliminar todos los niños de la lista */
            NodeDE temp = head; /** se posiciona el temporal en la cabeza*/

            ListDE nuevaLista = new ListDE(); /** se crea una lista temporal*/
            if (head!=null) {
                while (temp.getNext() != null) { /** se recorre la lista */
                    if (temp.getData().getGender().equalsIgnoreCase("Hombre"))/**se pregunta si el genero
                     es hoombre, si si es hombre se agrega a la nueva lista temporal*/
                        nuevaLista.adicionarAlInicio(temp.getData());
                    temp = temp.getNext();
                }
                    /** cuando se haya recorrido la lista se elimina la cabeza de lista temporal
                     para eliminar la lista*/
                    nuevaLista.head = null;
                }
            }


        public void EliminarNiñas () { /**@param metodo para eliminar todos los niños de la lista */
            NodeDE temp = head ; /** se posiciona el temporal en la cabeza*/
            ListDE nuevaLista = new ListDE(); /** se crea una lista temporal*/
            if (head!=null) {
                while (temp.getNext() != null) { /** se recorre la lista */
                    if (temp.getData().getGender().equalsIgnoreCase("Mujer"))/**se pregunta si el genero
                     es hoombre, si si es hombre se agrega a la nueva lista temporal*/
                        nuevaLista.adicionarAlInicio(temp.getData());
                    temp = temp.getNext();
                    /** cuando se haya recorrido la lista se elimina la cabeza de lista temporal
                     para eliminar la lista*/
                    nuevaLista.head = null;
                }
            }
        }

    /** creacion de las listas de cada ciudad para luego meterlas en un arreglo
     * luego se recoore la lista y se va preguntando la locacion y dependiendo de la locacion se agrupa en un alista*/
        public List<Boy> listBoyChinchina (){
            NodeDE temp = head;
            List<Boy> listBoysChinchina = new ArrayList<>();
            temp = temp.getNext();
            while(temp.getNext() != null ){
                if(equals(Objects.equals(temp.getData().getLocation(), "chinchina"))){
                    listBoysChinchina.add(temp.getData());

                }
            }
            return  listBoysChinchina;


        }

    public List<Boy> listBoyManizales (){
        NodeDE temp = head;
        List<Boy> listBoyManizales = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Objects.equals(temp.getData().getLocation(), "manizales"))){
                listBoyManizales.add(temp.getData());

            }
        }
        return  listBoyManizales;


    }

    public List<Boy> listBoyNeira (){
        NodeDE temp = head;
        List<Boy> listBoyNeira = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Objects.equals(temp.getData().getLocation(), "neira"))){
                listBoyNeira.add(temp.getData());

            }
        }
        return  listBoyNeira;


    }

    public List<Boy> listBoyVillamaria (){
        NodeDE temp = head;
        List<Boy> listBoyVillamaria = new ArrayList<>();
        temp = temp.getNext();
        while(temp.getNext() != null ){
            if(equals(Objects.equals(temp.getData().getLocation(), "Villamaria"))){
                listBoyVillamaria.add(temp.getData());

            }
        }
        return  listBoyVillamaria;


    }
/** metodo que agrupa todas las listas de locacion enun solo arreglo para poder mostrarlo en postman*/
    public List<Boy> listBoys() {
        NodeDE temp = head;
        temp = temp.getNext();
        List<Boy> listBoys = new ArrayList<>();

        listBoys.addAll(listBoyChinchina());
        listBoys.addAll(listBoyNeira());
        listBoys.addAll(listBoyManizales());
        listBoys.addAll(listBoyVillamaria());
        return listBoys;
    }




























}










































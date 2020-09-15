/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundi.logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los metodos logicos para la lectura y escritura de ficheros.
 * @since ServiciosREST 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 * @author Santiago Gomez Caicedo
 */
public class LogicaFicheros {

    BufferedWriter bw;
    BufferedReader br;

    /**
     * Metodo que recibe un String y lo resgitra en el fichero txt
     * @param json 
     */
    public void escribeFichero(String json) {        
        try {
            List<String> listaP = new ArrayList<>();
            listaP = leeFichero();
            bw = new BufferedWriter(new FileWriter("D:\\Universidad\\Linea 2\\ServiciosBasecosREST-master\\fichero1.txt"));            
            for (String obj : listaP) {
                if (obj != null) {
                    bw.write(obj);
                    bw.newLine();
                    bw.flush();
                }
            }           
            bw.write(json);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }

    }

    /**
     * Metodo que abre y lee el fichero txt y retorna un lista de tipo String
     * @return 
     */
    public List<String> leeFichero()  {
       List<String> lista = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("D:\\Universidad\\Linea 2\\ServiciosBasecosREST-master\\fichero1.txt"));
            String linea = br.readLine();
            lista.add(linea);
            while (linea != null) {
                linea = br.readLine();
                lista.add(linea);
           }
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
        return lista;
    }

}

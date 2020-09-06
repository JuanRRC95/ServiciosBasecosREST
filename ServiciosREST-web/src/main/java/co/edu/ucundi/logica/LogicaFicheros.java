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
 *
 * @author Asus
 */
public class LogicaFicheros {

    BufferedWriter bw;
    BufferedReader br;

    public void escribeFichero(String json) {
        //Escribimos en el fichero
        System.out.println("---- Entre a la logica de fichero ---");
        try {
            List<String> listaP = new ArrayList<>();
            listaP = leeFichero();
            bw = new BufferedWriter(new FileWriter("C:\\JavaLineaDeProfundizacion\\ServiciosREST\\fichero1.txt"));
            
            for (String obj : listaP) {
                if (obj != null) {
                    //System.out.println(obj);
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

    public List<String> leeFichero()  {
        //Leemos el fichero y lo mostramos por pantalla
        List<String> lista = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("C:\\JavaLineaDeProfundizacion\\ServiciosREST\\fichero1.txt"));
            String linea = br.readLine();
            lista.add(linea);
            while (linea != null) {
                linea = br.readLine();
                lista.add(linea);
                //System.out.println(linea);                
            }
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
        return lista;
    }

    /*
     public String traerJsonProfesores(){
     List<String> lista = new ArrayList<>();
     try{
     lista=leeFichero();
            
     }catch(IOException e){
     System.out.println(e.getMessage());
     }
     }
     */
}

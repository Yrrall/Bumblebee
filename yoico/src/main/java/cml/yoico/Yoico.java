/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cml.yoico;

//import java.awt.Image;

import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
import net.ifok.image.image4j.codec.ico.ICOEncoder;
//import static java.nio.file.StandardCopyOption.*;
//import java.nio.file.attribute.BasicFileAttributes;

public class Yoico {

    public static void main(String[] args) throws IOException {
        
        int fisieremodificate=0;
        
        
            String locimg;
            Scanner inputlocimg= new Scanner(System.in);
            System.out.println("Calea catre locatia cu imagini: ");
            locimg="" + inputlocimg.nextLine();
        
            String locfolder;
            Scanner inputlocfolder= new Scanner(System.in);
            System.out.println("Calea catre folderul cu foldere: ");
            locfolder="" + inputlocfolder.nextLine();
            
            String locatieerori;
            Scanner inputlocerr= new Scanner(System.in);
            System.out.println("Locatia destinatie a erorilor: ");
            locatieerori="" + inputlocerr.nextLine();
            
            //String locdest;
            //Scanner inputlocdest= new Scanner(System.in);
            //System.out.println("Calea destinatiei: ");
            //locdest="" + inputlocdest.nextLine();
            
            /*
        String locimg;
        try (Scanner locatieimagini = new Scanner(System.in)) {
            System.out.println("Calea catre locatia cu imagini: ");
            locimg = "" + locatieimagini.nextLine();
        }
        
        
        try (Scanner locatiefolder = new Scanner(System.in)){
        System.out.println("Calea catre folderul cu foldere: ");
        String locfolder = "" + locatiefolder.nextLine();
        }
        
        String locdest="";
        Scanner locatiedestinatie = new Scanner(System.in);
        System.out.println("Calea destinatiei: ");
        locdest = "" + locatiedestinatie.nextLine();
        locatiedestinatie.close();
        */
            
        File fisier = new File(locimg);
        
        //List<String> yolo=new ArrayList<>();
        
        //for(String yolos : fisier.list()){
        //    System.out.println(yolos);
        //}
        
        for(String test : fisier.list()){
            System.out.println("[Progres] Lista cu fisierele in dosarul imagini: " + test);
            int numenr = test.lastIndexOf(".");
            String nume = test.substring(0, numenr);
            //System.out.println(nume);
            String extensie = test.substring(numenr);
            //System.out.println(extensie);
            if(".png".equalsIgnoreCase(extensie) || (".jpg".equalsIgnoreCase(extensie)) || (".jpeg".equalsIgnoreCase(extensie))){
                String yoloyolo=fisier + "\\" + test;
                String yoloyolodest=fisier + "\\" + nume + ".ico";
                System.out.println("[Progres] Cale imagine pentru convertire: " + yoloyolo);
                //BufferedImage io = ImageIO.read(new File(yoloyolo));
        
                //ICOEncoder.write(io, new File(yoloyolodest));
                
            }
            
        } // ----------------------------------------------------- Icon Creator
        
        
        File foldere = new File(locfolder);
        
        for(String yofold : foldere.list()){ // ------------------ Foldere
            System.out.println("[Progres] Lista cu folderele in dosarul 'foldere': " + yofold);
            String folderid = "";
            String locatiefolderid = "";
            
            File xmlcheckyo = new File(foldere + "\\" + yofold);
            for(String xmlcheck : xmlcheckyo.list() ){
                System.out.println("[Progres] Lista cu fisierele folderelor: " + xmlcheck);
                int xmlchecksplit = xmlcheck.lastIndexOf(".");
                String xmlcheckformat = xmlcheck.substring(xmlchecksplit);
                //System.out.println("test format" + xmlcheckformat);
                
                
                //System.out.println("yolosss2 - " + xmlcheckformat + " - " + xmlcheck);
                if(".csv".equalsIgnoreCase(xmlcheckformat)){
                    //System.out.println("yolosss2 - 3");
                    String buildpath=foldere + "\\" + yofold + "\\" + xmlcheck;
                    File xmlinside = new File(buildpath);
                    
                    Scanner fisieryo= new Scanner(xmlinside);
                    //System.out.println("yolosss");
                    
                    File eroripotrivire = new File(locatieerori + "\\erori.log");
                    eroripotrivire.createNewFile();
                    int linieyo=0;
                    while(fisieryo.hasNextLine()){
                        String linie = fisieryo.nextLine();
                        linieyo++;
                        if(linieyo >= 2){
                            String[] splityo = linie.split(",");
                            
                            if(folderid.equalsIgnoreCase(splityo[0])){}else{ // --------- Erori
                                
                            //try(FileWriter scriereerori = new FileWriter(eroripotrivire)){
                            //String contenterori="Folderul " + buildpath + " are diferente in csv. \n";
                             //   scriereerori.write(contenterori);
                             //   //scriereerori.newLine();
                            //    scriereerori.close();
                            //}
                            
                            try {
                                Files.write(Paths.get("" + eroripotrivire), ("Folderul " + buildpath + " are diferente in csv. \n").getBytes(), StandardOpenOption.APPEND);
                            }catch (IOException e) {
                                //exception handling left as an exercise for the reader
                            }
                            
                            //Files.writeString(Path.of(System.getProperty("java.io.tmpdir"), "" + eroripotrivire),contenterori + System.lineSeparator(),CREATE, APPEND);
                                
                            }//-------------- Erori
                            
                            folderid = "" + splityo[0];
                            locatiefolderid = "" + buildpath;
                            
                            System.out.println("[Progres] Date corelate: id: " + folderid + " ,locatie: " + locatiefolderid);
                        }
                        //if(linie.contains("unic UA")){
                        //    String[] splityo = linie.split("\"");
                        //    folderid = "" + splityo[5];
                        //    locatiefolderid = "" + buildpath;
                        //    
                        //    System.out.println("[Progres} Date corelate: id: " + folderid + " ,locatie: " + locatiefolderid);
                        //}
                    } // --------------------------------- Citire id folder
                    fisieryo.close();
                }
            } // ------------------------------------------------- ID folder
            
            //---------------------------------------------------- Procesare Finala
                File yoloabc = new File(locimg);
                
                int verificaregasire=0;
                for(String yoloabcimagine : yoloabc.list()){
                    int lastindex= yoloabcimagine.lastIndexOf(".");
                    String substringimgname= yoloabcimagine.substring(0,lastindex);
                    String extensiesubstringyo= yoloabcimagine.substring(lastindex);
                    
                    if(substringimgname.equalsIgnoreCase(folderid)){
                        
                        int lastindexico=yoloabcimagine.lastIndexOf(".");
                        String substringimgyolo=yoloabcimagine.substring(lastindexico);
                        
                        if(".ico".equals(substringimgyolo)){ // verificare extensie
                        File imagineselectata = new File(yoloabc + "\\" + yoloabcimagine);
                        String imagineselectatastring = yoloabc + "\\" + yoloabcimagine;
                        String yoimagecopy= yoloabc + "\\" + yoloabcimagine;
                            //------------------------------------- yolo
                            List<File> arpan = new ArrayList<>();
                            arpan.add(imagineselectata);
                            
                            // ---------- nume folder
                            int nrfoldersep= locatiefolderid.lastIndexOf("\\");
                            String foldersep= locatiefolderid.substring(0,nrfoldersep);
                            int nrfoldersepfasfas= foldersep.lastIndexOf("\\");
                            String numefolder= foldersep.substring(nrfoldersepfasfas);
                            // ----------------------
                            
                            //File foldercreere=new File(locdest + "\\" + numefolder);
                            String locatielucrare="" + locfolder + "\\" + numefolder;
                            //foldercreere.mkdir();
                            
                            File desktopini = new File(locatielucrare + "\\Desktop.ini");
                            try(FileWriter desktopiniwrite = new FileWriter(desktopini)){
                            String desktopinicontent="""
                                        [.ShellClassInfo]
                                        ConfirmFileOp=0
                                        IconResource=""" + folderid + ".ico" + """
                                        \nIconIndex=0
                                        InfoTip=Dosar: """ + folderid + """
                                        \n[ViewState]
                                        Mode=
                                        Vid=
                                        FolderType=Pictures
                                        """; // Setat ca si Pictures pentru a nu primi notificarea ca muti sau stergi un fisier de sistem.
                                desktopiniwrite.write(desktopinicontent);
                                desktopiniwrite.close();
                                
                                System.out.println("[Progres] Fisierul desktop.ini a fost creat.");
                                fisieremodificate++;
                                
                                //String desktopinipathstring=locatielucrare + "\\Desktop.ini";
                                //Runtime.getRuntime().exec("attrib +s +h " + desktopinipathstring);
                                
                                Path desktopinipath=(Path)Paths.get(locatielucrare + "\\Desktop.ini");
                                
                                Files.setAttribute(desktopinipath, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
                                Files.setAttribute(desktopinipath, "dos:system", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
                                
                                
                                Path folderattrib=(Path)Paths.get(locatielucrare);
                                
                                Files.setAttribute(folderattrib, "dos:system", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
                                
                                //System.out.println("Rezultat: " + Runtime.getRuntime().exec("attrib +h " + desktopinipathstring));
                                
                                System.out.println("[Progres] Setarile au fost aplicate.");
                                
                            }
                            
                            
                            
                            
                            String builddest= locfolder + "\\" + numefolder + "\\" + yoloabcimagine;

                            //String buildimage= locfolder + "\\" + numefolder + "\\" + jpgimagine;
                            String buildimage123="";
                            String buildimage321="";
                            
                            int rebuildimagecopy=yoimagecopy.lastIndexOf(".");
                            String rebuildimagecopyyo=yoimagecopy.substring(0,rebuildimagecopy);
                            
                            
                            File rebuilyolosan=new File(rebuildimagecopyyo + ".png");
                            //System.out.println("Fisierul: " + rebuilyolosan);
                            if(rebuilyolosan.exists()){
                                
                                String procesare3="" + rebuilyolosan;
                                int procesare1=procesare3.lastIndexOf("\\");
                                String procesare4=procesare3.substring(procesare1);
                                //int procesare2=procesare4.lastIndexOf(".");
                                //String procesare5=procesare4.substring(0,procesare2);
                                
                                buildimage123="" + rebuilyolosan;
                                buildimage321=locfolder + "\\" + numefolder + "\\" + procesare4;
                                System.out.println("[Progres] Fisierul " + rebuilyolosan + " exista");
                            }
                            File rebuilyolosana=new File(rebuildimagecopyyo + ".jpeg");
                            //System.out.println("Fisierul: " + rebuilyolosana);
                            if(rebuilyolosana.exists()){
                                
                                String procesare3="" + rebuilyolosana;
                                int procesare1=procesare3.lastIndexOf("\\");
                                String procesare4=procesare3.substring(procesare1);
                                //int procesare2=procesare4.lastIndexOf(".");
                                //String procesare5=procesare4.substring(0,procesare2);
                                
                                buildimage123="" + rebuilyolosana;
                                buildimage321=locfolder + "\\" + numefolder + "\\" + procesare4;
                                System.out.println("[Progres] Fisierul " + rebuilyolosana + " exista");
                            }
                            File rebuilyolosanb=new File(rebuildimagecopyyo + ".jpg");
                            //System.out.println("Fisierul: " + rebuilyolosanb);
                            if(rebuilyolosanb.exists()){
                                
                                String procesare3="" + rebuilyolosanb;
                                int procesare1=procesare3.lastIndexOf("\\");
                                String procesare4=procesare3.substring(procesare1);
                                //int procesare2=procesare4.lastIndexOf(".");
                                //String procesare5=procesare4.substring(0,procesare2);
                                
                                buildimage123="" + rebuilyolosanb;
                                buildimage321=locfolder + "\\" + numefolder + "\\" + procesare4;
                                System.out.println("[Progres] Fisierul " + rebuilyolosanb + " exista");
                            }
                            
                            //System.out.println(buildimage123 + " : " + buildimage321);
                            
                            Path yolo123 = (Path)Paths.get(imagineselectatastring);
                            Path yolo321 = (Path)Paths.get(builddest);
                            Path imagecopy123 = (Path)Paths.get("" + buildimage123);
                            Path imagecopy321 = (Path)Paths.get("" + buildimage321);
                            
                            System.out.println("[Progres] Fisier copiat in: " + Files.copy(yolo123, yolo321, StandardCopyOption.REPLACE_EXISTING));
                            System.out.println("[Progres] Fisier copiat in: " + Files.copy(imagecopy123, imagecopy321, StandardCopyOption.REPLACE_EXISTING));
                            //System.out.println("test" + imagecopy123);
                            Path iconpath=(Path)Paths.get(locatielucrare + "\\" + folderid + ".ico");
                                
                            Files.setAttribute(iconpath, "dos:hidden", Boolean.TRUE);
                            Files.setAttribute(iconpath, "dos:system", Boolean.TRUE);
                            
                            System.out.println("[Progres] Icoana a fost aplicata.");
                            
                            //------------------------------------- yolo
                        verificaregasire++;
                        } // verificare extensie
                        
                    } // -------------- Gasire folderid
                    
                }
                
            //---------------------------------------------------- Procesare Finala
            
        } // ----------------------------------------------------- Foldere
        
        
        
        
        
        
        
        
        //BufferedImage io = ImageIO.read(new File("C:/Users/Tsanten/Pictures/Screenshots/393296295347896-1989503335.jpg"));
        
        //ICOEncoder.write(io, new File("C:/Users/Tsanten/Pictures/Screenshots/393296295347896-1989503335.ico"));
        
        //JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
    }
}

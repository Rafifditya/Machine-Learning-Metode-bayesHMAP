/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bayesProba;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Rafif
 */
public class Program {
    public static void main(String[] args) {

         Data datbayes = new Data();
         String menu = "yes";
         Scanner inputdata = new Scanner(System.in);
         Scanner inputmenu = new Scanner(System.in);
         Scanner inputpilihan = new Scanner(System.in);
         Scanner indeks = new Scanner(System.in);
         int pil = 0;
         datbayes.setDatabyid(0, 0, "cerah");
         datbayes.setDatabyid(0, 1, "normal");
         datbayes.setDatabyid(0, 2, "pelan");
         datbayes.setDatabyid(0, 3, "yes");
         
         datbayes.setDatabyid(1, 0, "cerah");
         datbayes.setDatabyid(1, 1, "normal");
         datbayes.setDatabyid(1, 2, "pelan");
         datbayes.setDatabyid(1, 3, "yes");
         
         datbayes.setDatabyid(2, 0, "hujan");
         datbayes.setDatabyid(2, 1, "tinggi");
         datbayes.setDatabyid(2, 2, "pelan");
         datbayes.setDatabyid(2, 3, "no");
         
         datbayes.setDatabyid(3, 0, "cerah");
         datbayes.setDatabyid(3, 1, "normal");
         datbayes.setDatabyid(3, 2, "kencang");
         datbayes.setDatabyid(3, 3, "yes");
         
         datbayes.setDatabyid(4, 0, "hujan");
         datbayes.setDatabyid(4, 1, "tinggi");
         datbayes.setDatabyid(4, 2, "kencang");
         datbayes.setDatabyid(4, 3, "no");
         
         datbayes.setDatabyid(5, 0, "cerah");
         datbayes.setDatabyid(5, 1, "normal");
         datbayes.setDatabyid(5, 2, "pelan");
         datbayes.setDatabyid(5, 3, "yes");
            
        System.out.println("Program HMAP Bayes\n");
        int no = 0;
        
        
        do {
       
            System.out.println("\nMenu Bayes HMAP");
            
            System.out.println("1. Lihat Data Fakta");
            System.out.println("2. inputan Data uji");
            System.out.println("3. exit");
            System.out.print("pilihan:");
            pil = inputpilihan.nextInt();
            
            switch(pil){
                case 1:
                    System.out.println("Data Training");
        for (int i = 0; i < datbayes.getData().length; i++) {
            if (datbayes.getDatabyid(i, 0) == null) {
                no = i;
                break;
            }
        }
        for (int i = 0; i < no; i++) {
            System.out.println(
                    datbayes.getDatabyid(i, 0) + " | " +
                    datbayes.getDatabyid(i, 1) + " | " +
                    datbayes.getDatabyid(i, 2) + " | " +
                    datbayes.getDatabyid(i, 3)
            );
        }
                    break;
                case 2:
                    String input [] = new String[7];
                    float x1yes = 0, x1no = 0,x2yes = 0,x2no = 0,x3yes = 0,x3no = 0;
                    int check = 0;
                    
                    for (int i = 0; i < datbayes.getData().length; i++) {
                        if (datbayes.getDatabyid(i, 0) == null) {
                            check = i;
                            break;
                        }
                    }
                    // CUACA
                    System.out.println("input cuaca [y/t]");
                    System.out.print("pilihan: ");
                    input[4] = indeks.next().trim();
                    if (input[4].equals("y")) {
                        float xtargetyes=0, ntargetyes=0;
                        float xtargetno=0, ntargetno=0;
                        System.out.print("cuaca[cerah/hujan]: ");
                        input[0] = inputdata.next().trim();
                        for (int x = 0; x < check; x++) {
                            if (input[0].equals(datbayes.getDatabyid(x, 0))) {
                                 ntargetyes=x;
                                if (datbayes.getDatabyid(x,3).equals("yes")) {
                                xtargetyes=x;                                    
                                }
                            }
                        }
                        x1yes = xtargetyes / ntargetyes;
                        System.out.println(x1yes);
                        for (int x = 0; x < check; x++) {
                            if (input[0].equals(datbayes.getDatabyid(x, 0))) {
                                  ntargetno++;
                                if (datbayes.getDatabyid(x,3).equals("no")) {
                                   xtargetno++;
                                }
                            }
                        }
                        x1no = xtargetno / ntargetno;
                        System.out.println(x1no);
                    }
                    //--
                    
                    //temperatur
                    System.out.println("input temperatur [y/t]");
                    System.out.print("pilihan: ");
                    input[5] = indeks.next().trim();
                    if (input[5].equals("y")) {
                        float xtargetyes=0, ntargetyes=0;
                        float xtargetno=0, ntargetno=0;
                        System.out.print("Temperatur[normal/tinggi]: ");
                        input[1] = inputdata.next().trim();
                        for (int x = 0; x < check; x++) {
                            if (input[1].equals(datbayes.getDatabyid(x, 1))) {
                                 ntargetyes=x;
                                if (datbayes.getDatabyid(x,3).equals("yes")) {
                                xtargetyes=x;                                    
                                }
                            }
                        }
                        x2yes = xtargetyes / ntargetyes;
                        System.out.println(x2yes);
                        for (int x = 0; x < no; x++) {
                            if (input[1].equals(datbayes.getDatabyid(x, 1))) {
                                ntargetno++;
                                if (datbayes.getDatabyid(x,3).equals("no")) {
                                xtargetno++;
                                }
                            }
                        }
                        x2no = xtargetno / ntargetno;
                        System.out.println(x2no);
                    }
                    //--
                    
                    //angin
                    System.out.println("input kecepatan angin [y/t]");
                    System.out.print("pilihan: ");
                    input[6] = indeks.next().trim();
                    if (input[6].equals("y")) {
                        float xtargetyes=0, ntargetyes=0;
                        float xtargetno=0, ntargetno=0;
                        System.out.print("kecepatan angin[pelan/kencang]: ");
                        input[2] = inputdata.next().trim();
                        for (int x = 0; x < check; x++) {
                            if (input[2].equals(datbayes.getDatabyid(x, 2))) {
                                 ntargetyes++;
                                if (datbayes.getDatabyid(x,3).equals("yes")) {
                                xtargetyes++;
                                }
                            }
                        }
                        x3yes = xtargetyes / ntargetyes;
                        System.out.println(x3yes);
                        for (int x = 0; x < check; x++) {
                            if (input[2].equals(datbayes.getDatabyid(x, 2))) {
                                ntargetno++;
                                if (datbayes.getDatabyid(x,3).equals("no")) {
                                xtargetno++;                               
                                }
                            }
                        }
                        x3no = xtargetno / ntargetno;
                        System.out.println(x3no);
                    }
                    
                    if (input[4].equals("y") && input[5].equals("y") && input[6].equals("y")) {
                        float hasilyes, hasilno;
                        hasilyes = x1yes * x2yes *x3yes;
                        hasilno = x1no * x2no * x3no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    } 
                    else if (input[4].equals("y") && input[5].equals("y")){
                    float hasilyes, hasilno;
                        hasilyes = x1yes * x2yes;
                        hasilno = x1no * x2no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    }
                    else if (input[4].equals("y") && input[6].equals("y")){
                    float hasilyes, hasilno;
                        hasilyes = x1yes * x3yes;
                        hasilno = x1no * x3no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    
                    }
                    else if (input[5].equals("y") && input[6].equals("y")){
                    float hasilyes, hasilno;
                        hasilyes = x3yes * x2yes;
                        hasilno = x3no * x2no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    
                    }
                    else if (input[4].equals("t") && input[5].equals("t")){
                    float hasilyes, hasilno;
                        hasilyes = x3yes;
                        hasilno = x3no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    }
                    else if (input[4].equals("t") && input[6].equals("t")){
                    float hasilyes, hasilno;
                        hasilyes = x2yes;
                        hasilno = x2no;
                                                System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);

                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    
                    }
                    else if (input[5].equals("t") && input[6].equals("t")){
                    float hasilyes, hasilno;
                        hasilyes = x1yes;
                        hasilno = x1no;
                        System.out.println("hasil perhitungan keputusan yes = "+hasilyes);
                        System.out.println("hasil perhitungan keputasan no = "+hasilno);
                        if (hasilyes > hasilno) {
                            System.out.println("KEPUTUSAN : YES");
                        } else {
                        System.out.println("KEPUTUSAN : NO");
                        }
                    
                    }
                    break;
                case 3:
                    exit(0);
                    break;
                default :
                    System.out.println("menu tidak ada");
                    break;
            }
            System.out.print("kemali kemenu utama[yes/no]:");
            menu = inputmenu.next().trim();
        } while (menu.equals("yes"));
        
         
         
    }
}

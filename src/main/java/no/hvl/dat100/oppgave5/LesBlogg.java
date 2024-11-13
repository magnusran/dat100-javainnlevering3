package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        try (Scanner scanner = new Scanner(new File(mappe + "/" + filnavn))) {
            int antallInnlegg = Integer.parseInt(scanner.nextLine());

            Blogg blogg = new Blogg(antallInnlegg);

            for (int i = 0; i < antallInnlegg; i++) {
                Innlegg innlegg = null;

                // Få type
                String type = scanner.nextLine();

                // Få id
                int id = Integer.parseInt(scanner.nextLine());

                // Få navn
                String navn = scanner.nextLine();

                // Få dato
                String dato = scanner.nextLine();

                // Få likes
                int likes = Integer.parseInt(scanner.nextLine());

                // Få tekst
                String tekst = scanner.nextLine();

                switch (type) {
                    case "BILDE":
                        // Få bilde-URL
                        String url = scanner.nextLine();
                        innlegg = new Bilde(id, navn, dato, likes, tekst, url);
                        break;
                    default:
                        innlegg = new Tekst(id, navn, dato, likes, tekst);
                        break;
                }
                blogg.leggTil(innlegg);
            }

            return blogg;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

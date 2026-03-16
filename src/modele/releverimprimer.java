/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * Implémentation concrète d'un relevé bancaire imprimable.
 * Hérite de {@link relever} (classe abstraite) et implémente
 * l'interface {@link imprimer}.
 *
 * Responsabilités :
 * <ul>
 *   <li>Imprimer directement le relevé bancaire via l'API d'impression Java</li>
 * </ul>
 *
 * @author ranae
 */
public class releverimprimer extends relever implements imprimer {

    private static final Logger logger = Logger.getLogger(releverimprimer.class.getName());

    // ---- Constructeurs ----
    public releverimprimer() {
        super();
    }

    public releverimprimer(String numeroCompte, String titulaire, String periode) {
        super(numeroCompte, titulaire, periode);
    }

    @Override
    public void genererRelever(String nomFichier) {
        
    }

    // ====================================================================
    // Implémentation des méthodes ABSTRAITES de relever
    // ====================================================================

    /**
     * Imprime le relevé directement.
     */
    @Override
    public void imprimerRelever(String nomFichier) {
        imprimerPDF(nomFichier);
    }

    // ====================================================================
    // Implémentation des méthodes de l'interface imprimer
    // ====================================================================

    /**
     * 
     * @param transactions
     * @param nomFichier 
     */
    public void genererPDF(ArrayList<Transaction> transactions, String nomFichier) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new java.io.FileOutputStream(nomFichier));
            document.open();

            // Titre
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Relevé Bancaire", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            // Tableau
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 1, 1, 1});

            // En-têtes
            table.addCell("Date");
            table.addCell("Description");
            table.addCell("Dépôt");
            table.addCell("Retrait");
            table.addCell("Solde");

            // Lignes
            double soldeCourant = 0.0; // Assuming initial balance is 0
            for (Transaction t : transactions) {
                double depot = 0.0;
                double retrait = 0.0;
                String type = t.getType().trim();
                if ("Depot".equals(type)) {
                    depot = t.getMontant();
                    soldeCourant += depot;
                } else if ("Retrait".equals(type)) {
                    retrait = t.getMontant();
                    soldeCourant -= retrait;
                }

                table.addCell(t.getDate());
                table.addCell(t.getDescription());
                table.addCell(depot > 0 ? String.format("%.2f$", depot) : "");
                table.addCell(retrait > 0 ? String.format("%.2f$", retrait) : "");
                table.addCell(String.format("%.2f$", soldeCourant));
            }

            document.add(table);
            document.add(new Paragraph(" "));
            // Calculate soldeFinal
            double soldeFinal = 0.0;
            for (Transaction t : transactions) {
                String type = t.getType().trim();
                if ("Depot".equals(type)) {
                    soldeFinal += t.getMontant();
                } else if ("Retrait".equals(type)) {
                    soldeFinal -= t.getMontant();
                }
            }
            document.add(new Paragraph("Solde Final: " + String.format("%.2f$", soldeFinal)));

            document.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erreur lors de la génération du PDF", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Imprime directement le relevé bancaire en utilisant l'API d'impression Java.
     *
     * @param nomFichier non utilisé, mais requis par l'interface
     */
    @Override
    public void imprimerPDF(String nomFichier) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Titre
                g2d.drawString("Relevé Bancaire", 100, 50);
                g2d.drawString("Numéro de compte: " + getNumeroCompte(), 100, 70);
                g2d.drawString("Titulaire: " + getTitulaire(), 100, 90);
                g2d.drawString("Période: " + getPeriode(), 100, 110);

                // En-têtes du tableau
                int y = 140;
                g2d.drawString("Date", 50, y);
                g2d.drawString("Description", 150, y);
                g2d.drawString("Dépôt", 300, y);
                g2d.drawString("Retrait", 400, y);
                g2d.drawString("Solde", 500, y);
                y += 20;

                // Lignes du tableau
                double soldeCourant = getSoldeInitial();
                for (Transaction t : getTransactions()) {
                    double depot = 0.0;
                    double retrait = 0.0;
                    String type = t.getType().trim();
                    if ("Depot".equals(type)) {
                        depot = t.getMontant();
                        soldeCourant += depot;
                    } else if ("Retrait".equals(type)) {
                        retrait = t.getMontant();
                        soldeCourant -= retrait;
                    }

                    g2d.drawString(t.getDate(), 50, y);
                    g2d.drawString(t.getDescription(), 150, y);
                    g2d.drawString(depot > 0 ? String.format("%.2f$", depot) : "", 300, y);
                    g2d.drawString(retrait > 0 ? String.format("%.2f$", retrait) : "", 400, y);
                    g2d.drawString(String.format("%.2f$", soldeCourant), 500, y);
                    y += 20;
                }

                // Solde final
                y += 20;
                g2d.drawString("Solde Final: " + String.format("%.2f$", getSoldeFinal()), 100, y);

                return PAGE_EXISTS;
            }
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException ex) {
                logger.log(Level.SEVERE, "Erreur lors de l'impression", ex);
            }
        }
    }
}

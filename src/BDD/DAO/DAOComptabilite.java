package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.Facture;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOComptabilite {
    private Connection conn;
    private Statement stmt;

    public DAOComptabilite() {
        try {
            conn = ConnexionUnique.getInstance().getConnection();
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }
    }

    public List<Facture> findAll() {
        String req = "SELECT Type, Action, Montant, Detail, Date, Justificatif " +
                "FROM Facture;";
        return returnCompta(req);
    }

    public void insertFacture (Facture facture) {
        try {
            String req = "INSERT INTO Facture (Type, Action, Montant, Detail, Date, Justificatif) " +
                    "VALUES ('" + facture.getType() + "', '" + facture.getAction() + "', '" + facture.getMontant() + "', '" + facture.getDetail() + "', '" + facture.getDate() + "', '" + facture.getJustificatif() + "');";
            stmt.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Facture> returnCompta(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<Facture> TFac = new ArrayList<Facture>();
            java.util.Date date;
            while (rset.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("Date"));
                TFac.add( new Facture(rset.getString("Type"), rset.getString("Action"),
                        rset.getString("Detail"), rset.getDouble("Montant"),
                        new Date(date.getTime()), rset.getString("Justificatif")));
            }
            return TFac;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
}

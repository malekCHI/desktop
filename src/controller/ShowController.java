/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import tn.desktop.entities.Order;
import tn.desktop.services.OrderService;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tn.desktop.utils.DBUtil;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ShowController implements Initializable {

    @FXML
    private AnchorPane dds;
    @FXML
    private Label label1;
    @FXML
    private Label idf1;
    @FXML
    private ImageView ws;
    @FXML
    private Label p;
    @FXML
    private GridPane gird;
    @FXML
    private Label regionlabel;
    @FXML
    private Label payslabel;
    @FXML
    private Label statuslabel;
    @FXML
    private Label phone;
    @FXML
    private ImageView cmde3;
    @FXML
    private ImageView homeMarket;
    @FXML
    private Label home1;
    @FXML
    private Button invoice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        label1.setText(AfficherOrderController.ref_order);
        idf1.setText(AfficherOrderController.region_order);
        payslabel.setText(AfficherOrderController.pays_order);
        statuslabel.setText(AfficherOrderController.status_order);
        p.setText(String.valueOf(AfficherOrderController.code_order));
        phone.setText(String.valueOf(AfficherOrderController.num_order));
        OrderService se =new OrderService();
        Order k = new Order();        

        ImageView img = new ImageView();
        ws.setImage(new Image("http://localhost/pull/public/logo9.png",200,200,true,true));

        
        
    }    


    @FXML
    private void cmde3(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/orderAfficheFront.fxml"));
            Stage stage = (Stage) cmde3.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homeMarket(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Market.fxml"));
            Stage stage = (Stage) home1.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void invoice(ActionEvent event) throws SQLException, DocumentException {
        DBUtil cnx = DBUtil.getInstance();

        PreparedStatement pst=null;
        ResultSet rs=null;
        String guery = " select * from commande";
        try {

            pst= cnx.getCnx().prepareStatement(guery);
            rs= pst.executeQuery();

//            String file_name = Posta.getNom()+".pdf";
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(AfficherOrderController.ref_order+".pdf"));

           
            
            doc.open();
            com.itextpdf.text.Image imgl = com.itextpdf.text.Image.getInstance("C:\\laragon\\www\\pull\\public\\logo9.png");
            imgl.scaleAbsoluteWidth(200);
            imgl.scaleAbsoluteHeight(100);
            imgl.setAlignment(com.itextpdf.text.Image.ALIGN_RIGHT);
            doc.add(imgl);
            
            //com.itextpdf.text.Image img2 = com.itextpdf.text.Image.getInstance("C:\\laragon\\www\\pull\\public\\Crr.PNG");
            //img2.scaleAbsoluteWidth(200);
            //img2.scaleAbsoluteHeight(100);
            //img2.setAlignment(com.itextpdf.text.Image.ALIGN_LEFT);
            //doc.add(img2);
            
           
   
            doc.add(new Paragraph("GameX ",FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Address:petite ARIANA,8011 ",FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("address mail : contact@GameX.com ",FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Phone number:+216 21 345 237",FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("YOUR BILL "));
            doc.add(new Paragraph(" "));
            
            doc.add(new Paragraph("reference ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(AfficherOrderController.ref_order,FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Status ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(AfficherOrderController.status_order,FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Phone number ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(String.valueOf(AfficherOrderController.num_order),FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Country ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(AfficherOrderController.pays_order,FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("Region ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(AfficherOrderController.region_order,FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));
            doc.add(new Paragraph("PostCod ",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.GRAY)));
            doc.add(new Paragraph(String.valueOf(AfficherOrderController.code_order),FontFactory.getFont(FontFactory.TIMES_BOLD,10,BaseColor.BLACK)));

            Paragraph Pargr = new Paragraph();
            doc.add(new Paragraph(" "));
            doc.add(Pargr);
            com.itextpdf.text.Image img3 = com.itextpdf.text.Image.getInstance("C:\\laragon\\www\\pull\\public\\ssse.PNG");
            img3.scaleAbsoluteWidth(200);
            img3.scaleAbsoluteHeight(100);
            img3.setAlignment(com.itextpdf.text.Image.ALIGN_MIDDLE);
            doc.add(img3);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(30);
            table.setHorizontalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell cell;

            
            

            cell = new PdfPCell (new Phrase(String.valueOf(AfficherOrderController.num_order), FontFactory.getFont("Comic Sans MS",12)));
            cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
            cell.setBackgroundColor(BaseColor.BLACK);
            doc.add(cell);



            System.out.println("done");
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Formation details exported to PDF Sheet");
        alert.show();




    

    }
    }

    


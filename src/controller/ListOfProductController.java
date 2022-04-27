/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Category;
import entities.Product;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
import services.ServiceProduct;
import utils.Data;

/**
 * FXML Controller class
 *
 * @author maryem
 */
public class ListOfProductController implements Initializable {

    @FXML
    private AnchorPane show;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private TableView<Product> tableProd;
    @FXML
    private TableColumn<Product, String> refProd;
    @FXML
    private TableColumn<Product, String> nameProd;
    @FXML
    private TableColumn<Product, String> descProd;
    @FXML
    private TableColumn<Product, Integer> stockProd;
    @FXML
    private TableColumn<Product, String> imgProd;
    @FXML
    private TableColumn<Product, Integer> priceProd;
    @FXML
    private Button mod;
    @FXML
    private TextField filterFieldProd;
    @FXML
    private Button addProd;
    public static String ref_recup;
    public static String productnamerecup;
    public static String decriptionrecup;
    public static int pricerecup;
    public static int stockrecup;
    public static int id_rec;
    private Button reload;
    public static String img_recup;

    @FXML
    private TableColumn<Category, String> cat;
    @FXML
    private Label goBtn2;
    @FXML
    private Label goBtnCat;
    @FXML
    private ImageView iconProd;
    @FXML
    private ImageView iconCat;
    @FXML
    private TextField nbrProd;
    @FXML
    private Label stat;
    @FXML
    private ImageView iconStat;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private Button supp;
    @FXML
    private Label MenuClosefront1;
    @FXML
    private ImageView pdf;
    @FXML
    private Button idFront;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        ServiceProduct evcrud = new ServiceProduct();
        ArrayList<Product> ev = (ArrayList<Product>) evcrud.afficher();
        ObservableList<Product> obs = FXCollections.observableArrayList(ev);
        //table.setItems(obs);
        refProd.setCellValueFactory(new PropertyValueFactory<Product,String>("reference"));
        nameProd.setCellValueFactory(new PropertyValueFactory<Product,String>("product_name"));

        descProd.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
        
        
        priceProd.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        stockProd.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
        imgProd.setCellValueFactory(new PropertyValueFactory<Product,String>("image"));
        cat.setCellValueFactory(new PropertyValueFactory<Category,String>("name"));


        
        
        
        
        
        FilteredList<Product> filteredData = new FilteredList<>(FXCollections.observableArrayList(ev), b -> true);
 	// 2. Set the filter Predicate whenever the filter changes.
		filterFieldProd.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(events -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (events.getProductName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (events.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Product> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableProd.comparatorProperty());

        tableProd.setItems(sortedData);
        
        ServiceProduct ec = new ServiceProduct();
        String s = ec.countProduct();
        nbrProd.setText(s);


        

    
        // TODO
    }    

    @FXML
    private void form(MouseEvent event) {
    }

    @FXML
    private void promo(MouseEvent event) {
    }

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent Product) {
        Product ev = tableProd.getSelectionModel().getSelectedItem();
        ServiceProduct udao = ServiceProduct.getInstance();
        udao.supprimer(ev.getProductName());
        System.out.println("Delete success");

        tableProd.refresh();

    }

    @FXML
    private void modifier(ActionEvent Product) {
        Product ev = tableProd.getSelectionModel().getSelectedItem();
        ListOfProductController.ref_recup=ev.getReference();
        ListOfProductController.productnamerecup=ev.getProductName();

        ListOfProductController.decriptionrecup=ev.getDescription();
        
        ListOfProductController.pricerecup=ev.getPrice();
        ListOfProductController.stockrecup=ev.getStock();

        ListOfProductController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/EditProduct.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnAddProd(ActionEvent Product) {
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AddProduct.fxml"));
            Stage stage = (Stage) addProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    private void btnReload(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProducts.fxml"));
            Stage stage = (Stage) reload.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @FXML
    private void goToList2(MouseEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) goBtn2.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goListCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) goBtnCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void iconGoProd(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfProduct.fxml"));
            Stage stage = (Stage) iconProd.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void iconGoCat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/ListOfCategory.fxml"));
            Stage stage = (Stage) iconCat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* @FXML
    private void btnSum(ActionEvent event) {
        ServiceProduct ec = new ServiceProduct();
        String s = ec.countProduct();
        nbrProd.setText(s);
    }*/


    @FXML
    private void btnStat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/PieChartView.fxml"));
            Stage stage = (Stage) stat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void iconBtnStat(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/PieChartView.fxml"));
            Stage stage = (Stage) iconStat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void btnFront(MouseEvent event) {
         Product ev = tableProd.getSelectionModel().getSelectedItem();
        ListOfProductController.ref_recup=ev.getReference();
        ListOfProductController.productnamerecup=ev.getProductName();

        ListOfProductController.decriptionrecup=ev.getDescription();
        ListOfProductController.img_recup=ev.getImage();

        
        ListOfProductController.pricerecup=ev.getPrice();
        ListOfProductController.stockrecup=ev.getStock();

        ListOfProductController.id_rec=ev.getId();

        System.out.println(ev.getId());
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Front.fxml"));
            Stage stage = (Stage) mod.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @FXML
    private void exportToPdf(MouseEvent event) {
        Data cnx = Data.getInstance();

        PreparedStatement pst=null;
        ResultSet rs=null;
        String guery = " select * from product";
        try {   

        pst= cnx.getCnx().prepareStatement(guery);
        rs= pst.executeQuery();

        String file_name = "product.pdf";
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));

        doc.open();

        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("C:\\xampp\\htdocs\\PiDev-Brainstormers-main\\public\\logo9.png");
        img.scaleAbsoluteWidth(600);
        img.scaleAbsoluteHeight(92);
        img.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
        doc.add(img);

        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Product list",FontFactory.getFont(FontFactory.TIMES_BOLD,20,BaseColor.BLUE)));
        doc.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        PdfPCell cell;
        

        cell = new PdfPCell (new Phrase("Reference", FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell (new Phrase("Product Name", FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);

        cell = new PdfPCell (new Phrase("Price", FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(cell);

        
        /////////////////////////////////////////////////////////////////////////////////
        while(rs.next()) {
        cell = new PdfPCell (new Phrase(rs.getString("reference").toString(), FontFactory.getFont("Arial",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
            
            
            
        cell = new PdfPCell (new Phrase(rs.getString("product_name").toString(), FontFactory.getFont("Arial",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        

        cell = new PdfPCell (new Phrase(rs.getString("price").toString(), FontFactory.getFont("Arial",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell); }

        doc.add(table);

        System.out.println("done");
        doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Products details exported to PDF Sheet");
            alert.show();

    }

    @FXML
    private void btnIdFront(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/AllProductFront.fxml"));
            Stage stage = (Stage) iconStat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    

package application.viewer;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.util.logging.Logger;

import application.DAO.objets.Machine;

/**
*
* @author Neo_Ryu
*/
public class MachineEditDialogController {

	 @FXML
	 private TextField txtfld1;
	 @FXML
	 private TextField txtfld2;
	 @FXML
	 private TextField txtfld3;
	 @FXML
	 private TextField txtfld4;
	 @FXML
	 private TextField txtfld5;
	 @FXML
	 private TextField txtfld6;
	 @FXML
	 private TextField txtfld7;

	 private Stage dialogStage;
	 private Machine machine;
	 private boolean okClic = false;
	
	 
	 @FXML
	 private void initialize() {
		 
	 }
	 
	 // STAGE
	 public void setDialogStage(Stage dialogStage) {
		 this.dialogStage = dialogStage;
	 }
	 
	 // DEFINIR TEXTE DES TEXTFIELDS
	 public void setMachine(Machine machine) {
		 this.machine = machine;
		 txtfld1.setText(machine.getId());
		 txtfld2.setText(machine.getIdAfpa());
		 txtfld3.setText(machine.getIdUnique());
		 txtfld4.setText(machine.getDateAchat());
		 txtfld5.setText(machine.getDureeGarantie());
		 txtfld6.setText(machine.getAdresseIP());
		 txtfld7.setText(machine.getType());
	 }	 
	 
	 // BOUTON OK : MainAppFX
	 public boolean isOkClic() {
		 return okClic;
	 }

	 // VALIDATION ENVOI
	 @FXML
	 private void handleOk() {
		 // Verification avant stockage
		 if (isInputValid()) {	
			 machine.setIdSP(txtfld1.getText());
			 machine.setIdAfpaSP(txtfld2.getText());
			 machine.setIdUniqueSP(txtfld3.getText());
			 machine.setDateAchatSP(txtfld4.getText());
			 machine.setDureeGarantieSP(txtfld5.getText());
			 machine.setAdresseIPSP(txtfld6.getText());
			 machine.setTypeSP(txtfld7.getText());
			 
			 okClic = true;		 
			 dialogStage.close();
		 }
	 }
	 
	 // ANNULATION ENVOI
	 @FXML
	 private void handleCancel() {
		 dialogStage.close();
	 }

	 // VERIFICATION
	 private boolean isInputValid() {
		 String errorMessage = "";
		 if (txtfld1.getText() == null || txtfld1.getText().length() == 0) {
			 errorMessage += "ID Necéssaire !\n";
		 }
		 
		 if (txtfld2.getText() == null || txtfld2.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }
		 
		 if (txtfld3.getText() == null || txtfld3.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }
		 
		 if (txtfld4.getText() == null || txtfld4.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }
		 
		 if (txtfld5.getText() == null || txtfld5.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }
		 
		 if (txtfld6.getText() == null || txtfld6.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }  /*
		 else {
		 // tenter de cast en int par exemple
			 try {
				 Integer.parseInt(txtfld6.getText());
			 } catch (NumberFormatException e) {
				 errorMessage += "txtfld6 !\n";
			 }		 
		 }
		 */
		 if (txtfld7.getText() == null || txtfld7.getText().length() == 0) {
			 errorMessage += "Donnée correcte nécessaire !\n";
		 }
		 
		// Affichage d'un message d'erreur si la taille de la chaine est superieur a 0
		 if (errorMessage.length() == 0) {
			 return true;
		 } else {			 
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.initOwner(dialogStage);
			 alert.setTitle("Champs incorrects");
			 alert.setHeaderText("Veuillez remplir correctement les champs...");
			 alert.setContentText(errorMessage);
			 alert.showAndWait();
			 return false;
		 }
	 }
}

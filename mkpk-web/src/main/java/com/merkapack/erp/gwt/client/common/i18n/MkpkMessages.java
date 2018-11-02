package com.merkapack.erp.gwt.client.common.i18n;

import com.google.gwt.i18n.client.Messages;
import com.google.gwt.safehtml.shared.SafeHtml;

public interface MkpkMessages extends Messages {
	// � --> \u00C1 � --> \u00E1 
	// � --> \u00C9 � --> \u00E9 
	// � --> \u00CD � --> \u00ED 
	// � --> \u00D3 � --> \u00F3 
	// � --> \u00DA � --> \u00FA ... acento
	// � --> \u00DC � --> \u00fc ... di�resis
	// � --> \u00D1 � --> \u00F1
	// � --> \u00BA � --> \u00AA 
	// � --> \u00BF
	
	// ----------------------------------------------------------------- Format
	@DefaultMessage("#,##0")
	String integerPattern();

	@DefaultMessage("#,##0.00")
	String decimalPattern();
	
	@DefaultMessage("dd/MM/yyyy")
	String datePattern();
	
	@DefaultMessage("Aceptar")
	String accept();

	@DefaultMessage("Borrar")
	String delete();
	
	@DefaultMessage("Cancelar")
	String cancel();

	@DefaultMessage("\u00BFDesea cancelar la operaci\u00F3n?")
	String cancelAction();

	@DefaultMessage("\u00BFContinuar con el borrado?")
	String deleteConfirmation();
	
	@DefaultMessage("Fabricaci\u00F3n")
	String manufacturing();

	@DefaultMessage("Plan de fabricaci\u00F3n autom\u00E1tica")
	String manufacturingPlanning();

	@DefaultMessage("Estadillo de fabricaci\u00F3n")
	String manufacturingInventory();

	@DefaultMessage("An\u00E1lisis estad\u00EDstico de fabricaci\u00F3n")
	String manufacturingStats();

	@DefaultMessage("Materiales")
	String materials();

	@DefaultMessage("Art\u00EDculos")
	String products();

	@DefaultMessage("Clientes")
	String clients();
	
	@DefaultMessage("M\u00E1quinas")
	String machines();



	
}


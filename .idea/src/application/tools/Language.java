package application.tools;

import java.util.Locale;
import java.util.ResourceBundle;

/**
*
* @author Neo_Ryu
*/
public class Language {

	public Language() {}
	
	// LANGUE
    private static Locale lang;
    public static Locale getLang() {
		return lang;
	}
    public static void setLang(Locale langue) {
    	lang = langue;
	}
	public static Locale getsetLang(Locale langue) {
		lang = langue;
		return lang;
	}
	
	// RESSOURCEBUNDLE
    private static ResourceBundle rsc;
    public static ResourceBundle getRsc() {
		return rsc;
	}
	public static void setRsc(ResourceBundle rsc) {
		Language.rsc = rsc;
	}
	public static ResourceBundle getsetRsc(ResourceBundle resources) {
		rsc = resources;
		return rsc;
	}
}

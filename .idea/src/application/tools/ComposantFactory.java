package application.tools;

import application.interfaces.IComposant;

/**
 * Created by Boris on 15/11/2016.
 */
public class ComposantFactory {

    public IComposant getComposant(String typeComposant){
        if(typeComposant == null){
            return null;
        }
        if(typeComposant.equalsIgnoreCase("")) {


        }

        return null;
    }

}

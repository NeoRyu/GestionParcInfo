package tests.objets;

import application.beans.Batiment;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by Boris on 03/11/2016.
 */
public class BatimentTest {

    private static Validator validator;


    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }




    @Test
    public void setId() throws Exception {
        Batiment batiment = new Batiment();
    }

    @Test
    public void setSite() throws Exception {
        Batiment batiment = new Batiment();
    }

    @Test
    public void setSalle() throws Exception {
        Batiment batiment = new Batiment();
    }

    @Test
    public void addSalle() throws Exception {
        Batiment batiment = new Batiment();
    }

    @Test
    public void removeSalle() throws Exception {
        Batiment batiment = new Batiment();
    }

    @Test
    public void removeAllSalle() throws Exception {
        Batiment batiment = new Batiment();
    }


}
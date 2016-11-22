package tests.objets;

import application.beans.Composant;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Boris on 10/11/2016.
 */
public class ComposantTest {
    Composant composant = new Composant();
    private static Validator validator;
    Set<ConstraintViolation<Composant>> constraintViolations = new Set<ConstraintViolation<Composant>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<ConstraintViolation<Composant>> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(ConstraintViolation<Composant> composantConstraintViolation) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends ConstraintViolation<Composant>> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void checkComposant() throws Exception {
        constraintViolations = validator.validate(composant);
        for (ConstraintViolation<Composant> contraintes : constraintViolations) {
            System.out.println(contraintes.getMessage());
        }
    }



}
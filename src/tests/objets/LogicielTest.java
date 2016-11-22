package tests.objets;

import application.beans.Logiciel;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Boris on 03/11/2016.
 */
public class LogicielTest {
    Logiciel logiciel = new Logiciel();
    private static Validator validator;
    Set<ConstraintViolation<Logiciel>> constraintViolations = new Set<ConstraintViolation<Logiciel>>() {
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
        public Iterator<ConstraintViolation<Logiciel>> iterator() {
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
        public boolean add(ConstraintViolation<Logiciel> logicielConstraintViolation) {
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
        public boolean addAll(Collection<? extends ConstraintViolation<Logiciel>> c) {
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
        constraintViolations = validator.validate(logiciel);
        for (ConstraintViolation<Logiciel> contraintes : constraintViolations) {
            System.out.println(contraintes.getMessage());
        }
    }
    @Test
    public void checkArchitecture() throws Exception {
        int archi = logiciel.getArchitecture();
        assertTrue(archi == 32 || archi == 64);
    }

}
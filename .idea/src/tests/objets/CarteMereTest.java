package tests.objets;

import application.beans.CarteMere;
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
 * Created by Boris on 03/11/2016.
 */
public class CarteMereTest {
    CarteMere carteMere = new CarteMere(2, "merguez", "asus", "machin", "machine",1, "ATX");
    private static Validator validator;
    Set<ConstraintViolation<CarteMere>> constraintViolations = new Set<ConstraintViolation<CarteMere>>() {
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
        public Iterator<ConstraintViolation<CarteMere>> iterator() {
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
        public boolean add(ConstraintViolation<CarteMere> carteMereConstraintViolation) {
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
        public boolean addAll(Collection<? extends ConstraintViolation<CarteMere>> c) {
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
        constraintViolations = validator.validate(carteMere);
        for (ConstraintViolation<CarteMere> contraintes : constraintViolations) {
            System.out.println(contraintes.getPropertyPath());
            System.out.println(contraintes.getMessage());
        }
    }

}
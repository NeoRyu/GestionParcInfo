package tests.objets;

import application.beans.CarteMere;
import application.beans.Composant;
import application.beans.Machine;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.*;

/**
 * Created by Boris on 03/11/2016.
 */
public class MachineTest {

    private static Validator validator;
    //Machine machine = new Machine(1, 1, "kappa", "420 1337", "2016-11-01", 5, "Tablette", "192.168.1.3", false, 1, new ArrayList<Composant>());

    Machine machine = new Machine(1, 1, "kappa", "420 1337", "2014-11-01", 5, "Tablette", "192.168.1.4", false, 1, new ArrayList<Composant>());
    Composant test = new CarteMere();
    Set<ConstraintViolation<Machine>> constraintViolations = new Set<ConstraintViolation<Machine>>() {
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
        public Iterator<ConstraintViolation<Machine>> iterator() {
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
        public boolean add(ConstraintViolation<Machine> machineConstraintViolation) {
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
        public boolean addAll(Collection<? extends ConstraintViolation<Machine>> c) {
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
    public void checkMachine() throws Exception {
        constraintViolations = validator.validate(machine);
        for (ConstraintViolation<Machine> contraintes : constraintViolations) {
            System.out.println(contraintes.getMessage());
        }
    }

    @Test
    public void addComposant() throws Exception {
        machine.addComposant(test);
    }

    @Test
    public void removeComposant() throws Exception {
        machine.addComposant(test);
        machine.removeComposant(test);
    }

    @Test
    public void removeAllComposant() throws Exception {
        machine.addComposant(test);
        machine.removeAllComposant();
    }

    @Test
    public void estSousGarantie() throws Exception {
        System.out.println(machine.estSousGarantie());
    }

    @Test
    public void ipDispo() throws Exception {
        System.out.println(machine.ipDispo());
    }


}
package application.tools;

import application.beans.Machine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Boris on 25/10/2016.
 */

@XmlRootElement(name = "machines")
public class MachineWrapper {


    private List<Machine> machines;

    @XmlElement(name = "machine")
    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machine) {
        this.machines = machine;
    }
}


package application.modeler;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import application.DAO.objets.Machine;

@XmlRootElement(name = "machines")
public class MachineListWrapper {
	 private List<Machine> machines;
	 
	 @XmlElement(name = "machine")
	 public List<Machine> getmachines() {
		 return machines;
	 }
	 
	 public void setMachines(List<Machine> machines) {
		 this.machines = machines;
	 }
}
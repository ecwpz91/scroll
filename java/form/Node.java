/* CS-211-001
 * -------------------------------------------------------------------------------
 * Name: Michael Surbey / G#: G00495157 / Assignment: project #2  / Date: 12/5
 * -------------------------------------------------------------------------------
 * Honor Code Statement: I recieved no assistance on this assignment that
 * violates the ethical guidelines set forth by the professor and class syllabus.
 * -------------------------------------------------------------------------------
 * References:
 *
 * -------------------------------------------------------------------------------
 * Comments:
 * NODE NOT completed
 * -------------------------------------------------------------------------------
 * Psedocode:
 *
 * -------------------------------------------------------------------------------
 * NOTE: width of source code is < 80 characters to facilitate printing
 * -------------------------------------------------------------------------------
*/
import java.util.ArrayList;
/**
 * @author mikesurbey
 */
public class Node {
	
	private String data;
	private Node parent;
	private String tag;
	private ArrayList<Node> children = new ArrayList<Node>();
	
	public Node (String line) {
		if (line.contains("<")) {
			String dataSubstring;
			int firstBracket = line.indexOf("<");
			int secondBracket = line.indexOf(">");
			dataSubstring = line.substring(firstBracket+1, secondBracket);
			data = dataSubstring;
			tag = "tag";
		} else {
			data = line;
			tag = "txt";	
		}
	}
	
	public Node getParent() {
		return parent;
	}
	
	
	public Node addChild (String str) {
		Node newNode = new Node(str);
		newNode.parent = this;
		children.add(newNode);
		return newNode;
	}
	
	public void print() {
		this.print(0);
	}
	
	//print statement for formatted html file
	public void print (int level) {
		String spaces = "";
		
		for (int i=0; i<level; i++)
			spaces += "  ";
		
		if (tag.equalsIgnoreCase("tag")) {
			System.out.println(spaces + "<" + data + ">");
				
		} else 
			System.out.println(spaces + data);
		
		for (int i=0; i<children.size(); i++) {
			Node temp = (Node) children.get(i);
			temp.print(level+1);
		}
		
		if (tag.equalsIgnoreCase("tag") && !data.equalsIgnoreCase("BR")) {
			if (data.contains("TABLE"))
				System.out.println(spaces + "</TABLE>");
			else
				System.out.println(spaces +"</"+ data + ">");
			
		}
	
	}

}

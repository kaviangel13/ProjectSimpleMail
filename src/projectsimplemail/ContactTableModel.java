package projectsimplemail;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * <p>The model for the data to be displayed in the {@code JContactTable} class.</p>
 * @see JContactTable
 */
public class ContactTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 7462013655239078316L;
	private ArrayList<Contact> myContents;
	
	/**
	 * <p>Creates a new {@code ContactTableModel} with the data from the 
	 * {@code DataStore} singleton in this application environment.  
	 * The DataStore object must have been properly initialized prior to the 
	 * construction of this {@code ContactTableModel}.</p>
	 * @see DataStore
	 */
	public ContactTableModel()
	{
		DataStore d = DataStore.getInstance();
		myContents = d.getMyContacts();
	}
	
	@Override
	public String getColumnName(int col) {
		String[] cNames = {"First","MI","Last","Email Address","Phone Number",
				"Street Address","City","State","ZIP Code"};
		return cNames[col];
    }
	
	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public int getRowCount() {
		return myContents.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex)
		{
			case 0:
				return myContents.get(rowIndex).getMyFirst();
			case 1:
				return myContents.get(rowIndex).getMyMI();
			case 2:
				return myContents.get(rowIndex).getMyLast();
			case 3:
				return myContents.get(rowIndex).getMyEmail();
			case 4:
				return myContents.get(rowIndex).getMyPhone();
			case 5:
				return myContents.get(rowIndex).getMyStreetAddress();
			case 6:
				return myContents.get(rowIndex).getMyCity();
			case 7:
				return myContents.get(rowIndex).getMyState();
			case 8:
				return myContents.get(rowIndex).getMyZIP();
			default:
				return new String("AHHHHHHHHH");
		}
	}

}

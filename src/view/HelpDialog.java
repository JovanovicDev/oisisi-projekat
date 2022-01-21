package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

public class HelpDialog extends JDialog {

	private static final long serialVersionUID = 7532094756704393899L;

	public HelpDialog() {
		super();
		setModal(true);
		setTitle("Pomoc");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		String text = "Aplikacija je namenjena da opiše rad studentske službe Fakulteta tehničkih nauka. \n"
				+ "Početni prozor daje uvid u spisak entiteta tipa student, profesora i predmeta. \n"
				+ "Zaposleni može da dodaje, menja i uklanja entitete klikom miša ili  \nprečicama na tastaturi "
				+ "koje će biti navedene na kraju teksta. Dodavanje novog entiteta ili \nizmena postojećeg se izvršava "
				+ "samo ukoliko su zadovoljeni određeni uslovi, tj validacija \nje uspešna. Takođe, u odgovarajućim prozorima "
				+ "moguće je i manipulisanje veza između \nentiteta, npr. dodavanje studenta na predmet ili dodavanje profesora na predmet."
				+ "\nStudentu se može poništiti ocena ili uneti ocena iz položenog predmeta."
				+ "Prečica za unos \nnovog entiteta je Ctrl+N, za izmenu entiteta potrebno je stisnuti na željeni entitet \ni pritisnuti Ctrl+E, "
				+ "a za brisanje entiteta potrebno je selektovati entitet i pritisnuti Ctrl+D."; 

		JTextArea box = new JTextArea(text);
		box.setEditable(false);
		box.setPreferredSize(new Dimension(500,300));
		add(box);
		
		setVisible(true);
	}
}

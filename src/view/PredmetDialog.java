package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import controller.PredmetKontroler;
import model.Adresa;
import model.Predmet;
import model.Profesor;
import model.Predmet.SemesterEnum;
import model.Student.StatusEnum;

public class PredmetDialog extends JDialog {

	private static final long serialVersionUID = 3346592901014711454L;

	/**
	 * 
	 */
	public PredmetDialog() {
		super();
		setModal(true);
		setTitle("Dodavanje predmeta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 350);
		setLocationRelativeTo(null);
		
		JButton potvrdiBtn = new JButton("Potvrdi");		
		JButton odustaniBtn = new JButton("Odustani");
		
		
		JLabel sifraLbl = new JLabel("Sifra predmeta*");
		JTextField sifraTxt = new JTextField();
		sifraTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, sifraLbl, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, sifraLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, sifraTxt, 160, SpringLayout.WEST, sifraLbl);
		layout.putConstraint(SpringLayout.NORTH, sifraTxt, -5, SpringLayout.NORTH, sifraLbl);
		sifraTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(sifraTxt.getText().matches("[A-Z0-9]*") || sifraTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					sifraTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					sifraTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Sifra se sastoji od velikih slova i brojeva.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					sifraTxt.setText(sifraTxt.getText().replaceAll("[^A-Z0-9]", "").substring(0,sifraTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});

		
		JLabel nazivLbl = new JLabel("Naziv predmeta*");
		JTextField nazivTxt = new JTextField();
		nazivTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, nazivLbl, 70, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nazivLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, nazivTxt, 160, SpringLayout.WEST, nazivLbl);
		layout.putConstraint(SpringLayout.NORTH, nazivTxt, -5, SpringLayout.NORTH, nazivLbl);
		nazivTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(nazivTxt.getText().matches("[A-Z][a-z]*")|| nazivTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					nazivTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					nazivTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Naziv predmeta sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					nazivTxt.setText(nazivTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,nazivTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel espbLbl = new JLabel("Broj ESPB*");
		JTextField espbTxt = new JTextField();
		espbTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, espbLbl, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, espbLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, espbTxt, 160, SpringLayout.WEST, espbLbl);
		layout.putConstraint(SpringLayout.NORTH, espbTxt, -5, SpringLayout.NORTH, espbLbl);
		espbTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(espbTxt.getText().matches("[0-9]*")|| espbTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					espbTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					espbTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj ESPB moze da sadrzi samo brojeve.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					espbTxt.setText(espbTxt.getText().replaceAll("[^0-9]", "").substring(0,espbTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel godinaLbl = new JLabel("Godina studija*");
		JComboBox<String> godinaCmb = new JComboBox<String>();
		godinaCmb.setPreferredSize(new Dimension(150,30));
		godinaCmb.addItem("1 (prva)");
		godinaCmb.addItem("2 (druga)");
		godinaCmb.addItem("3 (treca)");
		godinaCmb.addItem("4 (cetvrta)");
		layout.putConstraint(SpringLayout.NORTH, godinaLbl, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godinaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godinaCmb, 160, SpringLayout.WEST, godinaLbl);
		layout.putConstraint(SpringLayout.NORTH, godinaCmb, -5, SpringLayout.NORTH, godinaLbl);
		
		JLabel semestarLbl = new JLabel("Semestar*");
		JComboBox<String> semestarCmb = new JComboBox<String>();
		semestarCmb.setPreferredSize(new Dimension(150,30));
		semestarCmb.addItem("letnji (summer)");
		semestarCmb.addItem("zimski (winter)");
		layout.putConstraint(SpringLayout.NORTH, semestarLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, semestarLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, semestarCmb, 160, SpringLayout.WEST, semestarLbl);
		layout.putConstraint(SpringLayout.NORTH, semestarCmb, -5, SpringLayout.NORTH, semestarLbl);
		
		
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sifraTxt.getText().isEmpty() || nazivTxt.getText().isEmpty() || espbTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Predmet p = new Predmet();
					p.setProf(null);
					p.setSubjectID(sifraTxt.getText());
					p.setName(nazivTxt.getText());
					p.setEspb(Integer.parseInt(espbTxt.getText()));
					p.setYear(godinaCmb.getSelectedIndex()+1);
					if(semestarCmb.getSelectedIndex() == 0) {
						p.setSemester(SemesterEnum.summer);
					} else {
						p.setSemester(SemesterEnum.winter);
					}
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda unosa", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	
                    	PredmetKontroler.getInstance().DodajPredmet(p);
                    	dispose();
                    	
                    } else {
                    	return;
                    }
				}
			}
		});
				
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 160, SpringLayout.WEST, potvrdiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, potvrdiBtn);
		
		add(sifraLbl);
		add(sifraTxt);
		add(nazivLbl);
		add(nazivTxt);
		add(espbLbl);
		add(espbTxt);
		add(godinaLbl);
		add(godinaCmb);
		add(semestarLbl);
		add(semestarCmb);
		add(potvrdiBtn);
		add(odustaniBtn);
		setVisible(true);
}
	
	public PredmetDialog(String subjectID, String name, SemesterEnum semester, int year, Profesor prof, int espb) {
		
		super();
		setModal(true);
		setTitle("Izmena predmeta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 350);
		setLocationRelativeTo(null);
		
		JButton potvrdiBtn = new JButton("Potvrdi");		
		JButton odustaniBtn = new JButton("Odustani");
		
		
		JLabel sifraLbl = new JLabel("Sifra predmeta*");
		JTextField sifraTxt = new JTextField();
		sifraTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, sifraLbl, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, sifraLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, sifraTxt, 160, SpringLayout.WEST, sifraLbl);
		layout.putConstraint(SpringLayout.NORTH, sifraTxt, -5, SpringLayout.NORTH, sifraLbl);
		sifraTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(sifraTxt.getText().matches("[A-Z0-9]*") || sifraTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					sifraTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					sifraTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Sifra se sastoji od velikih slova i brojeva.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					sifraTxt.setText(sifraTxt.getText().replaceAll("[^A-Z0-9]", "").substring(0,sifraTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});

		
		JLabel nazivLbl = new JLabel("Naziv predmeta*");
		JTextField nazivTxt = new JTextField();
		nazivTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, nazivLbl, 70, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nazivLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, nazivTxt, 160, SpringLayout.WEST, nazivLbl);
		layout.putConstraint(SpringLayout.NORTH, nazivTxt, -5, SpringLayout.NORTH, nazivLbl);
		nazivTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(nazivTxt.getText().matches("[A-Z][a-z]*")|| nazivTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					nazivTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					nazivTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Naziv predmeta sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					nazivTxt.setText(nazivTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,nazivTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel espbLbl = new JLabel("Broj ESPB*");
		JTextField espbTxt = new JTextField();
		espbTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, espbLbl, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, espbLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, espbTxt, 160, SpringLayout.WEST, espbLbl);
		layout.putConstraint(SpringLayout.NORTH, espbTxt, -5, SpringLayout.NORTH, espbLbl);
		espbTxt.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(espbTxt.getText().matches("[0-9]*")|| espbTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					espbTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					espbTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj ESPB moze da sadrzi samo brojeve.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					espbTxt.setText(espbTxt.getText().replaceAll("[^0-9]", "").substring(0,espbTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel godinaLbl = new JLabel("Godina studija*");
		JComboBox<String> godinaCmb = new JComboBox<String>();
		godinaCmb.setPreferredSize(new Dimension(150,30));
		godinaCmb.addItem("1 (prva)");
		godinaCmb.addItem("2 (druga)");
		godinaCmb.addItem("3 (treca)");
		godinaCmb.addItem("4 (cetvrta)");
		layout.putConstraint(SpringLayout.NORTH, godinaLbl, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godinaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godinaCmb, 160, SpringLayout.WEST, godinaLbl);
		layout.putConstraint(SpringLayout.NORTH, godinaCmb, -5, SpringLayout.NORTH, godinaLbl);
		
		JLabel semestarLbl = new JLabel("Semestar*");
		JComboBox<String> semestarCmb = new JComboBox<String>();
		semestarCmb.setPreferredSize(new Dimension(150,30));
		semestarCmb.addItem("letnji (summer)");
		semestarCmb.addItem("zimski (winter)");
		layout.putConstraint(SpringLayout.NORTH, semestarLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, semestarLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, semestarCmb, 160, SpringLayout.WEST, semestarLbl);
		layout.putConstraint(SpringLayout.NORTH, semestarCmb, -5, SpringLayout.NORTH, semestarLbl);
		
		sifraTxt.setText(subjectID);
		nazivTxt.setText(name);
        espbTxt.setText(Integer.toString(espb));		
		switch(year) {
			case 1:
				godinaCmb.setSelectedIndex(0);
				break;
			case 2:
				godinaCmb.setSelectedIndex(1);
				break;
			case 3:
				godinaCmb.setSelectedIndex(2);
				break;
			default:
				godinaCmb.setSelectedIndex(3);
				break;
		}
		switch(semester) {
			case summer:
				semestarCmb.setSelectedIndex(0);
				break;
			default:
				semestarCmb.setSelectedIndex(1);
		}		
		
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sifraTxt.getText().isEmpty() || nazivTxt.getText().isEmpty() || espbTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Predmet p = new Predmet();
					p.setProf(null);
					p.setSubjectID(sifraTxt.getText());
					p.setName(nazivTxt.getText());
					p.setEspb(Integer.parseInt(espbTxt.getText()));
					p.setYear(godinaCmb.getSelectedIndex()+1);
					if(semestarCmb.getSelectedIndex() == 0) {
						p.setSemester(SemesterEnum.summer);
					} else {
						p.setSemester(SemesterEnum.winter);
					}
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda unosa", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	
                    	PredmetKontroler.getInstance().DodajPredmet(p);
                    	dispose();
                    	
                    } else {
                    	return;
                    }
				}
			}
		});

		add(sifraLbl);
		add(sifraTxt);
		add(nazivLbl);
		add(nazivTxt);
		add(espbLbl);
		add(espbTxt);
		add(godinaLbl);
		add(godinaCmb);
		add(semestarLbl);
		add(semestarCmb);
		add(potvrdiBtn);
		add(odustaniBtn);
		setVisible(true);
		
	}
}

package gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controllers.StudentKontroler;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

import model.Adresa;
import model.Student;
import model.Student.StatusEnum;

public class AddStudentDialog extends JDialog {


	private static final long serialVersionUID = 1L;
	
	public AddStudentDialog() {
		super();
		setModal(true);
		setTitle("Dodavanje studenta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 550);
		setLocationRelativeTo(null);
		
		JButton potvrdiBtn = new JButton("Potvrdi");		
		JButton odustaniBtn = new JButton("Odustani");
		
		
		JLabel imeLbl = new JLabel("Ime*");
		JTextField imeTxt = new JTextField();
		imeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, imeLbl, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imeLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, imeTxt, 160, SpringLayout.WEST, imeLbl);
		layout.putConstraint(SpringLayout.NORTH, imeTxt, -5, SpringLayout.NORTH, imeLbl);
		imeTxt.addKeyListener(new KeyListener() {
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
				if(imeTxt.getText().matches("[A-Z][a-z]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					imeTxt.setText(imeTxt.getText().replaceAll("[^a-zA-Z]", ""));
				}
			}
			
		});

		
		JLabel prezimeLbl = new JLabel("Prezime*");
		JTextField prezimeTxt = new JTextField();
		prezimeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, prezimeLbl, 70, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, prezimeLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, prezimeTxt, 160, SpringLayout.WEST, prezimeLbl);
		layout.putConstraint(SpringLayout.NORTH, prezimeTxt, -5, SpringLayout.NORTH, prezimeLbl);
		prezimeTxt.addKeyListener(new KeyListener() {
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
				if(prezimeTxt.getText().matches("[A-Z][a-z]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Prezime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					prezimeTxt.setText(prezimeTxt.getText().replaceAll("[^a-zA-Z]", ""));
				}
			}
			
		});
		
		JLabel datumLbl = new JLabel("Datum rodjenja*");
		JTextField datumTxt = new JTextField();
		datumTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, datumLbl, 110, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, datumLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, datumTxt, 160, SpringLayout.WEST, datumLbl);
		layout.putConstraint(SpringLayout.NORTH, datumTxt, -5, SpringLayout.NORTH, datumLbl);
		datumTxt.addKeyListener(new KeyListener() {
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
				if(datumTxt.getText().matches("[0-9.]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Datum sadrzi iskljucivo brojeve i tacke.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					datumTxt.setText(datumTxt.getText().replaceAll("[^0-9.]", ""));
				}
			}
			
		});
	
		JLabel adresaLbl = new JLabel("Adresa stanovanja*");
		JTextField adresaTxt = new JTextField();
		adresaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, adresaLbl, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, adresaTxt, 160, SpringLayout.WEST, adresaLbl);
		layout.putConstraint(SpringLayout.NORTH, adresaTxt, -5, SpringLayout.NORTH, adresaLbl);		
		
		JLabel telefonLbl = new JLabel("Broj telefona*");
		JTextField telefonTxt = new JTextField();
		telefonTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, telefonLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, telefonLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, telefonTxt, 160, SpringLayout.WEST, telefonLbl);
		layout.putConstraint(SpringLayout.NORTH, telefonTxt, -5, SpringLayout.NORTH, telefonLbl);
		telefonTxt.addKeyListener(new KeyListener() {
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
				if(telefonTxt.getText().matches("0[0-9]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj pocinje sa 0 i ima 10 cifara.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					telefonTxt.setText(telefonTxt.getText().replaceAll("[^0-9]", ""));
				}
			}
			
		});
		
		JLabel emailLbl = new JLabel("Email adresa*");
		JTextField emailTxt = new JTextField();
		emailTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, emailLbl, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, emailLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, emailTxt, 160, SpringLayout.WEST, emailLbl);
		layout.putConstraint(SpringLayout.NORTH, emailTxt, -5, SpringLayout.NORTH, emailLbl);
		emailTxt.addKeyListener(new KeyListener() {
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
				if(emailTxt.getText().matches("[a-z0-9.@]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Email sadrzi iskljucivo mala slova, brojeve, tacku i @.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					emailTxt.setText(emailTxt.getText().replaceAll("[^a-z0-9.@]", ""));
				}
			}
			
		});
		
		JLabel indexLbl = new JLabel("Broj indeksa*");
		JTextField indexTxt = new JTextField();
		indexTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, indexLbl, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, indexLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, indexTxt, 160, SpringLayout.WEST, indexLbl);
		layout.putConstraint(SpringLayout.NORTH, indexTxt, -5, SpringLayout.NORTH, indexLbl);
		indexTxt.addKeyListener(new KeyListener() {
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
				if(indexTxt.getText().matches("[A-Z0-9-]*")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Indeks sadrzi iskljucivo dva velika slova na pocetku, broj i godinu upisa.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					indexTxt.setText(indexTxt.getText().replaceAll("[^A-Z0-9-]", ""));
				}
			}
			
		});
		
		JLabel upisLbl = new JLabel("Godina upisa*");
		JTextField upisTxt = new JTextField();
		upisTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, upisLbl, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, upisLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, upisTxt, 160, SpringLayout.WEST, upisLbl);
		layout.putConstraint(SpringLayout.NORTH, upisTxt, -5, SpringLayout.NORTH, upisLbl);
		upisTxt.addKeyListener(new KeyListener() {
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
				if(upisTxt.getText().matches("[0-9]{0,4}")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godina upisa je cetvorocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					upisTxt.setText(upisTxt.getText().replaceAll("[^0-9]", ""));
				}
			}
			
		});
		
		JLabel godinaLbl = new JLabel("Trenutna godina studija*");
		JComboBox<String> godinaCmb = new JComboBox<String>();
		godinaCmb.setPreferredSize(new Dimension(150,30));
		godinaCmb.addItem("1 (prva)");
		godinaCmb.addItem("2 (druga)");
		godinaCmb.addItem("3 (treca)");
		godinaCmb.addItem("4 (cetvrta)");
		layout.putConstraint(SpringLayout.NORTH, godinaLbl, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godinaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godinaCmb, 160, SpringLayout.WEST, godinaLbl);
		layout.putConstraint(SpringLayout.NORTH, godinaCmb, -5, SpringLayout.NORTH, godinaLbl);
		
		JLabel finansiranjeLbl = new JLabel("Nacin finansiranja*");
		JComboBox<String> finansiranjeCmb = new JComboBox<String>();
		finansiranjeCmb.setPreferredSize(new Dimension(150,30));
		finansiranjeCmb.addItem("Budzet");
		finansiranjeCmb.addItem("Samofinansiranje");
		layout.putConstraint(SpringLayout.NORTH, finansiranjeLbl, 390, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeCmb, 160, SpringLayout.WEST, finansiranjeLbl);
		layout.putConstraint(SpringLayout.NORTH, finansiranjeCmb, -5, SpringLayout.NORTH, finansiranjeLbl);
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 430, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 160, SpringLayout.WEST, potvrdiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, potvrdiBtn);
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(imeTxt.getText().isEmpty() || prezimeTxt.getText().isEmpty() || datumTxt.getText().isEmpty() || 
					adresaTxt.getText().isEmpty() || telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
					indexTxt.getText().isEmpty() || upisTxt.getText().isEmpty() || godinaCmb.getSelectedItem() == null || 
					finansiranjeCmb.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Student s = new Student();
					s.setName(imeTxt.getText());
					s.setSurname(prezimeTxt.getText());
					//String datum = datumTxt.getText(); 
					//Date date;
					/*try {
						date = new SimpleDateFormat("dd/MM/yyyy").parse(datum);
						s.setBirthDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  */
					s.setBirthDate(new Date());
					String adresa = adresaTxt.getText();
					String[] ulicaGradDrzava = adresa.split(",");
					String ulicaIBroj = ulicaGradDrzava[0];
					String[] ulicaBroj = ulicaIBroj.split(" ");
					String ulica = ulicaBroj[0];
					int broj = Integer.parseInt(ulicaBroj[1]);
					String grad = ulicaGradDrzava[1];
					String drzava = ulicaGradDrzava[2];
					Adresa a = new Adresa(ulica,broj,grad,drzava);
					s.setAdress(a);
					s.setPhone(telefonTxt.getText());
					s.setEmail(emailTxt.getText());
					s.setIndex(indexTxt.getText());
					s.setEnrollmentYear(Integer.parseInt(upisTxt.getText()));
					s.setStudyYear(godinaCmb.getSelectedIndex()+1);
					s.setAverageGrade(0.0);
					if(finansiranjeCmb.getSelectedIndex() == 0) {
						s.setStatus(StatusEnum.B);
					} else {
						s.setStatus(StatusEnum.S);
					}
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	StudentKontroler.getInstance().DodajStudenta(s);;
                    	
                    } else {
                    	return;
                    }
				}
			}
		});
		
		add(imeLbl);
		add(imeTxt);
		add(prezimeLbl);
		add(prezimeTxt);
		add(datumLbl);
		add(datumTxt);
		add(adresaLbl);
		add(adresaTxt);
		add(telefonLbl);
		add(telefonTxt);
		add(emailLbl);
		add(emailTxt);
		add(indexLbl);
		add(indexTxt);
		add(upisLbl);
		add(upisTxt);
		add(godinaLbl);
		add(godinaCmb);
		add(finansiranjeLbl);
		add(finansiranjeCmb);
		add(potvrdiBtn);
		add(odustaniBtn);
		
		
		
		setVisible(true);
	}
	
}

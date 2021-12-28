package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import controller.StudentKontroler;
import model.Adresa;
import model.Student;
import model.Student.StatusEnum;

public class StudentDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	public StudentDialog( ) {
		super();
		setModal(true);
		setTitle("Dodavanje studenta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 700);
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
				if(imeTxt.getText().matches("[A-Z][a-z]*")|| imeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					imeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					imeTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					imeTxt.setText(imeTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,imeTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(prezimeTxt.getText().matches("[A-Z][a-z]*")|| prezimeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					prezimeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					prezimeTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Prezime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					prezimeTxt.setText(prezimeTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,prezimeTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(datumTxt.getText().matches("[0-9.]*")|| datumTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					datumTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					datumTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Datum sadrzi iskljucivo brojeve i tacke.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					datumTxt.setText(datumTxt.getText().replaceAll("[^0-9.]", "").substring(0,datumTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
	
		JLabel adresaLbl = new JLabel("Adresa stanovanja:");
		layout.putConstraint(SpringLayout.NORTH, adresaLbl, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaLbl, 20, SpringLayout.WEST, this);	
		
		JLabel ulicaLbl = new JLabel("Ulica*");
		JTextField ulicaTxt = new JTextField();
		ulicaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, ulicaLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ulicaLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, ulicaTxt, 140, SpringLayout.WEST, ulicaLbl);
		layout.putConstraint(SpringLayout.NORTH, ulicaTxt, -5, SpringLayout.NORTH, ulicaLbl);
		ulicaTxt.addKeyListener(new KeyListener() {
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
				if(ulicaTxt.getText().matches("[A-Z][a-z]*")|| ulicaTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					ulicaTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					ulicaTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ulica sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					ulicaTxt.setText(ulicaTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,ulicaTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel brojLbl = new JLabel("Broj*");
		JTextField brojTxt = new JTextField();
		brojTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brojLbl, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brojLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, brojTxt, 140, SpringLayout.WEST, brojLbl);
		layout.putConstraint(SpringLayout.NORTH, brojTxt, -5, SpringLayout.NORTH, brojLbl);
		brojTxt.addKeyListener(new KeyListener() {
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
				if(brojTxt.getText().matches("[0-9]*")|| brojTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					brojTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brojTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brojTxt.setText(brojTxt.getText().replaceAll("[^0-9]", "").substring(0,brojTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel gradLbl = new JLabel("Grad*");
		JTextField gradTxt = new JTextField();
		gradTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, gradLbl, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, gradLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, gradTxt, 140, SpringLayout.WEST, gradLbl);
		layout.putConstraint(SpringLayout.NORTH, gradTxt, -5, SpringLayout.NORTH, gradLbl);
		gradTxt.addKeyListener(new KeyListener() {
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
				if(gradTxt.getText().matches("[A-Z][a-z]*")|| gradTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					gradTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					gradTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Grad sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					gradTxt.setText(gradTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,gradTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel drzavaLbl = new JLabel("Drzava*");
		JTextField drzavaTxt = new JTextField();
		drzavaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, drzavaLbl, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, drzavaLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, drzavaTxt, 140, SpringLayout.WEST, drzavaLbl);
		layout.putConstraint(SpringLayout.NORTH, drzavaTxt, -5, SpringLayout.NORTH, drzavaLbl);
		drzavaTxt.addKeyListener(new KeyListener() {
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
				if(drzavaTxt.getText().matches("[A-Z][a-z]*")|| drzavaTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					drzavaTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					drzavaTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Drzava sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					drzavaTxt.setText(drzavaTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,drzavaTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel telefonLbl = new JLabel("Broj telefona*");
		JTextField telefonTxt = new JTextField();
		telefonTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, telefonLbl, 350, SpringLayout.NORTH, this);
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
				if(telefonTxt.getText().matches("0[0-9]*")|| telefonTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					telefonTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					telefonTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj pocinje sa 0 i ima 10 cifara.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					telefonTxt.setText(telefonTxt.getText().replaceAll("[^0-9]", "").substring(0,telefonTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel emailLbl = new JLabel("Email adresa*");
		JTextField emailTxt = new JTextField();
		emailTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, emailLbl, 390, SpringLayout.NORTH, this);
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
				if(emailTxt.getText().matches("[a-z0-9.@]*")|| emailTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					emailTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					emailTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Email sadrzi iskljucivo mala slova, brojeve, tacku i @.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					emailTxt.setText(emailTxt.getText().replaceAll("[^a-z0-9.@]", "").substring(0,emailTxt.getText().length()-1));
				}
			}
			
		});
		
		JLabel indexLbl = new JLabel("Broj indeksa*");
		JTextField indexTxt = new JTextField();
		indexTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, indexLbl, 430, SpringLayout.NORTH, this);
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
				if(indexTxt.getText().matches("[A-Z0-9-]*")|| indexTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					indexTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					indexTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Indeks sadrzi iskljucivo dva velika slova na pocetku, broj i godinu upisa.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					indexTxt.setText(indexTxt.getText().replaceAll("[^A-Z0-9-]", "").substring(0,indexTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel upisLbl = new JLabel("Godina upisa*");
		JTextField upisTxt = new JTextField();
		upisTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, upisLbl, 470, SpringLayout.NORTH, this);
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
				if(upisTxt.getText().matches("[0-9]{0,4}")|| upisTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					upisTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					upisTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godina upisa je cetvorocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					upisTxt.setText(upisTxt.getText().replaceAll("[^0-9]", "").substring(0,upisTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
		layout.putConstraint(SpringLayout.NORTH, godinaLbl, 510, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godinaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godinaCmb, 160, SpringLayout.WEST, godinaLbl);
		layout.putConstraint(SpringLayout.NORTH, godinaCmb, -5, SpringLayout.NORTH, godinaLbl);
		
		JLabel finansiranjeLbl = new JLabel("Nacin finansiranja*");
		JComboBox<String> finansiranjeCmb = new JComboBox<String>();
		finansiranjeCmb.setPreferredSize(new Dimension(150,30));
		finansiranjeCmb.addItem("Budzet");
		finansiranjeCmb.addItem("Samofinansiranje");
		layout.putConstraint(SpringLayout.NORTH, finansiranjeLbl, 550, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeCmb, 160, SpringLayout.WEST, finansiranjeLbl);
		layout.putConstraint(SpringLayout.NORTH, finansiranjeCmb, -5, SpringLayout.NORTH, finansiranjeLbl);
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 590, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 160, SpringLayout.WEST, potvrdiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, potvrdiBtn);
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(imeTxt.getText().isEmpty() || prezimeTxt.getText().isEmpty() || datumTxt.getText().isEmpty() || 
				    ulicaTxt.getText().isEmpty() || brojTxt.getText().isEmpty() || gradTxt.getText().isEmpty() ||
				    drzavaTxt.getText().isEmpty() ||telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
					indexTxt.getText().isEmpty() || upisTxt.getText().isEmpty() || godinaCmb.getSelectedItem() == null || 
					finansiranjeCmb.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Student s = new Student();
					s.setName(imeTxt.getText());
					s.setSurname(prezimeTxt.getText());
					try {
						Date d = new SimpleDateFormat("dd.MM.yyyy").parse(datumTxt.getText());
						s.setBirthDate(d);	
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(new JPanel(), "Format datuma je dd.MM.yyyy .", "Warning",
						        JOptionPane.WARNING_MESSAGE);
					}
					String ulica = ulicaTxt.getText();
					int broj = Integer.parseInt(brojTxt.getText());
					String grad = gradTxt.getText();
					String drzava = drzavaTxt.getText();
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
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda unosa", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	StudentKontroler.getInstance().DodajStudenta(s);
                    	dispose();
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
		add(ulicaLbl);
		add(ulicaTxt);
		add(brojLbl);
		add(brojTxt);
		add(gradLbl);
		add(gradTxt);
		add(drzavaLbl);
		add(drzavaTxt);
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
	
	
	public StudentDialog(String id, String surname, String name, Date birthDate, Adresa adress, String phone, String email,
			String index, int enrollmentYear, int studyYear, StatusEnum status, Double averageGrade) {
		
		super();
		setModal(true);
		setTitle("Izmena studenta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 700);
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
				if(imeTxt.getText().matches("[A-Z][a-z]*")|| imeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					imeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					imeTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					imeTxt.setText(imeTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,imeTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(prezimeTxt.getText().matches("[A-Z][a-z]*")|| prezimeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					prezimeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					prezimeTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Prezime sadrzi iskljucivo prvo veliko i ostala mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					prezimeTxt.setText(prezimeTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,prezimeTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(datumTxt.getText().matches("[0-9.]*")|| datumTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					datumTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					datumTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Datum sadrzi iskljucivo brojeve i tacke.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					datumTxt.setText(datumTxt.getText().replaceAll("[^0-9.]", "").substring(0,datumTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
	
		JLabel adresaLbl = new JLabel("Adresa stanovanja:");
		layout.putConstraint(SpringLayout.NORTH, adresaLbl, 150, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaLbl, 20, SpringLayout.WEST, this);	
		
		JLabel ulicaLbl = new JLabel("Ulica*");
		JTextField ulicaTxt = new JTextField();
		ulicaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, ulicaLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ulicaLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, ulicaTxt, 140, SpringLayout.WEST, ulicaLbl);
		layout.putConstraint(SpringLayout.NORTH, ulicaTxt, -5, SpringLayout.NORTH, ulicaLbl);
		ulicaTxt.addKeyListener(new KeyListener() {
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
				if(ulicaTxt.getText().matches("[A-Z][a-z]*")|| ulicaTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					ulicaTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					ulicaTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ulica sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					ulicaTxt.setText(ulicaTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,ulicaTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel brojLbl = new JLabel("Broj*");
		JTextField brojTxt = new JTextField();
		brojTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brojLbl, 230, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brojLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, brojTxt, 140, SpringLayout.WEST, brojLbl);
		layout.putConstraint(SpringLayout.NORTH, brojTxt, -5, SpringLayout.NORTH, brojLbl);
		brojTxt.addKeyListener(new KeyListener() {
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
				if(brojTxt.getText().matches("[0-9]*")|| brojTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					brojTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brojTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brojTxt.setText(brojTxt.getText().replaceAll("[^0-9]", "").substring(0,brojTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel gradLbl = new JLabel("Grad*");
		JTextField gradTxt = new JTextField();
		gradTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, gradLbl, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, gradLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, gradTxt, 140, SpringLayout.WEST, gradLbl);
		layout.putConstraint(SpringLayout.NORTH, gradTxt, -5, SpringLayout.NORTH, gradLbl);
		gradTxt.addKeyListener(new KeyListener() {
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
				if(gradTxt.getText().matches("[A-Z][a-z]*")|| gradTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					gradTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					gradTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Grad sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					gradTxt.setText(gradTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,gradTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel drzavaLbl = new JLabel("Drzava*");
		JTextField drzavaTxt = new JTextField();
		drzavaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, drzavaLbl, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, drzavaLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, drzavaTxt, 140, SpringLayout.WEST, drzavaLbl);
		layout.putConstraint(SpringLayout.NORTH, drzavaTxt, -5, SpringLayout.NORTH, drzavaLbl);
		drzavaTxt.addKeyListener(new KeyListener() {
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
				if(drzavaTxt.getText().matches("[A-Z][a-z]*")|| drzavaTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					drzavaTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					drzavaTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Drzava sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					drzavaTxt.setText(drzavaTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,drzavaTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel telefonLbl = new JLabel("Broj telefona*");
		JTextField telefonTxt = new JTextField();
		telefonTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, telefonLbl, 350, SpringLayout.NORTH, this);
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
				if(telefonTxt.getText().matches("0[0-9]*")|| telefonTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					telefonTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					telefonTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj pocinje sa 0 i ima 10 cifara.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					telefonTxt.setText(telefonTxt.getText().replaceAll("[^0-9]", "").substring(0,telefonTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel emailLbl = new JLabel("Email adresa*");
		JTextField emailTxt = new JTextField();
		emailTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, emailLbl, 390, SpringLayout.NORTH, this);
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
				if(emailTxt.getText().matches("[a-z0-9.@]*")|| emailTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					emailTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					emailTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Email sadrzi iskljucivo mala slova, brojeve, tacku i @.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					emailTxt.setText(emailTxt.getText().replaceAll("[^a-z0-9.@]", "").substring(0,emailTxt.getText().length()-1));
				}
			}
			
		});
		
		JLabel indexLbl = new JLabel("Broj indeksa*");
		JTextField indexTxt = new JTextField();
		indexTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, indexLbl, 430, SpringLayout.NORTH, this);
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
				if(indexTxt.getText().matches("[A-Z0-9-]*")|| indexTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					indexTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					indexTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Indeks sadrzi iskljucivo dva velika slova na pocetku, broj i godinu upisa.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					indexTxt.setText(indexTxt.getText().replaceAll("[^A-Z0-9-]", "").substring(0,indexTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel upisLbl = new JLabel("Godina upisa*");
		JTextField upisTxt = new JTextField();
		upisTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, upisLbl, 470, SpringLayout.NORTH, this);
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
				if(upisTxt.getText().matches("[0-9]{0,4}")|| upisTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					upisTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					upisTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godina upisa je cetvorocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					upisTxt.setText(upisTxt.getText().replaceAll("[^0-9]", "").substring(0,upisTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
		layout.putConstraint(SpringLayout.NORTH, godinaLbl, 510, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godinaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godinaCmb, 160, SpringLayout.WEST, godinaLbl);
		layout.putConstraint(SpringLayout.NORTH, godinaCmb, -5, SpringLayout.NORTH, godinaLbl);
		
		JLabel finansiranjeLbl = new JLabel("Nacin finansiranja*");
		JComboBox<String> finansiranjeCmb = new JComboBox<String>();
		finansiranjeCmb.setPreferredSize(new Dimension(150,30));
		finansiranjeCmb.addItem("Budzet");
		finansiranjeCmb.addItem("Samofinansiranje");
		layout.putConstraint(SpringLayout.NORTH, finansiranjeLbl, 550, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, finansiranjeCmb, 160, SpringLayout.WEST, finansiranjeLbl);
		layout.putConstraint(SpringLayout.NORTH, finansiranjeCmb, -5, SpringLayout.NORTH, finansiranjeLbl);
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 590, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 160, SpringLayout.WEST, potvrdiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, potvrdiBtn);
		
		imeTxt.setText(name);
		prezimeTxt.setText(surname);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
        String strDate = dateFormat.format(birthDate); 
        datumTxt.setText(strDate);
		ulicaTxt.setText(adress.getStreet());
		brojTxt.setText(Integer.toString(adress.getNumber()));
		gradTxt.setText(adress.getCity());
		drzavaTxt.setText(adress.getCountry());
		telefonTxt.setText(phone);
		emailTxt.setText(email);
		indexTxt.setText(index);
		
		upisTxt.setText(Integer.toString(enrollmentYear));
		
		if(status == StatusEnum.B) {
			
			finansiranjeCmb.setSelectedIndex(1);
		}
		finansiranjeCmb.setSelectedIndex(0);
		if(studyYear==1)godinaCmb.setSelectedIndex(0);
		if(studyYear==2)godinaCmb.setSelectedIndex(1);
		if(studyYear==3)godinaCmb.setSelectedIndex(2);
		if(studyYear==4)godinaCmb.setSelectedIndex(3);
		
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(imeTxt.getText().isEmpty() || prezimeTxt.getText().isEmpty() || datumTxt.getText().isEmpty() || 
					    ulicaTxt.getText().isEmpty() || brojTxt.getText().isEmpty() || gradTxt.getText().isEmpty() ||
					    drzavaTxt.getText().isEmpty() ||telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
						indexTxt.getText().isEmpty() || upisTxt.getText().isEmpty() || godinaCmb.getSelectedItem() == null || 
						finansiranjeCmb.getSelectedItem() == null) {
							JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
						        JOptionPane.WARNING_MESSAGE);
							return;
					} else {
						Student s = new Student();
						s.setName(imeTxt.getText());
						s.setSurname(prezimeTxt.getText());
						String datum = datumTxt.getText(); 
						Date date;
						try {
							date = new SimpleDateFormat("dd.MM.yyyy").parse(datum);
							s.setBirthDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						String ulica = ulicaTxt.getText();
						int broj = Integer.parseInt(brojTxt.getText());
						String grad = gradTxt.getText();
						String drzava = drzavaTxt.getText();
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
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda izmene", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	StudentKontroler.getInstance().izmeniStudenta(s);
                    	dispose();
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
		add(ulicaLbl);
		add(ulicaTxt);
		add(brojLbl);
		add(brojTxt);
		add(gradLbl);
		add(gradTxt);
		add(drzavaLbl);
		add(drzavaTxt);
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
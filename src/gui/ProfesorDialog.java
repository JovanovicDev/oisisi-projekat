package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controllers.ProfesorKontroler;
import model.Adresa;
import model.Profesor;


public class ProfesorDialog extends JDialog {

	
	private static final long serialVersionUID = 3346592901014711454L;

	public ProfesorDialog() {
		super();
		setModal(true);
		setTitle("Dodavanje profesora");
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
				if(imeTxt.getText().matches("[A-Z][a-z]*") || imeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
				} else {
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
				} else {
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
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Datum sadrzi iskljucivo brojeve i tacke.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					datumTxt.setText(datumTxt.getText().replaceAll("[^0-9.]", "").substring(0,datumTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(telefonTxt.getText().matches("0[0-9]{0,9}")|| telefonTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);

				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj pocinje sa 0 i ima 10 cifara.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					
					telefonTxt.setText(telefonTxt.getText().replaceAll("[^0-9]", "").substring(0, telefonTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
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
				if(emailTxt.getText().matches("[a-z0-9.@]*")|| emailTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Email sadrzi iskljucivo mala slova, brojeve, tacku i @.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					emailTxt.setText(emailTxt.getText().replaceAll("[^a-z0-9.@]", "").substring(0,emailTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel adresaKancLbl = new JLabel("Adresa kancelarije*");
		JTextField adresaKancTxt = new JTextField();
		adresaKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, adresaKancLbl, 270, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaKancLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, adresaKancTxt, 160, SpringLayout.WEST, adresaKancLbl);
		layout.putConstraint(SpringLayout.NORTH, adresaKancTxt, -5, SpringLayout.NORTH, adresaKancLbl);
		adresaKancTxt.addKeyListener(new KeyListener() {
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
	
			}
			
		});
		
		JLabel brIDLbl = new JLabel("Broj licne karte*");
		JTextField brIDTxt = new JTextField();
		brIDTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brIDLbl, 310, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brIDLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, brIDTxt, 160, SpringLayout.WEST, brIDLbl);
		layout.putConstraint(SpringLayout.NORTH, brIDTxt, -5, SpringLayout.NORTH, brIDLbl);
		brIDTxt.addKeyListener(new KeyListener() {
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
				if(brIDTxt.getText().matches("[0-9]{0,9}") || brIDTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godina upisa je cetvorocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brIDTxt.setText(brIDTxt.getText().replaceAll("[^0-9]", "").substring(0, brIDTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel zvanjeLBL = new JLabel("Zvanje*");
		JTextField zvanjeTxt = new JTextField();
		zvanjeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, zvanjeLBL, 350, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, zvanjeLBL, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, zvanjeTxt, 160, SpringLayout.WEST, zvanjeLBL);
		layout.putConstraint(SpringLayout.NORTH, zvanjeTxt, -5, SpringLayout.NORTH, zvanjeLBL);
		
		zvanjeTxt.addKeyListener(new KeyListener() {
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
				if(zvanjeTxt.getText().matches("[A-Za-z]*")|| zvanjeTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Zvanje sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					zvanjeTxt.setText(zvanjeTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,zvanjeTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		
		
		JLabel godineLbl = new JLabel("Godine staza*");
		JTextField godineTxt = new JTextField();
		godineTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, godineLbl, 390, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godineLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, godineTxt, 160, SpringLayout.WEST, godineLbl);
		layout.putConstraint(SpringLayout.NORTH, godineTxt, -5, SpringLayout.NORTH, godineLbl);
		godineTxt.addKeyListener(new KeyListener() {
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
				if(godineTxt.getText().matches("[0-9]{0,2}")|| godineTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godine staza mogu biti maksimalno dvocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					godineTxt.setText(godineTxt.getText().replaceAll("[^0-9]{0,2}", "").substring(0,godineTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		
		potvrdiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(imeTxt.getText().isEmpty() || prezimeTxt.getText().isEmpty() || datumTxt.getText().isEmpty() || 
					adresaTxt.getText().isEmpty() || telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
					adresaKancTxt.getText().isEmpty() || brIDTxt.getText().isEmpty() || zvanjeTxt.getText().isEmpty() || godineTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Profesor p = new Profesor();
					p.setName(imeTxt.getText());
					p.setSurname(prezimeTxt.getText());
					//String datum = datumTxt.getText(); 
					//Date date;
					/*try {
						date = new SimpleDateFormat("dd/MM/yyyy").parse(datum);
						s.setBirthDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  */
					p.setBirthDate(new Date());
					String adresa = adresaTxt.getText();
					String[] ulicaGradDrzava = adresa.split(",");
					String ulicaIBroj = ulicaGradDrzava[0];
					String[] ulicaBroj = ulicaIBroj.split(" ");
					String ulica = ulicaBroj[0];
					int broj = Integer.parseInt(ulicaBroj[1]);
					String grad = ulicaGradDrzava[1];
					String drzava = ulicaGradDrzava[2];
					Adresa a = new Adresa(ulica,broj,grad,drzava);
					p.setAdress(a);
					p.setPhone(telefonTxt.getText());
					p.setEmail(emailTxt.getText());
					
					String adresaProf = adresaKancTxt.getText();
					String[] ulicaGradDrzavaProf = adresaProf.split(",");
					String ulicaIBrojProf = ulicaGradDrzavaProf[0];
					String[] ulicaBrojProf = ulicaIBrojProf.split(" ");
					String ulicaProf = ulicaBrojProf[0];
					int brojProf = Integer.parseInt(ulicaBrojProf[1]);
					String gradProf = ulicaGradDrzavaProf[1];
					String drzavaProf = ulicaGradDrzavaProf[2];
					Adresa a1 = new Adresa(ulicaProf,brojProf,gradProf,drzavaProf);
					p.setOfficeAdress(a1);
					
					p.setNumberID(brIDTxt.getText());
					p.setTitle(zvanjeTxt.getText());
					p.setYearsOfService(Integer.parseInt(godineTxt.getText()));
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda odustanka", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	
                    	ProfesorKontroler.getInstance().DodajProfesora(p);
                    	dispose();
                    	
                    } else {
                    	return;
                    }
				}
			}
		});
		
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 430, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 70, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 160, SpringLayout.WEST, potvrdiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, potvrdiBtn);
		
		
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
		add(adresaKancLbl);
		add(adresaKancTxt);
		add(brIDLbl);
		add(brIDTxt);
		add(zvanjeLBL);
		add(zvanjeTxt);
		add(godineLbl);
		add(godineTxt);
		add(potvrdiBtn);
		add(odustaniBtn);
	
		
		setVisible(true);
}}

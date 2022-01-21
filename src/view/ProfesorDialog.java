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
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import controller.ProfesorKontroler;
import model.Adresa;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class ProfesorDialog extends JDialog {

	private static final long serialVersionUID = 3346592901014711454L;
	public static JTabbedPane tabovi;
	public static JPanel panel1;
	public static JPanel panel2;
	public static JTable predavaniPredmetiTable;
	int ind = -1;
	
	public ProfesorDialog() {
		super();
		setModal(true);
		setTitle("Dodavanje profesora");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 850);
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
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve", "Warning",
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
				if(telefonTxt.getText().matches("0[0-9]{0,9}")|| telefonTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					telefonTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					telefonTxt.setBorder(new LineBorder(Color.RED,2));
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
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel adresaKancLbl = new JLabel("Adresa kancelarije:");
		layout.putConstraint(SpringLayout.NORTH, adresaKancLbl, 430, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaKancLbl, 20, SpringLayout.WEST, this);	
		
		JLabel ulicaKancLbl = new JLabel("Ulica*");
		JTextField ulicaKancTxt = new JTextField();
		ulicaKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, ulicaKancLbl, 470, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ulicaKancLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, ulicaKancTxt, 140, SpringLayout.WEST, ulicaKancLbl);
		layout.putConstraint(SpringLayout.NORTH, ulicaKancTxt, -5, SpringLayout.NORTH, ulicaKancLbl);
		ulicaKancTxt.addKeyListener(new KeyListener() {
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
				if(ulicaKancTxt.getText().matches("[A-Z][a-z]*")|| ulicaKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					ulicaKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					ulicaKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ulica sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					ulicaKancTxt.setText(ulicaKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,ulicaKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel brojKancLbl = new JLabel("Broj*");
		JTextField brojKancTxt = new JTextField();
		brojKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brojKancLbl, 510, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brojKancLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, brojKancTxt, 140, SpringLayout.WEST, brojKancLbl);
		layout.putConstraint(SpringLayout.NORTH, brojKancTxt, -5, SpringLayout.NORTH, brojKancLbl);
		brojKancTxt.addKeyListener(new KeyListener() {
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
				if(brojKancTxt.getText().matches("[0-9]*[a-z]?")|| brojKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					brojKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brojKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve i mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brojKancTxt.setText(brojKancTxt.getText().replaceAll("[^0-9a-z]", "").substring(0,brojKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel gradKancLbl = new JLabel("Grad*");
		JTextField gradKancTxt = new JTextField();
		gradKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, gradKancLbl, 550, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, gradKancLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, gradKancTxt, 140, SpringLayout.WEST, gradKancLbl);
		layout.putConstraint(SpringLayout.NORTH, gradKancTxt, -5, SpringLayout.NORTH, gradKancLbl);
		gradKancTxt.addKeyListener(new KeyListener() {
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
				if(gradKancTxt.getText().matches("[A-Z][a-z]*")|| gradKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					gradKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					gradKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Grad sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					gradKancTxt.setText(gradKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,gradKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel drzavaKancLbl = new JLabel("Drzava*");
		JTextField drzavaKancTxt = new JTextField();
		drzavaKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, drzavaKancLbl, 590, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, drzavaKancLbl, 60, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, drzavaKancTxt, 140, SpringLayout.WEST, drzavaKancLbl);
		layout.putConstraint(SpringLayout.NORTH, drzavaKancTxt, -5, SpringLayout.NORTH, drzavaKancLbl);
		drzavaKancTxt.addKeyListener(new KeyListener() {
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
				if(drzavaKancTxt.getText().matches("[A-Z][a-z]*")|| drzavaKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					drzavaKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					drzavaKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Drzava sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					drzavaKancTxt.setText(drzavaKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,drzavaKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});	
		
		JLabel brIDLbl = new JLabel("Broj licne karte*");
		JTextField brIDTxt = new JTextField();
		brIDTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brIDLbl, 630, SpringLayout.NORTH, this);
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
					brIDTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brIDTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj licne karte je devetocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brIDTxt.setText(brIDTxt.getText().replaceAll("[^0-9]", "").substring(0, brIDTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel zvanjeLBL = new JLabel("Zvanje*");
		JTextField zvanjeTxt = new JTextField();
		zvanjeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, zvanjeLBL, 670, SpringLayout.NORTH, this);
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
					zvanjeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					zvanjeTxt.setBorder(new LineBorder(Color.RED,2));
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
		layout.putConstraint(SpringLayout.NORTH, godineLbl, 710, SpringLayout.NORTH, this);
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
					godineTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					godineTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godine staza mogu biti maksimalno dvocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					godineTxt.setText(godineTxt.getText().replaceAll("[^0-9]{0,2}", "").substring(0,godineTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
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
					drzavaTxt.getText().isEmpty() || telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
					ulicaKancTxt.getText().isEmpty() || brojKancTxt.getText().isEmpty() || gradKancTxt.getText().isEmpty() ||
					drzavaKancTxt.getText().isEmpty() || brIDTxt.getText().isEmpty() || zvanjeTxt.getText().isEmpty() || godineTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Profesor p = new Profesor();
					p.setName(imeTxt.getText());
					p.setSurname(prezimeTxt.getText());
					try {
						Date d = new SimpleDateFormat("dd.MM.yyyy").parse(datumTxt.getText());
						p.setBirthDate(d);	
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
					p.setAdress(a);
					p.setPhone(telefonTxt.getText());
					p.setEmail(emailTxt.getText());
					String ulicaKanc = ulicaKancTxt.getText();
					int brojKanc = Integer.parseInt(brojKancTxt.getText());
					String gradKanc = gradKancTxt.getText();
					String drzavaKanc = drzavaKancTxt.getText();
					Adresa a1 = new Adresa(ulicaKanc,brojKanc,gradKanc,drzavaKanc);
					p.setOfficeAdress(a1);
					p.setNumberID(brIDTxt.getText());
					p.setTitle(zvanjeTxt.getText());
					p.setYearsOfService(Integer.parseInt(godineTxt.getText()));
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda unosa", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	
                    	ProfesorKontroler.getInstance().DodajProfesora(p);
                    	dispose();
                    	
                    } else {
                    	return;
                    }
				}
			}
		});
				
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 750, SpringLayout.NORTH, this);
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
		add(adresaKancLbl);
		add(ulicaKancLbl);
		add(ulicaKancTxt);
		add(brojKancLbl);
		add(brojKancTxt);
		add(gradKancLbl);
		add(gradKancTxt);
		add(drzavaKancLbl);
		add(drzavaKancTxt);
		add(brIDLbl);
		add(brIDTxt);
		add(zvanjeLBL);
		add(zvanjeTxt);
		add(godineLbl);
		add(godineTxt);
		add(potvrdiBtn);
		add(odustaniBtn);
		setVisible(true);
}
	
	public ProfesorDialog(String surname, String name, Date birthDate, Adresa adress, String phone, String email,
			Adresa officeAdress, String numberID, String title, int yearsOfService) {
		
		super();
		tabovi = new JTabbedPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		tabovi.setPreferredSize(new Dimension(1050, 750));
		this.add(BorderLayout.CENTER, tabovi);
		tabovi.addTab("Info", panel1);
		
		setModal(true);
		setTitle("Izmena profesora");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		panel1.setLayout(layout);
		setSize(850, 900);
		setLocationRelativeTo(null);
		JButton potvrdiBtn = new JButton("Potvrdi");		
		JButton odustaniBtn = new JButton("Odustani");
		
		
		JLabel imeLbl = new JLabel("Ime*");
		JTextField imeTxt = new JTextField();
		imeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, imeLbl, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, imeLbl, 280, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, prezimeLbl, 280, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, datumLbl, 280, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, adresaLbl, 260, SpringLayout.WEST, this);	
		
		JLabel ulicaLbl = new JLabel("Ulica*");
		JTextField ulicaTxt = new JTextField();
		ulicaTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, ulicaLbl, 190, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ulicaLbl, 300, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, brojLbl, 300, SpringLayout.WEST, this);
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
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve", "Warning",
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
		layout.putConstraint(SpringLayout.WEST, gradLbl, 300, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, drzavaLbl, 300, SpringLayout.WEST, this);
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
		layout.putConstraint(SpringLayout.WEST, telefonLbl, 280, SpringLayout.WEST, this);
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
					telefonTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					telefonTxt.setBorder(new LineBorder(Color.RED,2));
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
		layout.putConstraint(SpringLayout.NORTH, emailLbl, 390, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, emailLbl, 280, SpringLayout.WEST, this);
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
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel adresaKancLbl = new JLabel("Adresa kancelarije:");
		layout.putConstraint(SpringLayout.NORTH, adresaKancLbl, 430, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, adresaKancLbl, 260, SpringLayout.WEST, this);	
		
		JLabel ulicaKancLbl = new JLabel("Ulica*");
		JTextField ulicaKancTxt = new JTextField();
		ulicaKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, ulicaKancLbl, 470, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ulicaKancLbl, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, ulicaKancTxt, 140, SpringLayout.WEST, ulicaKancLbl);
		layout.putConstraint(SpringLayout.NORTH, ulicaKancTxt, -5, SpringLayout.NORTH, ulicaKancLbl);
		ulicaKancTxt.addKeyListener(new KeyListener() {
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
				if(ulicaKancTxt.getText().matches("[A-Z][a-z]*")|| ulicaKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					ulicaKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					ulicaKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Ulica sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					ulicaKancTxt.setText(ulicaKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,ulicaKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel brojKancLbl = new JLabel("Broj*");
		JTextField brojKancTxt = new JTextField();
		brojKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brojKancLbl, 510, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brojKancLbl, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, brojKancTxt, 140, SpringLayout.WEST, brojKancLbl);
		layout.putConstraint(SpringLayout.NORTH, brojKancTxt, -5, SpringLayout.NORTH, brojKancLbl);
		brojKancTxt.addKeyListener(new KeyListener() {
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
				if(brojKancTxt.getText().matches("[0-9]*[a-z]?")|| brojKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					brojKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brojKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj kuce ili stana sadrzi iskljucivo brojeve i mala slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brojKancTxt.setText(brojKancTxt.getText().replaceAll("[^0-9a-z]", "").substring(0,brojKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel gradKancLbl = new JLabel("Grad*");
		JTextField gradKancTxt = new JTextField();
		gradKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, gradKancLbl, 550, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, gradKancLbl, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, gradKancTxt, 140, SpringLayout.WEST, gradKancLbl);
		layout.putConstraint(SpringLayout.NORTH, gradKancTxt, -5, SpringLayout.NORTH, gradKancLbl);
		gradKancTxt.addKeyListener(new KeyListener() {
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
				if(gradKancTxt.getText().matches("[A-Z][a-z]*")|| gradKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					gradKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					gradKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Grad sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					gradKancTxt.setText(gradKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,gradKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel drzavaKancLbl = new JLabel("Drzava*");
		JTextField drzavaKancTxt = new JTextField();
		drzavaKancTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, drzavaKancLbl, 590, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, drzavaKancLbl, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, drzavaKancTxt, 140, SpringLayout.WEST, drzavaKancLbl);
		layout.putConstraint(SpringLayout.NORTH, drzavaKancTxt, -5, SpringLayout.NORTH, drzavaKancLbl);
		drzavaKancTxt.addKeyListener(new KeyListener() {
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
				if(drzavaKancTxt.getText().matches("[A-Z][a-z]*")|| drzavaKancTxt.getText().equals("")) {
					potvrdiBtn.setEnabled(true);
					drzavaKancTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					drzavaKancTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Drzava sadrzi iskljucivo slova.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					drzavaKancTxt.setText(drzavaKancTxt.getText().replaceAll("[^a-zA-Z]", "").substring(0,drzavaKancTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});	
		
		JLabel brIDLbl = new JLabel("Broj licne karte*");
		JTextField brIDTxt = new JTextField();
		brIDTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, brIDLbl, 630, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, brIDLbl, 280, SpringLayout.WEST, this);
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
					brIDTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					brIDTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Broj licne karte je devetocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					brIDTxt.setText(brIDTxt.getText().replaceAll("[^0-9]", "").substring(0, brIDTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		JLabel zvanjeLBL = new JLabel("Zvanje*");
		JTextField zvanjeTxt = new JTextField();
		zvanjeTxt.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, zvanjeLBL, 670, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, zvanjeLBL, 280, SpringLayout.WEST, this);
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
					zvanjeTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					zvanjeTxt.setBorder(new LineBorder(Color.RED,2));
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
		layout.putConstraint(SpringLayout.NORTH, godineLbl, 710, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, godineLbl, 280, SpringLayout.WEST, this);
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
					godineTxt.setBorder(new LineBorder(new Color(122, 138, 153),1));
				} else {
					godineTxt.setBorder(new LineBorder(Color.RED,2));
					potvrdiBtn.setEnabled(false);
					JOptionPane.showMessageDialog(new JPanel(), "Godine staza mogu biti maksimalno dvocifren broj.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
					godineTxt.setText(godineTxt.getText().replaceAll("[^0-9]{0,2}", "").substring(0,godineTxt.getText().length()-1));
					potvrdiBtn.setEnabled(true);
				}
			}
			
		});
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 750, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 310, SpringLayout.WEST, this);
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
		ulicaKancTxt.setText(officeAdress.getStreet());
		brojKancTxt.setText(Integer.toString(officeAdress.getNumber()));
		gradKancTxt.setText(officeAdress.getCity());
		drzavaKancTxt.setText(officeAdress.getCountry());
		brIDTxt.setText(numberID);
		zvanjeTxt.setText(title);
		godineTxt.setText(Integer.toString(yearsOfService));
		
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
						drzavaTxt.getText().isEmpty() || telefonTxt.getText().isEmpty() || emailTxt.getText().isEmpty() ||
						ulicaKancTxt.getText().isEmpty() || brojKancTxt.getText().isEmpty() || gradKancTxt.getText().isEmpty() ||
						drzavaKancTxt.getText().isEmpty() || brIDTxt.getText().isEmpty() || zvanjeTxt.getText().isEmpty() || godineTxt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JPanel(), "Sva polja moraju biti popunjena.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
						return;
				} else {
					Profesor p = new Profesor();
					p.setName(imeTxt.getText());
					p.setSurname(prezimeTxt.getText());
					String datum = datumTxt.getText(); 
					Date date;
					try {
						date = new SimpleDateFormat("dd.MM.yyyy").parse(datum);
						p.setBirthDate(date);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					String ulica = ulicaTxt.getText();
					int broj = Integer.parseInt(brojTxt.getText());
					String grad = gradTxt.getText();
					String drzava = drzavaTxt.getText();
					Adresa a = new Adresa(ulica,broj,grad,drzava);
					p.setAdress(a);
					p.setPhone(telefonTxt.getText());
					p.setEmail(emailTxt.getText());
					String ulicaKanc = ulicaKancTxt.getText();
					int brojKanc = Integer.parseInt(brojKancTxt.getText());
					String gradKanc = gradKancTxt.getText();
					String drzavaKanc = drzavaKancTxt.getText();
					Adresa a1 = new Adresa(ulicaKanc,brojKanc,gradKanc,drzavaKanc);
					p.setOfficeAdress(a1);
					p.setNumberID(brIDTxt.getText());
					p.setTitle(zvanjeTxt.getText());
					p.setYearsOfService(Integer.parseInt(godineTxt.getText()));
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda izmene", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	
                    	ProfesorKontroler.getInstance().izmeniProfesora(p);
                    	dispose();
                    	
                    } else {
                    	return;
                    }
				}
			}
		});

		panel1.add(imeLbl);
		panel1.add(imeTxt);
		panel1.add(prezimeLbl);
		panel1.add(prezimeTxt);
		panel1.add(datumLbl);
		panel1.add(datumTxt);
		panel1.add(adresaLbl);
		panel1.add(ulicaLbl);
		panel1.add(ulicaTxt);
		panel1.add(brojLbl);
		panel1.add(brojTxt);
		panel1.add(gradLbl);
		panel1.add(gradTxt);
		panel1.add(drzavaLbl);
		panel1.add(drzavaTxt);
		panel1.add(telefonLbl);
		panel1.add(telefonTxt);
		panel1.add(emailLbl);
		panel1.add(emailTxt);
		panel1.add(adresaKancLbl);
		panel1.add(ulicaKancLbl);
		panel1.add(ulicaKancTxt);
		panel1.add(brojKancLbl);
		panel1.add(brojKancTxt);
		panel1.add(gradKancLbl);
		panel1.add(gradKancTxt);
		panel1.add(drzavaKancLbl);
		panel1.add(drzavaKancTxt);
		panel1.add(brIDLbl);
		panel1.add(brIDTxt);
		panel1.add(zvanjeLBL);
		panel1.add(zvanjeTxt);
		panel1.add(godineLbl);
		panel1.add(godineTxt);
		panel1.add(potvrdiBtn);
		panel1.add(odustaniBtn);
		
		tabovi.addTab("Predmeti", panel2);
		panel2.setLayout(layout);
		panel2.setPreferredSize(new Dimension(1050, 750));
		
		JButton dodajBtn = new JButton("Dodaj predmet");
		layout.putConstraint(SpringLayout.NORTH, dodajBtn, 120, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dodajBtn, 70, SpringLayout.WEST, this);
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor p = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
				DodavanjePredmetaProfesoruDialog d = new DodavanjePredmetaProfesoruDialog(p);
			}
		});
		panel2.add(dodajBtn);
		
		JButton ukloniBtn = new JButton("Ukloni predmet");
		ukloniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
				ind = PredavaniPredmetiJTable.rowSelectedIndex;
				if(ind == -1) JOptionPane.showMessageDialog(new JPanel(), "Nesto iz liste mora biti odabrano.", "Warning",
				        JOptionPane.WARNING_MESSAGE);
				else {
					int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda uklanjanja", dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION) {
                    	Profesor p = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
                    	Predmet pred = AbstractTableModelPredavaniPredmeti.bp.getRow(PredavaniPredmetiJTable.rowSelectedIndex);
    					AbstractTableModelPredavaniPredmeti.bprof.skiniPredmeProfesoru(p, pred);
                    }
				}
			}

		});
		layout.putConstraint(SpringLayout.NORTH, ukloniBtn, 120, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ukloniBtn, 240, SpringLayout.WEST, this);
		panel2.add(ukloniBtn);
		
		predavaniPredmetiTable = new PredavaniPredmetiJTable();
		TableColumn column = predavaniPredmetiTable.getColumn("BROJ ESPB BODOVA");
		predavaniPredmetiTable.removeColumn(column);
		JScrollPane predavaniPredmetiPane = new JScrollPane(predavaniPredmetiTable);
		predavaniPredmetiPane.setPreferredSize(new Dimension(700,300));
		predavaniPredmetiTable.setFillsViewportHeight(true);
		layout.putConstraint(SpringLayout.NORTH, predavaniPredmetiPane, 240, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, predavaniPredmetiPane, 70, SpringLayout.WEST, this);
		panel2.add(predavaniPredmetiPane);
		
		setVisible(true);
		
	}
}

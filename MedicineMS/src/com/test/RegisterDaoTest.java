package com.test;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.dao.RegisterDao;

public class RegisterDaoTest {

	@Test
	public void findall(){
		JOptionPane.showMessageDialog(null, (RegisterDao.findAll().get(0)).toString()); 
	}
	
}

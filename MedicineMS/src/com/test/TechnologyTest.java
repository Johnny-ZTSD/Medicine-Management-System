package com.test;

import java.util.UUID;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.entity.ViewObject.MsgObj_FeedBack;

public class TechnologyTest {
	
	public void test1(){
		JOptionPane.showMessageDialog(null, JSON.toJSONString(new MsgObj_FeedBack("OK","温馨提示：更新成功！")));
		
	}
	
	@Test
	public void test2(){
		JOptionPane.showMessageDialog(null, UUID.randomUUID().toString().replaceAll("-", ""));
	}
	
}

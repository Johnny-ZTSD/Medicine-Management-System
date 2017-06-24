package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.dao.MedicineStorageDao;
import com.entity.MedicineStorage;

public class MStorageService {

	// ��ѯҩƷ���
	//query     queryType    
	//  O           X		����queryȫ���ֶ�ģ����ѯ���
	//  O 			O		���query��Ϊ��,�Ҳ�ѯ���Ͳ�Ϊ�գ�����query��ָ�����ֶ�ģ����ѯ���
	//  X           X       ��ѯȫ�� 
	public static boolean search_MSaleStorage(HttpServletRequest request, HttpServletResponse response, String query[],
			Object queryType[]) throws IOException {
		StringBuffer sql = new StringBuffer("select msto_id_PK as id,msto_cmpn_FK as cmpn,msto_name as name,msto_batchNum as batchNum,msto_manufcName as manufcName,msto_recomdPrice as recomdPrice,msto_productTele as productTele,msto_productFax as productFax,msto_productAddr as productAddr,msto_elecMonitCode as elecMonitCode,msto_productDate as productDate,msto_expireDate as expireDate,msto_sotorageNum as sotorageNum from MedicineStorage ");
		
		Object params[] = {};
		// �ж�query�Ƿ�Ϊ�գ�
		// ���query��Ϊ��,�Ҳ�ѯ����Ϊ�գ�����queryȫ���ֶ�ģ����ѯ���
		// ��ʾ��queryӦ���ǵ����� 
		if (query != null && queryType == null) {
			sql.append("where concat(msto_id_PK,");
			sql.append("msto_cmpn_FK,");
			sql.append("msto_name,");
			sql.append("msto_batchNum,");
			sql.append("msto_manufcName,");
			sql.append("msto_recomdPrice,");
			sql.append("msto_productTele,");
			sql.append("msto_productFax,");
			sql.append("msto_elecMonitCode,");
			sql.append("msto_productDate,");
			sql.append("msto_expireDate,");
			sql.append("msto_sotorageNum) like '%"+query[0]+"%';");
			//ע�⣺�����಻�����ִ���ģ����ѯ���˴����������ֶ�ƴ�ӳ�һ���ִ�������ģʽƥ���жϵ�---�ȷ�ÿһ���ֶν���ģ����ѯ��Ч��Ҫ�ߺܶࡿ
//			sql.delete(sql.length() - 4, sql.length());// ȥ�����һ�� ' or
			
		} else if (query != null && queryType != null) {// ���query��Ϊ��,�Ҳ�ѯ���Ͳ�Ϊ�գ�����query��ָ�����ֶ�ģ����ѯ���
			// ��ʾ��query�����ǵ�������Ҳ�����Ƕ�����
			// ע�⣺Сǰ�᣺query��queryType�ĳ��ȱ��뱣��һ�£�
			sql.append("where ");
			for (int i = 0; i < queryType.length; i++) {
				sql.append(queryType);
				sql.append(" like '%");
				sql.append(query[i]);
				sql.append("%' or ");
			}
			sql.delete(sql.length() - 4, sql.length());// ȥ�����һ�� ' or
		} else {//��ѯȫ�����
			//�����κδ���
		}
		
//		JOptionPane.showMessageDialog(null, sql);//test
//		System.out.println(sql);
		// ��֮�����Ϊ�գ���ѯȫ�����
		List<MedicineStorage> list =  MedicineStorageDao.findByCondition(sql.toString(), params);
		
		//װ�ؿ����Ϣ��request��
		request.setAttribute("MedicineStorage_List", list);
		//ת��
		try {
			request.getRequestDispatcher("/MedicineMS/medicine/MStorage/search/search_MSaleStorage.jsp").forward(request, response);
//			JOptionPane.showMessageDialog(null, "�Ѿ�ת��....");//test

			return true;
		} catch (ServletException | IOException e) {
			response.sendRedirect(request.getContextPath());
//			JOptionPane.showMessageDialog(null, "ת��ʧ��....[ת��¼��ʼ����]");//test
			e.printStackTrace();
		}
		return false;
	}
	
	
}

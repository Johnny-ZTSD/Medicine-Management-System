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

	// 查询药品库存
	//query     queryType    
	//  O           X		按照query全部字段模糊查询库存
	//  O 			O		如果query不为空,且查询类型不为空：按照query和指定的字段模糊查询库存
	//  X           X       查询全部 
	public static boolean search_MSaleStorage(HttpServletRequest request, HttpServletResponse response, String query[],
			Object queryType[]) throws IOException {
		StringBuffer sql = new StringBuffer("select msto_id_PK as id,msto_cmpn_FK as cmpn,msto_name as name,msto_batchNum as batchNum,msto_manufcName as manufcName,msto_recomdPrice as recomdPrice,msto_productTele as productTele,msto_productFax as productFax,msto_productAddr as productAddr,msto_elecMonitCode as elecMonitCode,msto_productDate as productDate,msto_expireDate as expireDate,msto_sotorageNum as sotorageNum from MedicineStorage ");
		
		Object params[] = {};
		// 判断query是否为空：
		// 如果query不为空,且查询类型为空：按照query全部字段模糊查询库存
		// 提示：query应该是单条件 
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
			//注意：日期类不能作字串的模糊查询【此处：将所有字段拼接成一个字串，进行模式匹配判断的---比分每一个字段进行模糊查询的效率要高很多】
//			sql.delete(sql.length() - 4, sql.length());// 去掉最后一个 ' or
			
		} else if (query != null && queryType != null) {// 如果query不为空,且查询类型不为空：按照query和指定的字段模糊查询库存
			// 提示：query可能是单条件，也可能是多条件
			// 注意：小前提：query与queryType的长度必须保持一致！
			sql.append("where ");
			for (int i = 0; i < queryType.length; i++) {
				sql.append(queryType);
				sql.append(" like '%");
				sql.append(query[i]);
				sql.append("%' or ");
			}
			sql.delete(sql.length() - 4, sql.length());// 去掉最后一个 ' or
		} else {//查询全部库存
			//不做任何处理
		}
		
//		JOptionPane.showMessageDialog(null, sql);//test
//		System.out.println(sql);
		// 反之：如果为空：查询全部库存
		List<MedicineStorage> list =  MedicineStorageDao.findByCondition(sql.toString(), params);
		
		//装载库存信息到request中
		request.setAttribute("MedicineStorage_List", list);
		//转发
		try {
			request.getRequestDispatcher("/MedicineMS/medicine/MStorage/search/search_MSaleStorage.jsp").forward(request, response);
//			JOptionPane.showMessageDialog(null, "已经转发....");//test

			return true;
		} catch (ServletException | IOException e) {
			response.sendRedirect(request.getContextPath());
//			JOptionPane.showMessageDialog(null, "转发失败....[转登录初始界面]");//test
			e.printStackTrace();
		}
		return false;
	}
	
	
}

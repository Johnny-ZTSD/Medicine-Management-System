package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.MedicineDao;
import com.entity.Medicine;
import com.entity.Staff;
 
/* *
 * 错误代码：
 * 	04X:search_MedicineInfo
 *  05X:deleteMedicineInfo
 *  08X:updateMedicineInfo[include:add+modify]
 * */
public class MedicineService {
	
	public static boolean search_MedicineInfo(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		try{
			String cmpk = new String(request.getParameter("cmpk").getBytes("ISO-8859-1"),"UTF-8");
			String medicineName = new String(request.getParameter("medicineName").getBytes("ISO-8859-1"),"UTF-8");
			String mainFunc = new String(request.getParameter("mainFunc").getBytes("ISO-8859-1"),"UTF-8");
			
			int isPrescription_Flag = Integer.parseInt(request.getParameter("isPrescription"));
//			JOptionPane.showMessageDialog(null, cmpk+" | "+medicineName+ " | "+" | "+mainFunc+" | "+isPrescription_Flag);
			
			try{
				List<Medicine> list  = new ArrayList<Medicine>();
				StringBuffer sql = new StringBuffer("select mdcn_cmpn_PK as cmpk,mdcn_name as name,mdcn_isPrescription as prescription,mdcn_component as component ,mdcn_property as property,mdcn_useType as useType,mdcn_mainFun as mainFun,mdcn_standard as standard,mdcn_usage as usageX,mdcn_forbid as forbid,mdcn_badEffect as badEffect,mdcn_attention as attention,mdcn_wrap as wrap,mdcn_storageWay as storageWay from Medicine ");
				//分用户的查询输入情况作数据库分类查询
				if(cmpk.length()<1 && medicineName.length()<1 && mainFunc.length()<1 && isPrescription_Flag==-1){//无任何条件时：全部查询
//					JOptionPane.showMessageDialog(null, "无条件查询");
					Object params[] = {}; 
					list =  MedicineDao.findByConditions(sql.toString(), params);
				
				}else{//按照搜索条件查询
//					JOptionPane.showMessageDialog(null, "有条件查询");
//					int flag[] = {0,0,0,0,0};//标记前面是否有设置字段
					boolean FX = false;//前面是否设置字段
//					List<Object> paramsList = new ArrayList<Object>();
					sql.append(" where ");
					
					if(cmpk.length()>0){
						sql.append(" (mdcn_cmpn_PK like '%");
						sql.append(cmpk);
						sql.append("%')");
//						paramsList.add(cmpk);
//						flag[1] = 1;//标志位
						FX = true; 
					}
					if(medicineName.length()>0){
						if(FX)
							sql.append(" and ");
						sql.append(" (mdcn_name like '%");
						sql.append(medicineName);
						sql.append("%')");
//						paramsList.add(medicineName);
//						flag[2] = 1;
						FX = true;
					}
					if(mainFunc.length()>0){
						if(FX)
							sql.append(" and ");
						sql.append(" (mdcn_mainFun like '%");
						sql.append(mainFunc);
						sql.append("%')");
//						paramsList.add(mainFunc);
//						flag[3] = 1;
						FX = true;
					}
					if(isPrescription_Flag==0||isPrescription_Flag==1){
						if(FX)
							sql.append(" and ");
						sql.append(" (mdcn_isPrescription = ");
						sql.append(isPrescription_Flag+")");
//						paramsList.add((isPrescription_Flag==0?false:true));
						FX = true;
					}
					
					list = MedicineDao.findByConditions(sql.toString(),new Object[]{});
				}
//				JOptionPane.showMessageDialog(null, sql.toString());
//				JOptionPane.showMessageDialog(null, "准备转发...");
//				JOptionPane.showMessageDialog(null,"数目："+list.size()+"|\n"+ list.get(0).toString());
				//装载信息
				request.setAttribute("MedicineInfo_List", list);
				//转发
				request.getRequestDispatcher("/MedicineMS/medicine/MInfo/Info/searchIndex_medicineInfo.jsp").forward(request, response);
//				JOptionPane.showMessageDialog(null, "转发成功...");
				
			}catch (Exception e) {
				System.out.println("**********[MedicineService:search_MedicineInfo] [错误代码：401：数据库执行[查询药品信息]异常]**********");
				e.printStackTrace();
			}
			
		}catch (Exception e) {
			System.out.println("**********[MedicineService:search_MedicineInfo] [错误代码：402：表单参数获取异常]**********");
			e.printStackTrace();
		}
		
		return false;
	} 
	
	public  static boolean updateMedicineInfoAction(HttpServletRequest request,HttpServletResponse response){
		
		return false;
	}
	
	public static boolean deleteMedicineInfo(HttpServletRequest request,HttpServletResponse response){
		
		String cmpk = request.getParameter("pk").replace(" ","");//替换空格
		
		//检查用户是否登陆
		
		Staff staff = null;
		try{
			staff = (Staff)request.getSession().getAttribute("staff");
//			JOptionPane.showMessageDialog(null, staff.toString()); //test
		}catch(Exception e){//如果获取失败：说明不存在该用户
			System.out.println("**********[MedicineService:deleteMedicineInfo [错误代码：051]获取用户信息失败【可能存在用户没有登陆】]**********");
			e.printStackTrace();
			return false;
		}
		if(cmpk.length()<5||cmpk.length()>10){
			return false;
		}else{
			boolean flag;//是否删除成功
			try {
				flag = MedicineDao.delete(cmpk);
				if(flag){//如果删除成功
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return flag;
		}
	}
	
	public static boolean updateMedicineInfoService(HttpServletRequest request,HttpServletResponse response) throws IOException{
		boolean flag = false; //判断是否更新成功
		
//		JOptionPane.showMessageDialog(null,new String(request.getParameter("update_medicineName").getBytes("ISO-8859-1"),"UTF-8"));
		
		//获取药品信息
		try {
			String cmpk = new String(request.getParameter("update_cmpk").getBytes("ISO-8859-1"),"UTF-8");
			String medicineName = new String(request.getParameter("update_medicineName").getBytes("ISO-8859-1"),"UTF-8");
			int prescription =  Integer.parseInt(request.getParameter("update_prescription"));
			String component =  new String(request.getParameter("update_component").getBytes("ISO-8859-1"),"UTF-8");
			String perproty =  new String(request.getParameter("update_perproty").getBytes("ISO-8859-1"),"UTF-8");
			String useType =  new String(request.getParameter("update_useType").getBytes("ISO-8859-1"),"UTF-8");
			String mainFunc =  new String(request.getParameter("update_mainFunc").getBytes("ISO-8859-1"),"UTF-8");
			String standard =  new String(request.getParameter("update_standard").getBytes("ISO-8859-1"),"UTF-8");
			String usage =  new String(request.getParameter("update_usage").getBytes("ISO-8859-1"),"UTF-8");
			String wrap =  new String(request.getParameter("update_wrap").getBytes("ISO-8859-1"),"UTF-8");
			String storageWay =  new String(request.getParameter("update_storageWay").getBytes("ISO-8859-1"),"UTF-8");
			String forbid =  new String(request.getParameter("update_forbid").getBytes("ISO-8859-1"),"UTF-8");
			String badEffect =  new String(request.getParameter("update_badEffect").getBytes("ISO-8859-1"),"UTF-8");
			String attention =  new String(request.getParameter("update_attention").getBytes("ISO-8859-1"),"UTF-8");
			
			//获取更新方式
			String update_Type =  new String(request.getParameter("update_Type").getBytes("ISO-8859-1"),"UTF-8");
	
			try {
				if(update_Type.equalsIgnoreCase("UPDATE")){//更新操作
					String sql_update = "update medicine set mdcn_name = ?,mdcn_isPrescription = ?,mdcn_component = ?,mdcn_property = ?,mdcn_useType = ?,mdcn_mainFun = ?,mdcn_standard = ?,mdcn_usage = ?,mdcn_forbid = ?,mdcn_badEffect = ?,mdcn_attention = ?,mdcn_wrap = ?,mdcn_storageWay =? where mdcn_cmpn_PK = ?";
					Object params_update[] = {medicineName,prescription,component,perproty,useType,mainFunc,standard,usage,forbid,badEffect,attention,wrap,storageWay,cmpk};
					flag = MedicineDao.update(sql_update, params_update)>0?true:false;
					
				}else if(update_Type.equalsIgnoreCase("INSERT")){//添加操作
					String sql_insert  = "insert into medicine values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
					Object params_insert[] = {cmpk,medicineName,prescription,component,perproty,useType,mainFunc,standard,usage,forbid,badEffect,attention,wrap,storageWay};
					flag = MedicineDao.update(sql_insert, params_insert)>0?true:false;
				}
				
				
			} catch (SQLException e) {
				System.out.println("**********[MedicineService:updateMedicineInfoService][错误代码：081 数据库执行更新操作失败！]**********");
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("**********[MedicineService:updateMedicineInfoService][错误代码：082 药品各参数获取失败！]**********");
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
}

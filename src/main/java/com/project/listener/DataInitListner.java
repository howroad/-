package com.project.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.project.pojo.TData;
import com.project.pojo.TPower;
import com.project.pojo.TRole;
import com.project.service.IDataService;
import com.project.service.IRoleService;

/**
 * Application Lifecycle Listener implementation class DataInitListner
 *
 */
@WebListener
public class DataInitListner implements ServletContextListener {
	@Autowired
	private IDataService dataService;
	@Autowired
	private IRoleService roleService;


	/**
	 * Default constructor.
	 */
	public DataInitListner() {
		System.out.println("初始化监听器");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁监听器");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("运行初始化数据...");
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		this.dataService = (IDataService) applicationContext.getBean("dataService");
		this.roleService = (IRoleService) applicationContext.getBean("roleService");
		setData(arg0.getServletContext(),dataService,roleService);
	}

	public static void setData(ServletContext context,IDataService dataService,IRoleService roleService) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<String> dataTypeList = dataService.getAllType();
		//添加所有的数据信息
		for (String string : dataTypeList) {
			List<TData> dataList = dataService.findData(string);
			Map<String, String> tempMap = new HashMap<String, String>();
			for (TData tData : dataList) {
				tempMap.put(tData.getDataKey(), tData.getDataValue());
			}
			dataMap.put(string, tempMap);
		}
		context.setAttribute("dataMap", dataMap);
		//添加所有的角色信息
		List<TRole> roleList = roleService.findAllRole();
		Map<String,String> roleMap = new HashMap<String,String>();
		for (TRole tRole : roleList) {
			roleMap.put(tRole.getRoleId(), tRole.getRoleName());
		}
		context.setAttribute("roleMap", roleMap);
		//添加所有的权限
		List<TPower> powerList = roleService.findAllPower();
		Map<String,String> powerMap = new HashMap<String,String>();
		for (TPower tPower : powerList) {
			powerMap.put(tPower.getPowerId(), tPower.getPowerName());
		}
		context.setAttribute("powerMap", powerMap);
	}
}

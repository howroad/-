/**
 * 
 */
package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.IDataDao;
import com.project.dao.IOrganizationDao;
import com.project.dao.IRoleDao;
import com.project.dao.IUserDao;
import com.project.dao.IUserRoleDao;
import com.project.pojo.TOrganization;
import com.project.pojo.TRole;
import com.project.pojo.TUser;
import com.project.pojo.TUserRole;
import com.project.service.IOrganizationService;
import com.project.util.ExcelExportUtil;
import com.project.util.PageBean;
import com.project.vo.OrgStateDto;
import com.project.vo.OrgStateVO;
import com.project.vo.OrganizationVO;

/**
 * @author cyr
 * @Date 2018年5月14日
 * @version 1.0
 */
@Repository("organizationService")
public class OrganizationServiceImpl implements IOrganizationService {
	@Autowired
	private IOrganizationDao organizationDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IDataDao dataDao;
	@Autowired
	private IUserRoleDao userRoleDao;
	@Autowired
	private IRoleDao roleDao;

	@Override
	public PageBean<OrganizationVO> pageBean(int pageNo, int pageSize, String orgTypeKey, String AreaKey) {
		PageBean<TOrganization> pg0 = organizationDao.pageBean(pageNo, pageSize, orgTypeKey, AreaKey);
		List<TOrganization> list1 = pg0.getList();
		List<OrganizationVO> list2 = new ArrayList<OrganizationVO>();
		for (TOrganization tOrganization : list1) {
			OrganizationVO v = new OrganizationVO(tOrganization);
			TUser u = userDao.findManagerByOrg(v.getOrgId());
			if(u!=null) {
				v.setUserName(u.getUserName());
				v.setOrgUserTel(u.getUserTel());
				v.setOrgUserName(u.getUserRname());
				v.setUserPwd(u.getUserPassword());
			}
			v.setAreaKey(dataDao.getValue("QY", v.getAreaKey()));
			v.setOrgTypeKey(dataDao.getValue("JGLX", v.getOrgTypeKey()));
			list2.add(v);
		}
		return new PageBean<OrganizationVO>(list2,pageNo,pageSize,pg0.getTotalRecord());
	}

	@Override
	public boolean addOrg(OrganizationVO org) {
		//添加机构
		TOrganization org2 = org.getOrganization();
		organizationDao.add(org2);
		//添加管理员
		TUser user = org.getUser();
		user.setTOrganization(org2);
		user.setUserManagerState(1);
		user.setUserSuperState(0);
		userDao.add(user);
		TRole role = roleDao.findById("BMGLY");
		userRoleDao.add(new TUserRole(role, user));
		return true;
	}

	@Override
	public boolean updateUserPwd(String orgId, String pwd) {
		return userDao.setPwd(orgId, pwd);
	}

	@Override
	public OrgStateVO orgState(String orgId) {
		//求总车辆数
		int totalCarNum = organizationDao.countTotalCar(orgId);
		//求总人数
		int totalPersonNum = organizationDao.countTotalPerson(orgId);
		//求可用车辆数
		int currentCarNum = organizationDao.countCurrentCar(orgId);
		//求可用人数
		int currentPersonNum = organizationDao.countCurrentPerson(orgId);
		return new OrgStateVO(orgId, currentPersonNum, currentCarNum, totalPersonNum, totalCarNum);
	}

	@Override
	public TOrganization showOrganizationById(String orgId) {
		return organizationDao.findById(orgId);
	}

	@Override
	public OrgStateDto orgStateByCode(String orgCode) {
		TOrganization org = organizationDao.findByCode(orgCode);
		String orgId = org.getOrgId();
		//求总车辆数
		int totalCarNum = organizationDao.countTotalCar(orgId);
		//求总人数
		int totalPersonNum = organizationDao.countTotalPerson(orgId);
		//求可用车辆数
		int currentCarNum = organizationDao.countCurrentCar(orgId);
		//求可用人数
		int currentPersonNum = organizationDao.countCurrentPerson(orgId);
		return new OrgStateDto(orgCode,""+ totalPersonNum, ""+currentPersonNum, ""+totalCarNum, ""+currentCarNum,org.getOrgName());
	}

	@Override
	public Workbook createExcel() {
		try {
			return ExcelExportUtil.fillExcelDataWithTemplate(organizationDao.findAllOrg(), "resExporTemplate.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrgStateDto> orgStateByCodeList(List<String> orgCodes) {
		return organizationDao.findByCodes(orgCodes);
	}

}

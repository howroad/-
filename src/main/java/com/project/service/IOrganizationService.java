package com.project.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.project.pojo.TOrganization;
import com.project.util.PageBean;
import com.project.vo.OrgStateDto;
import com.project.vo.OrgStateVO;
import com.project.vo.OrganizationVO;

public interface IOrganizationService {
	/**
	 * 查询区域的PageBean
	 * @param pageNo 查询的页码数
	 * @param pageSize 每页显示的数量
	 * @param orgTypeKey 机构类型
	 * @param AreaKey 区域
	 * @return
	 */
	public PageBean<OrganizationVO> pageBean(int pageNo,int pageSize,String orgTypeKey,String AreaKey);
	/**
	 * 添加机构
	 * @param org 机构VO
	 * @return boolean
	 */
	public boolean addOrg(OrganizationVO org);
	/**
	 * 修改管理员密码
	 * @param orgId 区域Id
	 * @param pwd
	 * @return boolean
	 */
	public boolean updateUserPwd(String orgId,String pwd);
	/**
	 * 显示当前机构的库存状态
	 * @param orgId 机构Id
	 * @return 机构的VO
	 */
	public OrgStateVO orgState(String orgId);
	/**
	 * 根据ID查询机构详情
	 * @param orgId 机构Id
	 * @return 机构的详情
	 */
	public TOrganization showOrganizationById(String orgId);
	/**
	 * 根据组织机构代码号查询 库存状态
	 * @param orgCode
	 * @return 库存状态
	 */
	public OrgStateDto orgStateByCode(String orgCode);
	/**
	 * 生成Excel
	 */
	public Workbook createExcel();
	/**
	 * 批量查询
	 * @param orgCodes
	 * @return
	 */
	public List<OrgStateDto> orgStateByCodeList(List<String> orgCodes);
}

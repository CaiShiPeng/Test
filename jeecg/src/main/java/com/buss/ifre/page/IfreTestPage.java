
package com.buss.ifre.page;
import com.buss.ifre.entity.IfreTestEntity;
import com.buss.test.entity.IfreTestInfoEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

/**   
 * @Title: Entity
 * @Description: test
 * @author onlineGenerator
 * @date 2016-02-19 17:24:25
 * @version V1.0   
 *
 */
public class IfreTestPage implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**更新日期*/
	private java.util.Date updateDate;
	/**用户名*/
    @Excel(name="用户名")
	private java.lang.String name;
	/**密码*/
    @Excel(name="密码")
	private java.lang.String pwd;
	/**tt*/
    @Excel(name="tt")
	private java.lang.String t;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */
	public java.lang.String getPwd(){
		return this.pwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPwd(java.lang.String pwd){
		this.pwd = pwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  tt
	 */
	public java.lang.String getT(){
		return this.t;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  tt
	 */
	public void setT(java.lang.String t){
		this.t = t;
	}

	/**保存-cs*/
    @ExcelCollection(name="cs")
	private List<IfreTestInfoEntity> ifreTestInfoList = new ArrayList<IfreTestInfoEntity>();
		public List<IfreTestInfoEntity> getIfreTestInfoList() {
		return ifreTestInfoList;
		}
		public void setIfreTestInfoList(List<IfreTestInfoEntity> ifreTestInfoList) {
		this.ifreTestInfoList = ifreTestInfoList;
		}
}

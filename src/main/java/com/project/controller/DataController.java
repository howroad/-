/**
 * 
 */
package com.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.IDataService;

/**
 * @author howroad
 * @Date 2018年5月22日
 * @version 1.0
 */
@RestController()
public class DataController {
	@Autowired
	private IDataService dataService;
	@GetMapping("getData1")
	public HashMap<String,Integer> getData1(String year){
		return dataService.getData1(year);
	}
}

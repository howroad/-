/**
 * 
 */
package com.project.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.service.ICodeService;

/**
 * @author howroad
 * @Date 2018年5月22日
 * @version 1.0
 */
@Controller("codeController")
public class CodeController {
	@Autowired
	private ICodeService codeService;
	@GetMapping("code")
	@ResponseBody
	public void getCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		BufferedImage bf = codeService.getImg();
		//获得session
		String code = codeService.getCodeString();
		//放入session
		request.getSession().setAttribute("session_code", code);
        //设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
		//返回图片
        ImageIO.write(bf, "jpg", response.getOutputStream());
	}
	@RequestMapping("checkCode")
	@ResponseBody
	public boolean checkCode(String code,HttpServletRequest request) {
		String sessionCode = (String)request.getSession().getAttribute("session_code");
		if(code==null) {
			return false;
		}
		return code.equalsIgnoreCase(sessionCode);
	}
}

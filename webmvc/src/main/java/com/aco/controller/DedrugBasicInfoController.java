package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.DedrugBasicInfo;
import com.aco.service.DedrugBasicInfoService;
import com.aco.util.PagedResult;

import aco.interceptor.MethodDescription;

@Controller
@RequestMapping("/dedrugBasicInfo")
public class DedrugBasicInfoController extends BaseController {

	@Autowired
	private DedrugBasicInfoService dedrugBasicInfoService;
	private static final String List = "dedrugBasicInfo/dedrugBasicInfoList";
	private static final String ADDPAGE = "dedrugBasicInfo/addDedrugBasicInfo";
	private static final String EDITPAGE = "dedrugBasicInfo/editDedrugBasicInfo";
	private static final String VIEWPAGE = "dedrugBasicInfo/showDedrugBasicInfo";
	private static final String outPrison="outPrison/outPrisonList";
	private static final String editOutPrison="outPrison/editOutPrison";
	private static final String deletePrison="deletePrison/deletePrisonList";
	private static final String editDeletePrison="deletePrison/editDeletePrison";
	private static final String backhome="backhome/backhomeList";
	private static final String editBackhome="backhome/editBackhome";
	private static final String dedrugdetainedInfo="dedrugdetainedInfo/infoList";
	private static final String editDedrugdetainedInfo="dedrugdetainedInfo/editDedrugdetainedInfo";

	@RequestMapping("/list")
	public String list() {
		return List;
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return ADDPAGE;
	}

	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(EDITPAGE);
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/showPage/{id}")
	public ModelAndView showPage(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(VIEWPAGE);
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/outPrisonList")
	public String outPrison(){
		return outPrison;
	}
	@RequestMapping("/editOutPrison/{id}")
	public ModelAndView editOutPrison(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(editOutPrison);
		mav.addObject("id", id);
		return mav;
	}
	@RequestMapping("/deletePrisonList")
	public String deletePrison(){
		return deletePrison;
	}
	@RequestMapping("/editDeletePrison/{id}")
	public ModelAndView editDeletePrison(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(editDeletePrison);
		mav.addObject("id", id);
		return mav;
	}
	@RequestMapping("/backhomeList")
	public String backhome(){
		return backhome;
	}
	@RequestMapping("/editBackhome/{id}")
	public ModelAndView editBackhome(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(editBackhome);
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/infoList")
	public String dedrugdetainedInfo(){
		return dedrugdetainedInfo;
	}
	
	@RequestMapping("/editDedrugdetainedInfo/{id}")
	public ModelAndView editDedrugdetainedInfo(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(editDedrugdetainedInfo);
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(DedrugBasicInfo dedrugBasicInfo) {
		return dedrugBasicInfoService.addDedrugBasicInfo(dedrugBasicInfo);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public String edit(DedrugBasicInfo dedrugBasicInfo) {
		return dedrugBasicInfoService.editDedrugBasicInfo(dedrugBasicInfo);
	}

    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(dedrugBasicInfoService.findDedrugBasicInfo(id).get(0));
    }
    
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return dedrugBasicInfoService.deleteDedrugBasicInfo(id);
	}
	@RequestMapping("/findDedrugBasicInfoList")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String list(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryByPage(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
	
	@RequestMapping("/selectByOut")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String outList(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryOut(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
	
	@RequestMapping("/selectByDelete")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String deleteList(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryDelete(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
	
	@RequestMapping("/selectInPrison")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String inPrisonList(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryInPrison(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
	
	@RequestMapping("/selectInPrisonTalk")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String inPrisonTalkList(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryInPrisonTalk(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}
	
	@RequestMapping("/selectIntalk")
    @MethodDescription(value = "分页查询病室号列表", opeartion = "search")
	@ResponseBody
	public String selectIntalk(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryIntalk(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}

}

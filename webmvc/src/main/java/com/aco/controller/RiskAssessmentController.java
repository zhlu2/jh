package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.RiskAssessment;
import com.aco.service.RiskAssessmentService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/riskAssessment")
public class RiskAssessmentController extends BaseController{

	@Autowired
	private RiskAssessmentService riskAssessmentService;
	
	private final static String List="riskAssessment/riskAssessmentList";
	private final static String ADDPAGE="riskAssessment/addRiskAssessment";
	private final static String EDITPAGE="riskAssessment/editRiskAssessment";
	private final static String riskDirectorList="riskDirector/riskDirectorList";
	private final static String editRiskDirector="riskDirector/editRiskDirector";
	private final static String riskDepartmentList="riskDirector/riskDepartmentList";
	private final static String editriskDepartment="riskDirector/editriskDepartment";
	private final static String viewPage="riskAssessment/viewpage";
	
	@RequestMapping("/list")
	public String List(){
		return List;
	}
	@RequestMapping("/addpage")
	public String addPage(){
		return ADDPAGE;
	}
	
	@RequestMapping("/riskDirectorList")
	public String riskDirectorList(){
		return riskDirectorList;
	}
	
	@RequestMapping("/riskDepartmentList")
	public String riskDepartmentList(){
		return riskDepartmentList;
	}
	
	@RequestMapping("/editriskDepartment/{id}")
	public ModelAndView editriskDepartment(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(editriskDepartment);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/viewPage/{id}")
	public ModelAndView viewPage(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(viewPage);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/editRiskDirector/{id}")
	public ModelAndView editRiskDirector(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(editRiskDirector);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(EDITPAGE);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(RiskAssessment riskAssessment){
		return riskAssessmentService.addRiskAssessment(riskAssessment);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(RiskAssessment riskAssessment){
		return riskAssessmentService.editRiskAssessment(riskAssessment);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return riskAssessmentService.deleteRiskAssessment(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(riskAssessmentService.findRiskAssessment(id).get(0));
    }
    
    @RequestMapping("/findRiskAssessmentList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<RiskAssessment> pageResult = riskAssessmentService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
    
    @RequestMapping("/findRiskDepartmentList")
    @ResponseBody
    public String findRiskDepartmentList(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<RiskAssessment> pageResult = riskAssessmentService.queryByPageForRiskDepartmentList(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
    
    @RequestMapping("/findRiskDirector")
    @ResponseBody
    public String findRiskDirector(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<RiskAssessment> pageResult = riskAssessmentService.queryByPageForDirector(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}

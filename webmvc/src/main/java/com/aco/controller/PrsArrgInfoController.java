package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.PoliceBasicInfo;
import com.aco.model.PrsArrgInfo;
import com.aco.service.PoliceBasicInfoService;
import com.aco.service.PrsArrgInfoService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/prsArrgInfo")
public class PrsArrgInfoController extends BaseController{

	@Autowired
	private PrsArrgInfoService prsArrgInfoService;
	
	private final static String List="prsArrgInfo/prsArrgInfoList";
	private final static String ADDPAGE="prsArrgInfo/addPrsArrgInfo";
	private final static String EDITPAGE="prsArrgInfo/editPrsArrgInfo";
	
	@RequestMapping("/list")
	public String List(){
		return List;
	}
	@RequestMapping("/addpage")
	public String addPage(){
		return ADDPAGE;
	}
	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(EDITPAGE);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(PrsArrgInfo prsArrgInfo){
		return prsArrgInfoService.addPrsArrgInfo(prsArrgInfo);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(PrsArrgInfo prsArrgInfo){
		return prsArrgInfoService.editPrsArrgInfo(prsArrgInfo);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return prsArrgInfoService.deletePrsArrgInfo(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(prsArrgInfoService.findPrsArrgInfo(id).get(0));
    }
    
    @RequestMapping("/findPrsArrgInfoList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<PrsArrgInfo> pageResult = prsArrgInfoService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}

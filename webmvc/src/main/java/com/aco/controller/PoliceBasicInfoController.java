package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.PoliceBasicInfo;
import com.aco.service.PoliceBasicInfoService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/policeBasicInfo")
public class PoliceBasicInfoController extends BaseController{

	@Autowired
	private PoliceBasicInfoService policeBasicInfoService;
	
	private final static String List="policeBasicInfo/policeList";
	private final static String ADDPAGE="policeBasicInfo/addPolice";
	private final static String EDITPAGE="policeBasicInfo/editPolice";
	
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
	public String add(PoliceBasicInfo policeBasicInfo){
		return policeBasicInfoService.addPoliceBasicInfo(policeBasicInfo);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(PoliceBasicInfo policeBasicInfo){
		return policeBasicInfoService.editPoliceBasicInfo(policeBasicInfo);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return policeBasicInfoService.deletePoliceBasicInfo(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(policeBasicInfoService.findPolice(id).get(0));
    }
    
    @RequestMapping("/findPoliceBasicInfoList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<PoliceBasicInfo> pageResult = policeBasicInfoService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}

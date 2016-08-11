package de.hegmanns.spring.schulung.k002;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@Scope("request")
public class HalloWeltController implements BeanNameAware{
	private static final Logger LOG = Logger.getLogger(HalloWeltController.class);

	private int count = 0;
	private String beanName;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping("/request_session")
	public String requestForSession(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_SESSION, HalloWelt.class);
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/request_session_increment")
	public String requestForSessionIncrement(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_SESSION, HalloWelt.class);
		halloWelt.setMessage("request number '" + count + "'");
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/request_request")
	public String requestForRequest(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_REQUEST, HalloWelt.class);
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/request_request_increment")
	public String requestForRequestIncrement(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_REQUEST, HalloWelt.class);
		halloWelt.setMessage("request number '" + count + "'");
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/request_global")
	public String requestForGlobal(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_GLOBALSESSION, HalloWelt.class);
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping({"/start*", "/"})
	public String request(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_GLOBALSESSION, HalloWelt.class);
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/request_global_increment")
	public String requestForGlobalIncrement(Model model, HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		
		HalloWelt halloWelt = applicationContext.getBean(Configuration.BEAN_GLOBALSESSION, HalloWelt.class);
		halloWelt.setMessage("request number '" + count + "'");
		model.addAttribute("hallowelt_counter", halloWelt.getMessage());
		
		return "start";
	}
	
	@RequestMapping("/invalidate_session")
	public String invalidateSession(HttpServletRequest request){
		LOG.info(request.getRequestURI());
		
		incrementAndLogCounter();
		request.getSession().invalidate();
		
		return "start";
	}
	
	private void incrementAndLogCounter(){
		count++;
		LOG.info("count incremented to " + count);
	}
	
	@PostConstruct
	public void constructHook(){
		LOG.info("HalloWelt-Bean '" + beanName + " instance " + this.hashCode() + " was created");
	}
	
	@PreDestroy
	public void destroyHook(){
		LOG.info("HalloWelt-Bean '" + beanName + " instance " + this.hashCode() + " will be destroyed");
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}

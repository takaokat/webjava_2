package jp.co.systena.tigerscave.kadai2.application.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.kadai2.application.model.Brave;
import jp.co.systena.tigerscave.kadai2.application.model.Charaform;
import jp.co.systena.tigerscave.kadai2.application.model.Cmdform;
import jp.co.systena.tigerscave.kadai2.application.model.Warrior;
import jp.co.systena.tigerscave.kadai2.application.model.Witch;
import jp.co.systena.tigerscave.kadai2.application.model.Work;

@Controller
public class SelectCharacterController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/Select", method = RequestMethod.GET) // URLとのマッピング
	public ModelAndView sel(ModelAndView mav) {

		mav.setViewName("SelectCharacter");
		mav.addObject("CharaObj",new Charaform());

		return mav;
	}

	@RequestMapping(value = "/Cmd", method = RequestMethod.POST) // URLとのマッピング
	public ModelAndView cmd(ModelAndView mav,@ModelAttribute Charaform form) {

		Work work1 = (Work) session.getAttribute("workObj1");
		Work work2 = (Work) session.getAttribute("workObj2");

		if(form.getWork1().equals("戦士")) {
		  work1 = new Brave();
		}else if(form.getWork1().equals("魔法使い")){
		  work1 = new Witch();
		}else if(form.getWork1().equals("武闘家")){
		  work1 = new Warrior();
		}
        if(form.getWork2().equals("戦士")) {
          work2 = new Brave();
        }else if(form.getWork2().equals("魔法使い")){
          work2 = new Witch();
        }else if(form.getWork2().equals("武闘家")){
          work2 = new Warrior();
        }
		work1.setName(form.getName1());
        work2.setName(form.getName2());
		session.setAttribute("workObj1", work1);
        session.setAttribute("workObj2", work2);

		mav.setViewName("Cmd");
		mav.addObject("cmdform" , form);

		return mav;
	}

    @RequestMapping(value = "/Result", method = RequestMethod.POST) // URLとのマッピング
    public ModelAndView resAttack(ModelAndView mav,@ModelAttribute Cmdform form) {

		Work work1 = (Work) session.getAttribute("workObj1");
		Work work2 = (Work) session.getAttribute("workObj2");

		if(form.getCmd1().equals("たたかう")) {
		    work1.setActionAttack();
		}else if(form.getCmd1().equals("かいふく")) {
		  work1.setActionHeal();
		}

		if(form.getCmd2().equals("たたかう")) {
		  work2.setActionAttack();
		}else if(form.getCmd2().equals("かいふく")) {
		  work2.setActionHeal();
		}

		mav.addObject("workObj1",work1);
		mav.addObject("workObj2",work2);

		return mav;
    }

}
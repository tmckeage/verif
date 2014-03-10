package verif;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/addy")
public class AddressController {

  public AddressController(){
    System.out.println("init AddressController");
  } 

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ReturnAddress get(HttpServletResponse res) {
 
      ReturnAddress ad = new ReturnAddress();
      return ad;
  }

  @RequestMapping(value="sAddress", method = RequestMethod.POST)
  public @ResponseBody ReturnAddress post( @RequestBody final SubmitAddress sAddress) {    
    return new ReturnAddress(sAddress);
  }
}
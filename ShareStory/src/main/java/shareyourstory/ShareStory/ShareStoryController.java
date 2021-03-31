package shareyourstory.ShareStory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShareStoryController {

    @GetMapping("/podijeliPricu")
    public String shareStory(){
        return "podijeliPricu.html";
    }
}

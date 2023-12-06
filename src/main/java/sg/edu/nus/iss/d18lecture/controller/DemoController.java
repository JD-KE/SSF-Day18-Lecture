package sg.edu.nus.iss.d18lecture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/demo")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        try {
            return new ResponseEntity<>("Hello!!! Springboot is okay...", HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>("Error running Springboot...", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    
    // will not work (see with docker container ps and check status) if status code not set or returned
    @GetMapping(path="/healthz")
    public ModelAndView getHealthz() {
        ModelAndView mav = new ModelAndView();
        try {
            // checkHealth();
            mav.setViewName("healthy");
            // apparently works without code below??? maybe because sucessful get is 200?
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }
        return mav;
    }
    
}

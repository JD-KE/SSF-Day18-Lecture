package sg.edu.nus.iss.d18lecture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.d18lecture.model.Announcement;
import sg.edu.nus.iss.d18lecture.service.AnnouncementService;

@Controller
@RequestMapping("announcements")
public class AnnouncementController {
    @Autowired AnnouncementService announcementSvc;

    @GetMapping("/create")
    public String announcementCreateForm(Model model) {
        model.addAttribute("announcement", new Announcement());
        return "announcementcreate";
    }

    @PostMapping("/processAnnouncement")
    public String postAnnouncement(@Valid @ModelAttribute("announcement") Announcement announcement, BindingResult result) {

        if (result.hasErrors()) {
            return "announcementcreate";
        }
        System.out.printf("ID: %d, Code: %s, Title: %s, message: %s, startDate: %s\n",
        announcement.getAnnId(),announcement.getCode(),announcement.getTitle(),announcement.getMessage(), announcement.getStartDate().toString());
        return "announcementcreate";
    }
    
}

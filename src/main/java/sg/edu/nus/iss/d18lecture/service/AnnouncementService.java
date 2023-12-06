package sg.edu.nus.iss.d18lecture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.d18lecture.model.Announcement;

@Service
public class AnnouncementService {

    List<Announcement> announcements = new ArrayList<>();

    public AnnouncementService() {
        if (announcements == null) {
            announcements = new ArrayList<>();
        }
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }
}

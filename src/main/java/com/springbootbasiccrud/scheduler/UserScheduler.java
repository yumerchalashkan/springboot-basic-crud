package com.springbootbasiccrud.scheduler;

import com.springbootbasiccrud.entity.User;
import com.springbootbasiccrud.repository.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserScheduler {

    private UserRepository userRepository;

    public UserScheduler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(fixedRate = 2000)
    public void addJob(){
        User u = new User();
        u.setFirstName("emre");
        u.setFamilyName("soyisim");
        u.setUpdatedTime(new Date());
        userRepository.save(u);
        System.out.println("Added new user");
    }
}

package com.template.spring.user.application.events.listeners;

import com.template.spring.application.events.UserCredentialsCreatedEvent;
import com.template.spring.user.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsCreatedEventListener implements ApplicationListener<UserCredentialsCreatedEvent> {
    private UserProfileService userProfileService;

    public UserCredentialsCreatedEventListener(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @Override
    public void onApplicationEvent(@Valid UserCredentialsCreatedEvent event) {
        userProfileService.create(event.getUserId(), event.getUsername());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}

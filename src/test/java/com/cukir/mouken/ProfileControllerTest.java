package com.cukir.mouken;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class ProfileControllerTest {

    @Test
    public void real_profile_list () {
        //given
        String expectedProfile = "ops";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("ops-db");

        ProfileController controller = new ProfileController(env);
        String profile = controller.profile();

        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }
}
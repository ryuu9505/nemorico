package com.cukir.mouken;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

class ProfileControllerUnitTest {

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

    @Test
    public void real_profile이_없으면_첫번째가조회된다() {
        //given
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("ops-db");
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile없으면default조회된다() {
        //given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();

        //then
        Assertions.assertThat(profile).isEqualTo(expectedProfile);

    }
}
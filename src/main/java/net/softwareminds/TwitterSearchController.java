package net.softwareminds;

import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/")
public class TwitterSearchController {

    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    private Environment env;

    @Inject
    public TwitterSearchController(Environment env) {
        this.env = env;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloTwitter(Model model) {
        Twitter twitter = new TwitterTemplate(env.getProperty("SPRING_SOCIAL_TWITTER_API"),
                env.getProperty("SPRING_SOCIAL_TWITTER_APPSECRET"));

        return "searchResults";
    }

}

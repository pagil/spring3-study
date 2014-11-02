package au.org.test.spring.boot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Userful URLs:
// http://spring.io/guides/gs/rest-service/
// http://www.byteslounge.com/tutorials/spring-mvc-requestmapping-example
// http://stackoverflow.com/questions/5917082/regular-expression-to-match-numbers-with-or-without-commas-and-decimals-in-text
// http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, mister " + name + "!";
    }

    @RequestMapping(value = "/show/{id:\\d+(?:,\\d+)*}")
    public String showId(@PathVariable String id) {
        System.out.println(id);
        return "Your ID " + id + "!";
    }
}

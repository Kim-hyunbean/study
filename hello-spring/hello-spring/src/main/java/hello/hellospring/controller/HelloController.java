package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class HelloController {
    //getpost
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return  "hello"; // 키 : data , 값 : hello!!
    }            //hello.html

    @GetMapping("hello-mvc") //템플릿엔진 방식
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    } // hello-mvc?name=spring! name=spring!


    @GetMapping("hello-string")
    @ResponseBody //http body 부분에 넣겟다
    public String helloString(@RequestParam("name") String name) {
        return  "hello " + name;
    } //데이터를 그대로 내려주는 방법

    @GetMapping("hello-api") //최근엔 이방식 사용 json이용
    @ResponseBody //api방식
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private  String name;
        //꺼낼때 getName
        public String getName() {
            return name;
        }
        //사용할때 setname
        public void setName(String name) {
            this.name = name;
        }

    }
}

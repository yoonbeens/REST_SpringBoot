package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//RestController = @Controller + @ResponseBody
@RequiredArgsConstructor
@Controller //주석 처리시 404 
public class HelloController {
	
    @GetMapping("/hello")
    @ResponseBody //@Controller일 때 주석 처리 시 500
//  @RequestBody가 JSON을 Entity로 자동으로 바꿔준다(이게 DI다)
    public String hello() {
        return "Hello World Spring boot";
    }
    
    
    //@Autowired와 User user = new user;을 할 필요가 없다
    //@RAC아노테이션과 UserRepository으로 알아서 해준다
    private final UserRepository userRepository;
    
    @GetMapping("/list")
    public String list(Model model) {
    	List<User> userList = this.userRepository.findAll();
    	model.addAttribute("userList", userList);
    	return "user_list";
  }
   
    
    @GetMapping("/list/{id}")
    @ResponseBody
    public String list_id(@PathVariable("id") Integer id) {
//    	List<User> userList = this.userRepository.findAll();
//    	model.addAttribute("userList", userList);
    	System.out.println(id);
    	
    	//모델과 타임리프 없이도 @ResponseBody가 있으면 바로 넘길 수 있다
    	return String.format("%d", id);
  }
    
    @GetMapping("/listdb/{id}")
    @ResponseBody
    public User list_id_db(@PathVariable("id") Integer id) {
    	
    	User user;
    	Optional<User> finded_user = this.userRepository.findById(id);
    	user = finded_user.get();
    	
    	return user;
  }
    
    @GetMapping("/listdbth/{id}")
    public String list_id_dbth(Model model, @PathVariable("id") Integer id) {
    	
    	User user;
    	Optional<User> finded_user = this.userRepository.findById(id);
    	user = finded_user.get();
    	model.addAttribute("user_key", user);

    	return "user_list";
  }
    
    @PostMapping("/userdb/create")
    @ResponseBody
    public String create_userdb(@RequestBody User newUser) {
    
    	User created_user = this.userRepository.save(newUser);

    	return "created_user";
    }
    
    
    
    
}










package me.silvernine.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import me.silvernine.tutorial.entity.User;
import me.silvernine.tutorial.service.UserService;

@Component
public class UserGraphQL  implements GraphQLQueryResolver, GraphQLMutationResolver  {
	
	@Autowired
	private Environment env;
    
    @Autowired
    UserService userService;
    
    public User user(Long id) {
        User tio = new User();
        if(userService.existsById(id)){
        	tio = userService.findById(id).get();
        }
        return tio;
    }

    public List<User> getUsers() {
        List<User> list = userService.findAll();
        return list;
    }

    public User saveUser(UserInput input) {
        User user = new User();
        ModelMapper m = new ModelMapper();
        user = m.map(input,User.class);
        if(userService.save(user))
            return user;
        return user;
    }

    public Boolean deleteUser(Long id) {
        try{
        	userService.deleteUser(id);
            return true;
        }catch(Exception ex){

        }
        return false;
    }
}

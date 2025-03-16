package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.model.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IService<User,Long> {

private final UserRepository userRepository;


  @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
    return userRepository.save(user);
    }

    @Override
    public User read(Long Id) {
        return userRepository.findById(Id).orElse(null);
    }

    @Override
    public User update(User user) {
      if(userRepository.existsById(user.getUserId()))
        return userRepository.save(user);
      throw new IllegalArgumentException("User with ID: "+ user.getUserId()+ " does not exist") ;
    }

    @Override
    public boolean delete(Long userId) {
      if(userRepository.existsById(userId))
         userRepository.deleteById(userId);
      else
          throw new IllegalStateException("User " + userId + " not found");
        return false;
    }

    @Override
    @RequestMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }
}

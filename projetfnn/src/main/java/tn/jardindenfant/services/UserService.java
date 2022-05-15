package tn.jardindenfant.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.jardindenfant.entities.User;


public interface UserService {
	List<User> retrieveAllUsers();
    User addUser(User u);
	void deleteUser(Long id);
	User updateUser(User u);
	User retrieveUser(Long id);
	public String doHashing(String psw);
	public void saveImage(MultipartFile  file);

}
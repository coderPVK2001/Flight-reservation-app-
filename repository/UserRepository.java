package com.flight_reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_reservation_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);    // findByEmail is convention /method findByEmail is not present /getByEmail can also work
	
	//after entering email in login page it searches it in database & if record is found it will create user object 
	//user object reference will return the method from place from where it is called
	//findByEmail finds record by help of jparepository and that method is going to return it back to usercontroller layer and capture that in user variable
    
}

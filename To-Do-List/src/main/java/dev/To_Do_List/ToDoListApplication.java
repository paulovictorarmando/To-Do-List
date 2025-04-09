package dev.To_Do_List;

import java.util.Optional;
import java.util.Scanner;

import dev.To_Do_List.models.User;
import dev.To_Do_List.repositories.UserRepository;
import dev.To_Do_List.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		do {
			System.out.println("Sign in [0] \nSign up [1] \nExit [2]");
			System.out.print("Option: ");
			int option = scan.nextInt();
			switch (option)
			{
				case 0:
					signin();
					break;
				case 1:
					signup();
					break;
				case 2:
					System.out.println("Bye!");
					return;
				default:
					System.out.println("Wrong option, please choose between 0 and 1");
			}
		} while(true);
	}
	public void signup()
	{
		System.out.print("Name: ");
		String name = scan.next();
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("Password: ");
		String password = scan.next();
		userService.sign_up(name, email, password);
	}
	public void signin()
	{
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("Password: ");
		String password = scan.next();
		boolean session = userService.sign_in(email, password);
		if(!session)
			return;
		index(session, email);
	}
	public void index(boolean session, String email){
		Optional<User> user = userRepository.findByEmail(email);
		while(session)
		{
			System.out.println("____________MENU_______________");
			System.out.println("[0] Tasks");
			System.out.println("[1] Add new task");
			System.out.println("[2] Remove Task");
			System.out.println("[3] Log Out");
			System.out.print("Option: ");
			int option = scan.nextInt();
			switch (option){
				//case 0:
					//show_task(user.get().getId());
			//	case 1:
					//add_task(user.get().getId());
			//	case 2:
					//remove_task(user.get().getId());
				case 3:
					session = false;
					break;
				default:
					System.out.println("Invalid option!");
					break;
			}
		}
	}
}

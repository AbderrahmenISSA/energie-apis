package fr.energie.billing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.energie.billing.domain.Person;
import fr.energie.billing.dto.PersonDTO;
import fr.energie.billing.repos.PersonRepository;
import fr.energie.billing.utils.PersonDtoUtils;

@RestController
@RequestMapping(path = B2CController.B2C_V1)
public class B2CController {

	protected static final String B2C_V1 = "v1/b2c";

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("person")
	public RestResponse index(@RequestParam("reference") Optional<String> reference) {
		
		// find All
		if (!reference.isPresent()) {
			List<Person> result = personRepository.findAll();
			List<PersonDTO> persons = PersonDtoUtils.convertToDTOs(result);
			return new RestResponse(HttpStatus.OK.value(), persons);
		}
		
		// find by reference
		Optional<Person> personOptional = personRepository.findByCustomerReference(reference.get());
		
		// Check user existence
		if (personOptional.isEmpty()) {
			RestError error = new RestError();
			error.setError("Couldn’t find Personal Account.");
			error.setMessage("No Personal Account found with the reference " + reference.get() + " !");
			return new RestResponse(HttpStatus.BAD_REQUEST.value(), error);
		}

		PersonDTO result = PersonDtoUtils.convertToDTO(personOptional.get());
		return new RestResponse(HttpStatus.OK.value(), result);
	}

//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable String id) {
//		userRepository.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}
//
//	@PostMapping
//	public RestResponse create(@RequestBody UserDTO dto) {
//		if (StringUtils.isEmpty(dto.getPassword())) {
//			dto.setPassword(DEFAULT_PASSWORD);
//		}
//
//		if (dto.getIsAdmin() == null) {
//			dto.setIsAdmin(false);
//		}
//
//		// Check username existence
//		Optional<User> userOptional = userRepository.findByUsername(dto.getUsername());
//		if (userOptional.isPresent()) {
//			RestError error = new RestError();
//			error.setError("A user account exists with the same username.");
//			error.setMessage("Can't create a user account with the username " + dto.getUsername() + "!");
//			return new RestResponse(HttpStatus.BAD_REQUEST.value(), error);
//		}
//
//		User user = (User) DTOUtils.convertToEntity(dto);
//
//		// set created
//		user.setCreated(LocalDateTime.now());
//
//		UserDTO result = (UserDTO) DTOUtils.convertToDTO(userRepository.save(user), "password");
//		return new RestResponse(HttpStatus.CREATED.value(), result);
//	}

}
